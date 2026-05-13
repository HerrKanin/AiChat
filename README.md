# AiChat

AiChat is a Spring Boot application that lets users chat with an AI model via a REST API.

The app supports different personalities, session-based memory, and includes a simple frontend chat UI.

---

## 🚀 How to run

### 1. Clone the project

### 2. Set API key

Create an API key at:  
https://openrouter.ai

Set it as an environment variable:

OPENAI_API_KEY=your_api_key_here

In IntelliJ:  
Run → Edit Configurations → Environment variables

---

### 3. Start the app

Windows (PowerShell):

```powershell
.\mvnw.cmd spring-boot:run
```

---

### 4. Open in browser

Frontend chat:

http://localhost:8080/index.html

Swagger:

http://localhost:8080/swagger-ui.html

---

## Personalities

Available personalities:

- helper
- coder
- pirate

---

## 📝 Notes

- API keys are not included for security reasons
- You must provide your own key to use the AI functionality  