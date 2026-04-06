package com.sanketh.chatbot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResetTokenEntity {
    @Id
    private Long id;
    private String token;
    private LocalDateTime expiryDate;


}
