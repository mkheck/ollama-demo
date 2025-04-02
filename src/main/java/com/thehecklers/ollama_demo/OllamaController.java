package com.thehecklers.ollama_demo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {
    private final ChatClient client;

    public OllamaController(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @GetMapping
    public String chat(@RequestParam String message) {
        return client.prompt()
                .user(message)
                .call()
                .content();
    }
}
