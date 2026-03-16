# 📚 Spring Biblioteca

> API REST de gerenciamento de biblioteca construída com **Spring Boot**.

---

## 🗂️ Sobre

O **Spring Biblioteca** é uma aplicação back-end desenvolvida com **Spring Boot** para gerenciar o acervo de uma biblioteca, permitindo o controle de livros, autores e empréstimos via API REST, seguindo boas práticas de arquitetura em camadas.

---

## ✨ Funcionalidades

- 📖 Cadastro e gerenciamento de livros
- ✍️ Gerenciamento de autores
- 🔄 Controle de empréstimos e devoluções
- 🔍 Busca por título, autor ou categoria
- 🗑️ Remoção de registros
- 🗄️ Persistência com banco de dados relacional

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Função |
|---|---|
| ☕ Java | Linguagem principal |
| 🍃 Spring Boot | Framework back-end |
| 🗄️ Spring Data JPA | Persistência e ORM |
| 🐬 MySQL | Banco de dados |
| 📦 Maven | Gerenciador de dependências |

---

## ⚙️ Pré-requisitos

- ☕ Java JDK 17+
- 📦 Apache Maven
- 🐬 MySQL Server

---

## 🚀 Como executar

```bash
# Clone o repositório
git clone https://github.com/Vinizapella/Spring-Biblioteca.git

# Acesse a pasta
cd Spring-Biblioteca

# Configure o banco em src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_biblioteca
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Execute o projeto
mvn spring-boot:run
```

---

## 🌐 Endpoints

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/livros` | Lista todos os livros |
| `GET` | `/livros/{id}` | Busca livro por ID |
| `POST` | `/livros` | Cadastra novo livro |
| `PUT` | `/livros/{id}` | Atualiza um livro |
| `DELETE` | `/livros/{id}` | Remove um livro |
| `GET` | `/autores` | Lista todos os autores |
| `POST` | `/autores` | Cadastra novo autor |
| `GET` | `/emprestimos` | Lista empréstimos ativos |
| `POST` | `/emprestimos` | Registra novo empréstimo |

---

## 📁 Estrutura

```
📦 Spring-Biblioteca
 ┣ 📂 src
 ┃ ┗ 📂 main
 ┃   ┣ 📂 java
 ┃   ┃ ┣ 📂 controller
 ┃   ┃ ┣ 📂 service
 ┃   ┃ ┣ 📂 repository
 ┃   ┃ ┗ 📂 model
 ┃   ┗ 📂 resources
 ┃     ┗ 📄 application.properties
 ┣ 📄 pom.xml
 ┗ 📄 README.md
```

---

## 👤 Autor

Feito com 🖤 por **Vinizapella** — projeto concluído para fins acadêmicos.

---

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat-square&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white" />
  <img src="https://img.shields.io/badge/REST%20API-✔-brightgreen?style=flat-square" />
  <img src="https://img.shields.io/badge/status-concluído-brightgreen?style=flat-square" />
</p>
