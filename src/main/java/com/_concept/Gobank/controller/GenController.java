package com._concept.Gobank.controller;

import com._concept.Gobank.model.ChatService;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.OpenOption;

@RestController
public class GenController {
    ChatService chatService;
    public GenController(ChatService chatService) {
        this.chatService = chatService;
    }
    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);


    }




}
