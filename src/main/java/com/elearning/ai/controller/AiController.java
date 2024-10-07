package com.elearning.ai.controller;

import com.elearning.ai.RetrievalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/query")
public class AiController {
    private final RetrievalService retrievalService;

    public AiController(RetrievalService retrievalService) {
        this.retrievalService = retrievalService;
    }

    @GetMapping("/definition")
    public String getDefinition(@RequestParam String vocabulary) {
        return retrievalService.fetchDefinition(vocabulary);
    }
}
