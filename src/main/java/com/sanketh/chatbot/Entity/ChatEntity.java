package com.sanketh.chatbot.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long chatId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PromptEntity> prompts;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

}
