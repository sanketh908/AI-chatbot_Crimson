package com.sanketh.chatbot.Controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ChatController {
    private final ChatClient chatClient;

    public ChatController( ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String  message){

        return chatClient.prompt().user(message).call().content();
    }
}
