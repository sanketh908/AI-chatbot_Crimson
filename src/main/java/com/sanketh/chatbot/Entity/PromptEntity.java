package com.sanketh.chatbot.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PromptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promptId;
    private String base64img;
    private String promptText;
    private String responseText;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatId")
    private ChatEntity chat;
}
