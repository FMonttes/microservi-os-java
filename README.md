Microservices - Order Processing System

📝 Sobre o Projeto

Este projeto consiste em um sistema baseado em microserviços para o processamento de pedidos, utilizando Java com Spring Boot, comunicação assíncrona via RabbitMQ e persistência de dados no PostgreSQL. O sistema simula o fluxo de um pedido, onde:

O Serviço de Pedido envia um pedido para a fila RabbitMQ.

O Serviço de Notificação escuta a fila e envia um e-mail de confirmação usando o MailHog.

O Serviço de Persistência escuta a fila e armazena o pedido no banco de dados PostgreSQL.

🏗️ Tecnologias Utilizadas

Java 17

Spring Boot 3

RabbitMQ (mensageria)

PostgreSQL (banco de dados)

Docker (RabbitMQ, MailHog, PostgreSQL)

Spring Data JPA (para persistência de dados)

Spring Mail (para envio de e-mails)

Spring AMQP (para integração com RabbitMQ)

🚀 Como Executar o Projeto

1️⃣ Pré-requisitos

Antes de iniciar, instale:

Docker e Docker Compose

Java 17

Maven

Postman (para testes de API)

2️⃣ Subindo as Dependências

Execute o seguinte comando para iniciar o RabbitMQ, PostgreSQL e MailHog:

docker-compose up -d

3️⃣ Rodando os Microserviços

Abra o intelij e rode os 3 serviços.

🔄 Testando a API com Postman

Enviar um pedido via Serviço de Pedido:

Método: POST

URL: http://localhost:8080/api/v1/pedidos

Body (JSON):

{
    "client": "felipe",
    "itens":[
        {
            "quantity": 1,
            "product":{
                "name":"teclado",
                "price": 100
            }
        }
    ],
    "totalPrice": 100,
    "emailNotification": "felipe.monttes100@gmail.com"
}

O RabbitMQ receberá a mensagem e distribuirá para os serviços consumidores.

O Serviço de Notificação enviará um e-mail (acessível no MailHog em http://localhost:8025).

O Serviço de Persistência armazenará o pedido no PostgreSQL.

📩 Testando o MailHog

Acesse http://localhost:8025 no navegador para visualizar os e-mails enviados.
