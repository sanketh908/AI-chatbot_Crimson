package com.sanketh.chatbot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Userid;
    private String username;
    private String password;
    private String email;
    private String role;
    private List<>
}
