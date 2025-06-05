# Gestão de Projetos

API REST para gestão de funcionários e projetos, desenvolvida com **Java 21** e **Spring Boot**, utilizando boas práticas de programação e design.

---

## Tecnologias

- **Java 21**
- **Spring Boot**
- **Docker Compose**
- **Java Validation**
- **Lombok**
- **Swagger/OpenAPI**
- **JUnit** e **Mockito**

---

## Estrutura do Projeto

Padrão **MVC** organizado para manter a separação de responsabilidades:

```plaintext
src/
├── application/      # Camada de aplicação (forms, records, services)
├── domain/           # Camada de domínio (entidades, repositórios)
├── interfaces/       # Interfaces de serviços
└── infra/            # Configurações e integrações
````

---

## Configuração

### Pré-requisitos

* **Java 21**
* **Docker** e **Docker Compose**
* **Maven**

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/gestao-projetos.git
   cd gestao-de-projetos
   ```

2. Suba o banco de dados com Docker Compose:

   ```bash
   docker-compose up -d
   ```

3. Compile e inicie a aplicação:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. Acesse o Swagger para explorar a API:
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Endpoints Principais

### Funcionários

* **Cadastrar Funcionário**: `POST /funcionarios`
* **Listar Funcionários**: `GET /funcionarios`

### Projetos

* **Criar Projeto**: `POST /projetos`
* **Listar Projetos**: `GET /projetos`

---

## Testes

Execute os testes unitários com:

```bash
mvn test
```
