# Sistema de Pagamento - Sistema de Gerenciamento de Pagamentos

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2022.0.4-brightgreen)](https://spring.io/projects/spring-cloud)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-latest-brightgreen)](https://spring.io/projects/spring-data-jpa)
[![Validation](https://img.shields.io/badge/Validation-latest-brightgreen)](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation)
[![Spring Web](https://img.shields.io/badge/Spring%20Web-latest-brightgreen)](https://spring.io/guides/gs/spring-boot/)
[![Flyway](https://img.shields.io/badge/Flyway-latest-brightgreen)](https://flywaydb.org/)
[![MySQL Connector/J](https://img.shields.io/badge/MySQL%20Connector%2FJ-latest-brightgreen)](https://dev.mysql.com/doc/connector-j/en/)
[![Lombok](https://img.shields.io/badge/Lombok-latest-brightgreen)](https://projectlombok.org/)
[![JUnit](https://img.shields.io/badge/JUnit-latest-brightgreen)](https://junit.org/)
[![OpenFeign](https://img.shields.io/badge/OpenFeign-latest-brightgreen)](https://spring.io/projects/spring-cloud-openfeign)
[![Springdoc OpenAPI](https://img.shields.io/badge/Springdoc%20OpenAPI-2.1.0-brightgreen)](https://springdoc.org/)


## Visão Geral

O XY-PI é um sistema de gerenciamento de pagamentos desenvolvido em Java usando Spring Boot para o backend e MySQL para o armazenamento de dados. Este sistema oferece várias funcionalidades para criar, visualizar, atualizar, desativar e listar , bem como relacionar um documento de pagament à um cliente.

## Como Executar

Siga as etapas abaixo para executar o projeto:

1. Clone o repositório do projeto:

```bash
git clone https://github.com/matteusmoreno/payment-system
```

2. Navegue até o diretório do projeto:

```bash
cd payment-system
```

3. Execute o projeto com Maven:

```bash
mvn spring-boot:run
```

4. O aplicativo estará acessível em `http://localhost:8080`. Você pode usar as rotas mencionadas acima para interagir com os Pontos de Interesse.

```properties
spring.datasource.url=jdbc:mysql://localhost/xy-inc?createDatabaseIfNotExist=true
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```




