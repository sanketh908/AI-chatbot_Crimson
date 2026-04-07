package com.sanketh.chatbot.Service;

import com.sanketh.chatbot.DTO.ChatRequest;
import com.sanketh.chatbot.DTO.ChatResponse;
import com.sanketh.chatbot.Entity.ChatEntity;
import com.sanketh.chatbot.Entity.UserEntity;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;

public interface ChatService {


    @Transactional
    ChatResponse getChatRequest(UserEntity user, ChatRequest chatRequest,String newPrompt);

    ChatEntity getChat(Long id);
}
