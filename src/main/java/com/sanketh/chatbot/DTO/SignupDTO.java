package com.sanketh.chatbot.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupDTO {
    @NotBlank(message = "Username cannot be blank.")
    @Size(min = 3, max = 20,message = "Username must be between 3 and 20 characters.")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username must be alphanumeric and underscore characters only.")
    private String username;
    @NotBlank(message = "Password cannot be blank.")
    @Size(min = 8, max = 20,message = "Password must be between 8 and 20 characters.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{8,20}$",
            message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password;
    @NotBlank(message = "Email cannot be blank.")
    @Email
    private String email;
}
