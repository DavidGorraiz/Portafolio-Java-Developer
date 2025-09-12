package com.dmgorraiz.task_manager_api.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Asistance {

    @UserMessage("""
            Genera un saludo a una aplicacionde control de tareas llamada {{plataform}}.
            Usa un estilo detallado pero concreto en un solo parrafo.
            """)
    String generateGreeting(@V("plataform") String plataform);

    @UserMessage("""
            Eres un experto administrador de tareas genera un resumen segun las tareas que tenga asignado el usuario llamado {{username}}.
            Si el usuario tiene varias tareas para la semana actual mustra unicamente esas, sino muestra el resumen completo por mes de las tareas que tiene el usuario. 
            Tambien distingue los estados de la tarea como OPEN o IN_POGRESS  y dile al usuario cuantas tareas tiene pendientes y cuantas ha completado.
            """)
    String generateSummary(@V("username") String username);
}
