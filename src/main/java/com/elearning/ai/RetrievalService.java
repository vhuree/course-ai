package com.elearning.ai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.text.MessageFormat;
import java.util.Arrays;


@Service
public class RetrievalService {

    ChatLanguageModel chatLanguageModel;

    @Value("${ai.definition-template}")
    private String template;

    public RetrievalService(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;
    }

    public  String fetchDefinition(String vocabulary) {

        String response = chatLanguageModel.generate(MessageFormat.format(template, vocabulary));
        System.out.println(response);

        String[] lines = response.split("\n");
        System.out.println(lines.length);

        System.out.println(Arrays.toString(lines));
        return response;
    }

}
