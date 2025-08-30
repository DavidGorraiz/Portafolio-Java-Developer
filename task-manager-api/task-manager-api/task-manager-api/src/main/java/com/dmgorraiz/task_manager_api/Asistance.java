package com.dmgorraiz.task_manager_api;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Asistance {

    @UserMessage("""
            Genera un saludo a una aplicacionde control de tareas.
            Usa un estilo detallado pero concreto en un solo parrafo.
            """)
    String generateGreeting();
}
