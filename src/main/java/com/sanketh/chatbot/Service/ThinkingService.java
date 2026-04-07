package com.sanketh.chatbot.Service;

import com.sanketh.chatbot.DTO.ChatRequest;
import com.sanketh.chatbot.DTO.ChatResponse;
import com.sanketh.chatbot.Entity.ChatEntity;
import com.sanketh.chatbot.Repository.ChatRepository;
import com.sanketh.chatbot.Repository.PromptRepository;
import com.sanketh.chatbot.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThinkingService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final PromptRepository promptRepository;

    public ThinkingService(ChatRepository chatRepository, UserRepository userRepository, PromptRepository promptRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
        this.promptRepository = promptRepository;
    }
    public ChatResponse  getChatResponse(ChatRequest chatRequest){



    }
}
