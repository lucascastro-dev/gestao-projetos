# Desafio Técnico: Plataforma de Gestão de Projetos

Este projeto foi desenvolvido como parte de um desafio técnico para o Grupo AG Capital. A finalidade do projeto é criar uma nova plataforma de gestão de projetos, substituindo o sistema legado desktop por uma aplicação web que atenda às necessidades da empresa, especialmente durante períodos como a pandemia de COVID-19, onde o acesso remoto é essencial.

## Tecnologias Utilizadas

### Backend
- **Java 21 com Spring Boot**: Framework Java para construção de aplicativos web.
- **Hibernate**: Framework de mapeamento objeto-relacional para persistência de dados.
- **PostgreSQL**: Banco de dados relacional para persistência dos dados.
- **JUnit e Mockito**: Ferramentas de teste para garantir a qualidade do código.
- **Swagger**: Ferramenta para documentação da API REST.

### Frontend
- **Vue.js 3**: Framework JavaScript para construção de interfaces de usuário reativas.
- **Vuetify**: Biblioteca de componentes Vue baseada no Material Design para um design consistente e responsivo.

## Características de Implementação
- Arquitetura modular e extensível seguindo os princípios SOLID.
- Utilização do padrão Chain of Responsibility para garantir a escalabilidade do projeto no backend.

## Funcionalidades Principais
- Cadastro de Clientes, Projetos e Atividades.
- Listagem de projetos em aberto, incluindo informações sobre o cliente a que pertencem.
- Visualização das atividades associadas a cada projeto.

## Instalação e Uso
1. **Backend**:
   - Clone o repositório.
   - Importe o projeto Java utilizando sua IDE preferida.
   - Certifique-se de ter o PostgreSQL instalado e configurado.
   - Configure as propriedades de conexão com o banco de dados no arquivo `application.properties`.
   - Execute a aplicação Spring Boot.

2. **Frontend**:
   - Clone o repositório.
   - Navegue até o diretório do projeto Vue.js.
   - Instale as dependências utilizando `npm install`.
   - Inicie o servidor de desenvolvimento com `npm run dev`.

## Testes
- Os testes unitários cobrem a camada de domínio no backend.

## Diagrama de classes

![Diagrama Desafio (1)](https://github.com/lucascastro-dev/gestao-projetos-agcapital/assets/68044025/0cd9a392-84ac-43d0-bdbd-8992498b5fd1)

--- 
