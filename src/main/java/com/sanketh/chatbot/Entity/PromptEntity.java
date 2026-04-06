package com.sanketh.chatbot.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PromptEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promptId;
    @Column(name = "base64img")
    private String base64img;
    @Column(name = "promptText",columnDefinition = "TEXT")
    private String promptText;
    @Column(name = "responseText",columnDefinition = "TEXT")
    private String responseText;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatId")
    private ChatEntity chat;
}
