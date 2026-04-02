

<h1 align="center">🕹️ Projeto Loja de Games</h1>

<p align="center">
  <img src="https://img.shields.io/badge/status-em%20desenvolvimento-purple?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Java-17+-purple?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-2.7.5-purple?style=for-the-badge&logo=spring&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-3.8.6-purple?style=for-the-badge&logo=apachemaven&logoColor=white" />
</p>

<p align="center" >
 <a href="#-descrição">Descrição</a> •
 <a href="#-tecnologias-utilizadas">Tecnologias</a> • 
 <a href="#-funcionalidades">Funcionalidades</a> •
 <a href="#-estrutura-do-projeto">Estrutura do Projeto</a> •
 <a href="#%EF%B8%8F-como-executar-o-projeto-localmente">Executar Localmente</a> •
 <a href="#-para-teste-no-insomnia">Testes</a> •
 <a href="#-melhorias-futuras">Melhorias Futuras</a> •
</p>

##

## 📖 Descrição

O **Projeto Loja de Games** é uma aplicação backend que simula o funcionamento de uma loja virtual de jogos. Desenvolvido em Java com Spring Boot, o projeto permite cadastrar, listar, atualizar e deletar jogos, oferecendo também filtros por nome e gênero. Foi criado como parte de uma atividade do bootcamp da **Generation Brasil**.

##

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Maven
- MySQL (banco de dados)
- Insomnia (para teste de API)

##

## 📚 Funcionalidades

- ✅ Cadastro de novos jogos
- ✅ Listagem de todos os jogos
- ✅ Atualização de dados
- ✅ Deletar jogo
- ✅ Filtro por nome ou gênero
- ✅ Validações básicas nos campos

###

## 📂 Estrutura do Projeto
```
Projeto_Loja_De_Games/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/loja/games/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ └── Application.java
│ │ └── resources/
│ │ ├── application.properties
│ │ └── data.sql
├── pom.xml
└── README.md
```
##

## 🛠️ Como Executar o Projeto Localmente

1. Clone o repositório:
```bash
git clone https://github.com/CahTarine/Loja-de-Games.git
```
2. Acesse o diretório:
```bash
cd Loja-de-Games
```
4. Compile o projeto:
```bash
mvn clean install
```
5. Execute com:
```bash
mvn spring-boot:run
```
6. Acesse o sistema via navegador:
```bash
http://localhost:8080
```
## 📄 Para teste no Insomnia

Acesse a documentação da API para testar os endpoints:
http://localhost:8080

## ✅ Requisitos

JDK 17 instalado

Maven instalado

## 💡 Melhorias Futuras

Integração com banco de dados PostgreSQL

Autenticação com Spring Security

Deploy em nuvem (Heroku, Render ou Railway)

Integração com frontend Angular ou React

## 👩🏻‍💻 Desenvolvedora

Feito com 💜 por Camille Tarine!
