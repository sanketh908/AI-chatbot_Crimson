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
    @Column(unique = true, nullable = false)
    private Long chatId;
    @Column(nullable = false)
    @OneToMany(mappedBy = "chat",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PromptEntity> prompts;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

}
