package com.sanketh.chatbot.Service;

import com.sanketh.chatbot.DTO.ChatRequest;
import com.sanketh.chatbot.DTO.ChatResponse;
import com.sanketh.chatbot.Entity.ChatEntity;
import com.sanketh.chatbot.Entity.PromptEntity;
import com.sanketh.chatbot.Entity.UserEntity;
import com.sanketh.chatbot.Repository.ChatRepository;
import com.sanketh.chatbot.Repository.PromptRepository;
import com.sanketh.chatbot.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatServiceImpl  implements ChatService{
private final ChatRepository chatRepository;
private final UserRepository userRepository;
private final PromptRepository promptRepository;
private final ChatModel chatModel;


    public ChatServiceImpl(ChatRepository chatRepository, UserRepository userRepository, PromptRepository promptRepository, ChatModel chatModel) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
        this.promptRepository = promptRepository;
        this.chatModel = chatModel;
    }



    @Transactional
    @Override
    public ChatResponse getChatRequest(UserEntity user, ChatRequest chatRequest,String newPrompt) {
        String resp = chatModel.call(newPrompt);
        if (resp != null) {
            if (chatRequest.getChatId() == null) {
                ChatEntity chatEntity = new ChatEntity();
                PromptEntity promptEntity = new PromptEntity();
                promptEntity.setPromptText(chatRequest.getPrompt());
                promptEntity.setResponseText(resp);
                promptEntity.setBase64img(chatRequest.getBase64img());
                promptEntity.setChat(chatEntity);
                chatEntity.setUser(user);
                chatEntity.getPrompts().add(promptEntity);
                ChatEntity savedChatEntity= chatRepository.save(chatEntity);
                PromptEntity savedPromptEntity =promptRepository.save(promptEntity);
                return new ChatResponse(savedChatEntity.getChatId(), savedPromptEntity.getPromptId(),resp);

            } else {
                Optional<ChatEntity> chatEntityOptional = chatRepository.findById(chatRequest.getChatId());
                if (chatEntityOptional.isPresent()) {
                    ChatEntity chatEntity = chatEntityOptional.get();
                    PromptEntity promptEntity = new PromptEntity();
                    promptEntity.setPromptText(chatRequest.getPrompt());
                    promptEntity.setResponseText(resp);
                    promptEntity.setBase64img(chatRequest.getBase64img());
                    promptEntity.setChat(chatEntity);
                    chatEntity.getPrompts().add(promptEntity);
                    chatRepository.save(chatEntity);
                    promptRepository.save(promptEntity);
                    ChatEntity savedChatEntity= chatRepository.save(chatEntity);
                    PromptEntity savedPromptEntity =promptRepository.save(promptEntity);
                    return new ChatResponse(savedChatEntity.getChatId(), savedPromptEntity.getPromptId(),resp);
                } else {
                    throw new RuntimeException("Chat not found with id: " + chatRequest.getChatId());
                }
            }


        } else {
            throw new RuntimeException("Chat not found with id: " + chatRequest.getChatId());
        }


    }

    @Override
    public ChatEntity getChat(Long id) {
      return   chatRepository.findById(id).orElseThrow(() -> new RuntimeException("Chat not found with id: " + id));

    }
}
