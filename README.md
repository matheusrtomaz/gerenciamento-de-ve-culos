# Gerenciamento de Veículos

Este é um sistema web elaborado para facilitar o cadastro, consulta, atualização e remoção de veículos de uma frota. A aplicação foi desenvolvida utilizando Java 17, Jakarta EE e Spring Boot, proporcionando uma API robusta e escalável para gerenciamento de informações veiculares.

## Funcionalidades

- **Cadastro de veículo:** Permite inserir um novo veículo no sistema com dados como modelo, placa e ano.
- **Consulta de veículos:** Possibilita visualizar a lista de todos os veículos cadastrados ou buscar um veículo específico pelo seu ID.
- **Atualização de veículo:** Oferece a opção de alterar os dados de um veículo existente.
- **Remoção de veículo:** Permite a exclusão definitiva de um veículo do sistema.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Jakarta EE**
- **Spring Data JPA**
- **Banco de dados relacional** (ex: H2, PostgreSQL ou MySQL, dependendo da configuração)
- **DTOs (Data Transfer Objects)** para desacoplamento entre entidades e a API
- **Swagger/OpenAPI** (opcional, mas recomendado para documentação dos endpoints)

## Estrutura dos Endpoints

Base url: `/veiculos`

| Método   | Endpoint           | Descrição                          | Body/Param             |
|----------|--------------------|------------------------------------|------------------------|
| GET      | `/veiculos`        | Lista todos os veículos            | -                      |
| GET      | `/veiculos/{id}`   | Detalha um veículo via ID          | -                      |
| POST     | `/veiculos`        | Cadastra um novo veículo           | VeiculoRequestDTO      |
| PUT      | `/veiculos/{id}`   | Atualiza os dados de um veículo    | VeiculoRequestDTO      |
| DELETE   | `/veiculos/{id}`   | Remove um veículo                  | -                      |

### Exemplo de Body para POST/PUT

json { "modelo": "Civic", "placa": "ABC1D23", "ano": 2022 }

## Como rodar o projeto

1. **Clone o repositório:**
   ```sh
   git clone https://github.com/matheusrtomaz/gerenciamento-de-ve-culos.git
   ```
2. **Acesse a pasta do projeto:**
   ```sh
   cd gerenciamento-de-ve-culos
   ```
3. **Configure o banco de dados** (verifique o arquivo `application.properties` ou `application.yml`).
4. **Execute a aplicação:**
   - Via IDE (IntelliJ, Eclipse, etc)
   - Ou pelo terminal:
     ```sh
     ./mvnw spring-boot:run
     ```

5. **Acesse os endpoints pela porta padrão (ex: http://localhost:8080/veiculos)**

## Sobre o projeto

O objetivo deste sistema é servir como base para aplicações que demandem controle eficiente de veículos, podendo ser facilmente extendida para necessidades de locadoras, frotas empresariais ou órgãos públicos. O uso de boas práticas como DTOs, separação de camadas e padrões REST facilita a manutenção e a evolução futura da aplicação.
