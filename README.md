# Desafio Final — Bootcamp Arquiteto(a) de Software

## 1. Objetivo

O objetivo deste desafio é aplicar os conhecimentos adquiridos durante o Bootcamp de Arquiteto(a) de Software, desenvolvendo uma solução que contemple os principais conceitos de arquitetura de software, modelagem arquitetural e desenvolvimento de APIs REST.

O cenário proposto é o de uma grande empresa de vendas on-line que necessita disponibilizar publicamente dados de Cliente, Produto ou Pedido para seus parceiros.

A solução consiste em projetar, documentar e implementar uma API REST seguindo o padrão arquitetural **MVC (Model-View-Controller)**, disponibilizando operações CRUD e funcionalidades complementares.

## 2. Objetivos de aprendizagem

Exercitar os seguintes conceitos trabalhados nos módulos do Bootcamp:

- Fundamentos de Arquitetura de Software.
- Requisitos Arquiteturais e Modelagem Arquitetural.
- Design Patterns, Estilos e Padrões Arquiteturais.
- Principais Arquiteturas de Software da Atualidade.

## 3. Requisitos do desafio

### 3.1. Plataforma e linguagem

Utilizar uma plataforma e linguagem de programação de preferência.

Exemplos:
- Java com Spring Boot.
- Python com Flask.
- Node.js com Express.

### 3.2. Funcionalidades da API

Desenvolver uma API RESTful que implemente operações CRUD básicas sobre um domínio de negócio à escolha, como:

- Clientes.
- Produtos.
- Pedidos.

A API deverá implementar as seguintes funcionalidades:

| Operação | Descrição |
|---|---|
| Create | Criação de registros. |
| Read | Leitura de registros. |
| Update | Atualização de registros. |
| Delete | Exclusão de registros. |
| Count | Retornar a quantidade total de registros. |
| Find All | Retornar todos os registros. |
| Find By ID | Buscar um registro específico pelo identificador. |
| Find By Name | Buscar registros correspondentes a um nome específico. |

### 3.3. Arquitetura

A aplicação deverá utilizar o padrão arquitetural MVC (Model-View-Controller) para organizar seus componentes.

A utilização de banco de dados não é obrigatória, porém a implementação de persistência dos dados será considerada um diferencial.

## 4. Entregáveis

### 4.1. Desenho arquitetural do software

Desenvolver um diagrama arquitetural utilizando uma das seguintes abordagens:

- UML.
- C4 Model.
- Outro modelo de diagrama de arquitetura de preferência.

O diagrama poderá ser desenvolvido utilizando ferramentas como Draw.io.

### 4.2. Estrutura de pastas e componentes

Apresentar a estrutura de diretórios do projeto, explicando brevemente a responsabilidade de cada componente.

Os principais componentes esperados são:

| Componente | Responsabilidade |
|---|---|
| Controller | Gerenciar as requisições HTTP e disponibilizar os endpoints da API. |
| Model | Representar as entidades do domínio. |
| Repository | Responsável pela interação com o banco de dados. |
| Service | Implementar a lógica de negócio da aplicação. |

### 4.3. Código-fonte (opcional)

Caso opte por disponibilizar a implementação, realizar o upload do código-fonte em um repositório GitHub ou GitLab e compartilhar o link.

### 4.4. Persistência de dados (opcional)

A implementação de persistência em banco de dados é um diferencial do desafio.

## 5. Sugestão de estrutura do projeto

O enunciado apresenta a seguinte estrutura como referência para uma implementação utilizando Spring Boot:

```text
src/
└── main/
    └── java/
        └── com/exemplo/api/
            ├── controller/
            │   └── Controladores HTTP
            ├── model/
            │   └── Entidades do domínio
            ├── repository/
            │   └── Repositórios de dados
            ├── service/
            │   └── Regras de negócio
            └── ApiApplication.java
```

## 6. Exemplo de funcionalidades

Considerando o domínio de Clientes, os seguintes endpoints podem ser utilizados como referência:

| Método HTTP | Endpoint | Descrição |
|---|---|---|
| GET | `/clientes` | Listar todos os clientes. |
| GET | `/clientes/{id}` | Buscar cliente pelo ID. |
| GET | `/clientes/nome/{nome}` | Buscar clientes pelo nome. |
| GET | `/clientes/contar` | Contar o total de clientes. |
| POST | `/clientes` | Cadastrar um cliente. |
| PUT | `/clientes/{id}` | Atualizar um cliente. |
| DELETE | `/clientes/{id}` | Excluir um cliente. |

## 7. Critérios de organização e qualidade

Durante o desenvolvimento, devem ser considerados os seguintes aspectos:

- Organização do código.
- Separação de responsabilidades.
- Documentação dos componentes.
- Isolamento das responsabilidades de Controller, Model e Service.
- Clareza na estrutura de diretórios.
- Representação das relações entre os componentes no diagrama arquitetural.

## 8. Resumo dos entregáveis

| # | Entregável | Obrigatoriedade |
|---|---|---|
| 1 | Arquitetura do software (C4 Model, UML ou outro diagrama) | Obrigatório |
| 2 | Estrutura de pastas do projeto MVC | Obrigatório |
| 3 | Explicação da estrutura e dos elementos do código | Obrigatório |
| 4 | Código-fonte funcionando | Opcional |
| 5 | Persistência de dados funcionando | Opcional |

---

**Bootcamp: Arquiteto(a) de Software**

*Desafio Final*
