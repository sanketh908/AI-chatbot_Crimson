package com.sanketh.chatbot.Service;

import com.sanketh.chatbot.Entity.UserEntity;
import com.sanketh.chatbot.Security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsStorage {
    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("No authenticated user");
        }

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return UserPrincipal.
    }
