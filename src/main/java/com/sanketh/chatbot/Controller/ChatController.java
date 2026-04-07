package com.sanketh.chatbot.Controller;


import com.sanketh.chatbot.DTO.ChatRequest;
import com.sanketh.chatbot.DTO.ChatResponse;
import com.sanketh.chatbot.Service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {
    private final  ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/send")
public ResponseEntity<?> getChatResponse(@RequestBody ChatRequest chatRequest) {
    return ResponseEntity.ok(chatService.getChatResponse(chatRequest));

    }
    @GetMapping("/user/getChatbychatId/{id}")
    public ResponseEntity<?> getChatResponse(@PathVariable Long id) {
        return ResponseEntity.ok(chatService.getChat(id));
    }
    @GetMapping("/user/getAllChats")
            public ResponseEntity<?> getAllChats()
    {
        return ResponseEntity.ok(chatService.getAllChats());
    }
    @DeleteMapping("/user/deleteChatById/{id}")
    public ResponseEntity<?> deleteChatById(@PathVariable Integer id) {
        return ResponseEntity.ok(chatService.deleteChatById(id));
    }


}
