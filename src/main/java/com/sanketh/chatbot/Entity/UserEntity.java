package com.sanketh.chatbot.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long Userid;
    private String username;
    @Column(nullable = false,name = "Password")
    private String password;
    @Column(name = "Email",unique = true,nullable = false)
    private String email;
    @Column(name = "Role")
    private String role;
    @OneToMany(mappedBy = "user",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<ChatEntity> chats;
}
