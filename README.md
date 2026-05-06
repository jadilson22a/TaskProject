# TaskProject

Aplicação web de gerenciamento de tarefas construída com **Spring Boot**, **Thymeleaf** e **MySQL**.

## ✨ Funcionalidades

- Cadastro de novas tarefas.
- Listagem de tarefas pendentes.
- Edição de tarefas existentes.
- Marcação de tarefa como concluída.
- Controle de prazo (`LocalDate`) e prioridade (`BAIXA`, `MEDIA`, `ALTA`).

## 🧱 Stack do projeto

- Java 21
- Spring Boot 4
- Spring MVC
- Spring Data JPA
- Thymeleaf
- MySQL
- Maven

## 📁 Estrutura principal

```text
src/main/java/com/github/jadilson22a/TaskProject
├── Controllers/
│   └── TarefaController.java
├── Service/
│   └── TarefaService.java
├── entities/
│   ├── Prioridade.java
│   ├── Tarefa.java
│   └── TarefaDTO.java
├── repositories/
│   └── TarefaRepository.java
└── TaskProjectApplication.java

src/main/resources
├── templates/
│   ├── tarefa-form.html
│   └── tarefas.html
└── application.yml
```

## 🔄 Fluxo da aplicação

1. O usuário acessa as páginas HTML renderizadas pelo Thymeleaf.
2. `TarefaController` recebe as requisições da rota base `/tarefas`.
3. `TarefaService` aplica as regras de negócio (salvar, atualizar, concluir e buscar).
4. `TarefaRepository` persiste os dados no banco MySQL via JPA.
5. A entidade `Tarefa` é convertida para `TarefaDTO` ao trafegar para a camada web.

## 🧭 Rotas web

Base: `/tarefas`

- `GET /tarefas` → lista tarefas não concluídas.
- `GET /tarefas/novo` → exibe formulário de cadastro.
- `POST /tarefas/salvar` → salva uma nova tarefa.
- `GET /tarefas/editar/{id}` → exibe formulário de edição.
- `POST /tarefas/atualizar` → atualiza tarefa existente.
- `POST /tarefas/concluir` → marca tarefa como concluída.

## ⚙️ Configuração

A aplicação utiliza variáveis de ambiente para credenciais do banco:

- `DB_USERNAME`
- `DB_PASSWORD`

Configuração atual em `application.yml`:

- URL: `jdbc:mysql://localhost:3306/tasks`
- `spring.jpa.hibernate.ddl-auto=update`
- SQL formatado e exibido em log.

## 🚀 Como executar localmente

### Pré-requisitos

- Java 21 instalado
- MySQL em execução
- Banco `tasks` criado

### 1) Definir variáveis de ambiente

Linux/macOS:

```bash
export DB_USERNAME=seu_usuario
export DB_PASSWORD=sua_senha
```

Windows (PowerShell):

```powershell
$env:DB_USERNAME="seu_usuario"
$env:DB_PASSWORD="sua_senha"
```

### 2) Rodar a aplicação

Com Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Ou no Windows:

```powershell
mvnw.cmd spring-boot:run
```

A aplicação iniciará na porta padrão do Spring Boot (geralmente `8080`).
Acesse: `http://localhost:8080/tarefas`.

## 🧪 Testes

Para executar os testes:

```bash
./mvnw test
```

> Observação: como a aplicação depende de banco MySQL e variáveis de ambiente, os testes podem exigir configuração local compatível.
