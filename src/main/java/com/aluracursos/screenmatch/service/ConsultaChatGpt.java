package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGpt {

    public static String obtenerTraduccion (String texto){
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .prompt("Traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}
