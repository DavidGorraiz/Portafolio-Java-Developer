# 🗂️ Task Manager API

## Demo

URL: https://www.youtube.com/watch?v=4xVJPdqbq90

## 📖 Breve descripción  

Aplicación web de **gestión de tareas** que permite a los usuarios organizar sus actividades de forma sencilla, colaborativa y accesible desde cualquier dispositivo.  

Incluye:
- Auditoría sobre qué usuarios realizaron cambios en las tareas y su estado actual.  
- Autenticación basada en usuarios registrados en la base de datos.  
- Control de acceso según el **rol** del usuario y su rol dentro de los **boards** que contienen las tareas.  

---

## 🧰 Tecnologías usadas  

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **Docker**
- **LangChain4j**  
- **Spring Data JPA**  
- **H2 / PostgreSQL**  

---

## 🚀 Cómo instalar / ejecutar  

### 🔹 Ejecución en Render  

La aplicación se encuentra desplegada en la nube mediante **Render**, permitiendo su acceso desde cualquier lugar:  

👉 **URL base:**  
https://task-manager-vczr.onrender.com/task_manager/api


> ⚠️ Al acceder directamente, es posible que aparezca “Not Found”, ya que la API responde según el *path* del endpoint utilizado.

Puedes consultar la documentación completa generada con **Swagger**:  

📘 **Swagger UI:** *(https://task-manager-vczr.onrender.com/task_manager/api/swagger-ui/index.html)*  

> 🔐 La mayoría de los endpoints requieren autenticación. Algunas acciones dependen del **rol** del usuario y de su **rol dentro del board**.

---

### 🔹 Ejecución en local  

También puedes descargar el proyecto y ejecutarlo localmente.  

#### Pasos:
1. Clonar el repositorio.  
2. Abrir el proyecto en tu IDE (por ejemplo, **IntelliJ IDEA**).  
3. Sincronizar dependencias con **Gradle**.  
4. Ejecutar la aplicación con el botón **Run**.  
5. Acceder a la API local:  

http://localhost:8082/task_manager/api

6. Utilizar los mismos endpoints descritos en la documentación Swagger.  

---

## 🧩 Arquitectura  

La aplicación utiliza una **arquitectura por capas orientada al dominio**, lo que permite desacoplar la persistencia de datos del motor de base de datos específico.  

Esto facilita el mantenimiento y la escalabilidad, ya que es posible cambiar de motor (por ejemplo, de H2 a PostgreSQL) sin afectar la lógica del dominio.

### 🧱 Estructura general de capas

Controller            ← Capa Web (maneja peticiones HTTP)
   │
Service               ← Contiene la lógica de negocio
   │
Repository (Dom)      ← Interfaz del dominio (desacopla persistencia)
   │
Entity Repository (DB)← Implementación concreta (JPA)
   │
Database              ← Motor: H2 / PostgreSQL



## 💡 Ejemplo de arquitectura  

En el siguiente ejemplo se muestra cómo se aplica el diseño por capas usando una clase `Movie`:

- **Capa de dominio:**  
  `MovieRepository` — interfaz que desacopla la lógica del dominio de la persistencia.  

- **Capa de persistencia:**  
  `MovieEntityRepository` implementa la interfaz anterior y se comunica con `CrudMovieEntity`, que conecta directamente con la base de datos.  

- **Capa de servicios:**  
  `MovieService` contiene la lógica del caso de uso.  

- **Capa web:**  
  `MovieController` expone los endpoints y usa el servicio anterior para obtener los datos, sin depender directamente del motor de base de datos.

---

## 📷 Screenshots o diagramas  

![Diagrama de base de datos](./Gestor%20de%20tareas.png)


**Desarrollado por:**  
👨‍💻 *David Mauricio Gorraiz Moreno*  
