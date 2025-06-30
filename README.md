# LavaCar – Sistema de Gerenciamento de Lavagens Automotivas 🚗🧽

Este projeto é um sistema completo em Java que simula a gestão de lavagens automotivas em um lava-rápido. A aplicação funciona via console (terminal) e permite o cadastro, listagem, busca, atualização e exclusão de **carros**, **consultores**, **lavagens** e **tabela de preços**.

---

## 🧠 Objetivo do Projeto

Desenvolver uma aplicação prática com base nos conceitos teóricos da linguagem Java, utilizando:
- Programação Orientada a Objetos (POO)
- Arquitetura MVC
- JPA/Hibernate com persistência em banco de dados MySQL
- Leitura de dados via console (Scanner)
- Princípios de boas práticas em separação de responsabilidades (DTO, Service, Controller, Repository)

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia        | Descrição                                      |
|-------------------|-----------------------------------------------|
| Java 17           | Linguagem principal                            |
| Eclipse IDE       | Ambiente de desenvolvimento                    |
| Maven             | Gerenciador de dependências                    |
| JPA / Hibernate   | Persistência de dados (ORM)                    |
| MySQL             | Banco de dados relacional                      |
| MySQL Workbench   | Interface visual para banco de dados           |
| Console (Scanner) | Entrada e interação com o usuário              |

---

## 🧩 Arquitetura do Projeto

O projeto segue o padrão **MVC (Model-View-Controller)** com separação em pacotes:

src/ \
├── controller/ \
│ ├── CarroController.java \
│ ├── ConsultorController.java \
│ ├── LavagemController.java \
│ └── TabelaPrecoController.java \
├── model/ \
│ ├── entities/ ← Entidades JPA \
│ ├── repositories/ ← Repositórios com EntityManager \
│ └── services/ ← Lógica de negócio separada da interface \
├── view/ \
│ ├── CarroDTO.java \
│ ├── ConsultorDTO.java \
│ ├── LavagemDTO.java \
│ └── TabelaPrecoDTO.java \
└── App.java ← Classe principal com o menu principal \
## 🔧 Funcionalidades

### 📁 Módulos:

#### 🚘 **Carros**
- Cadastrar carro (novo ou seminovo)
- Listar todos os carros
- Buscar por **placa** ou **chassi**
- Atualizar dados do carro
- Excluir carro

#### 👤 **Consultores**
- Cadastrar consultor
- Listar todos
- Buscar por ID
- Atualizar dados
- Excluir

#### 💸 **Tabela de Preços**
- Cadastrar preço por modelo
- Listar todos os preços
- Buscar por modelo
- Atualizar preço
- Excluir

#### 🧼 **Lavagens**
- Cadastrar lavagem
- Listar todas
- Buscar por consultor
- Atualizar ordem de serviço
- Excluir lavagem

---

