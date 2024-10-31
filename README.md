# Score API

Objetivo: Criar um serviço do tipo API REST, para cadastro de pessoas com score e
endereço.
Uma pessoa possui: Nome, idade, cep, estado, cidade, bairro, logradouro, telefone, score
de 0 a 1000.

## Sumário

- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração do Banco de Dados H2 em Modo Memória](#configuração-do-banco-de-dados-h2-em-modo-memória)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)
- [Autenticação JWT](#autenticação-jwt)
- [Documentação Swagger](#documentação-swagger)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Pré-requisitos

Antes de começar, você precisará ter o seguinte instalado:

- [Java JDK 21](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [IDE](https://www.jetbrains.com/idea/download/) (opcional, mas recomendado)

## Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/seuusuario/seurepositorio.git

2. Navegue até o diretório do projeto:
     ```bash
    cd seurepositorio

3. Compile e execute a aplicação:
      ```bash
    mvn spring-boot:run