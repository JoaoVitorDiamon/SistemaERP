🏢 ERP Web

![ERP Web](https://via.placeholder.com/1200x400?text=ERP+Web)

Um sistema de planejamento de recursos empresariais desenvolvido em Spring Boot, ASP.NET, React, e utilizando JUnit & Mockito para testes unitários. 🚀

✨ Tecnologias Utilizadas

🔹 **Back-End:** Spring Boot & ASP.NET  
🔹 **Front-End:** React + Tailwind + Framer Motion  
🔹 **Banco de Dados:** PostgreSQL  
🔹 **Testes:** JUnit & Mockito  
🔹 **Documentação:** Swagger  

🚀 Como Rodar o Projeto

📌 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

- [Node.js](https://nodejs.org/)
- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)
- [ASP.NET Core](https://dotnet.microsoft.com/en-us/download/dotnet/7.0)

⚙️ Configuração

Clone o repositório:
```bash
git clone https://github.com/seu-repositorio.git
cd seu-repositorio
```

Configure as variáveis de ambiente no .env:
```bash
DATABASE_URL=jdbc:postgresql://localhost:5432/erp_db
DATABASE_USER=seu_usuario
DATABASE_PASSWORD=sua_senha
```

🔥 Rodando o Back-End (Spring Boot & ASP.NET)

Java (Spring Boot):
```bash
cd backend-java
./mvnw spring-boot:run
```
.NET (ASP.NET):
```bash
cd backend-dotnet
 dotnet run
```
💻 Rodando o Front-End (React)
```bash
cd frontend
npm install
npm run dev
```
🛠️ Funcionalidades

✅ Gestão de estoque  
✅ Controle financeiro  
✅ Cadastro de produtos e clientes  
✅ Emissão de notas fiscais  
✅ Relatórios personalizados  

📚 Documentação da API

A API está documentada via Swagger. Para acessá-la, após rodar o projeto, entre em:

- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

🤝 Contribuidores

👨‍💻 **Diamon** - Back-End (Java)  
👨‍💻 **Guilherme** - Back-End (Spring Boot)  
👨‍💻 **Khaleu** - Back-End (ASP.NET)  


![UI ERP](https://via.placeholder.com/800x400?text=Interface+do+ERP)

📜 Licença

Este projeto está sob a licença MIT. Veja mais detalhes no arquivo **LICENSE**.
