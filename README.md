### README: Avaliador de Empréstimos

---

## Descrição do Projeto

O **Avaliador de Empréstimos** é uma aplicação Java/Spring Boot que simula a elegibilidade de clientes para diferentes tipos de empréstimos, com base em informações como renda, idade e localização. A aplicação utiliza o padrão de projeto Strategy para determinar quais tipos de empréstimo são aplicáveis a cada perfil de cliente, proporcionando uma arquitetura extensível e de fácil manutenção.

## Arquitetura e Padrão de Projeto

### Padrão Strategy

O padrão **Strategy** é usado para encapsular diferentes algoritmos de avaliação de empréstimos dentro de classes distintas, cada uma representando uma estratégia específica. Com isso, a lógica de verificação de elegibilidade é isolada dentro das estratégias, permitindo que o código seja modular, flexível e fácil de estender com novas regras de negócios.

### Motivação

Ao utilizar o padrão Strategy, eliminamos a complexidade de `if-else` múltiplos, distribuindo a lógica de decisão entre as diferentes implementações de estratégia. Isso resulta em um código mais limpo e organizado, que facilita a adição de novos tipos de empréstimos sem a necessidade de alterar o código existente.

## Estrutura do Projeto

### Pacotes

- `controller`: Contém o controlador REST que expõe a API para avaliação de empréstimos.
- `dto`: Contém os objetos de transferência de dados (Data Transfer Objects) que são usados para transportar dados entre as camadas da aplicação.
- `entity`: Contém as entidades que representam os empréstimos e os estados brasileiros.
- `service`: Contém a lógica de negócio central para avaliação de empréstimos, que utiliza as estratégias.
- `strategy`: Contém as implementações do padrão Strategy para diferentes tipos de empréstimos.

### Classes e Interfaces

- **EmprestimoController**: Controlador REST que recebe as requisições para avaliar a elegibilidade de empréstimos.
- **EmprestimoService**: Serviço que centraliza a lógica de negócio e aplica as estratégias de empréstimos.
- **UserRequest** e **UserResponse**: DTOs usados para encapsular os dados do cliente e a resposta da avaliação de empréstimos.
- **Emprestimo**: Entidade que representa os tipos de empréstimos e suas características.
- **EstadoBrasileiro**: Enum que representa os estados do Brasil com suas respectivas siglas.
- **EmprestimoStrategy**: Interface que define o contrato para as estratégias de empréstimos.
- **EmprestimoPessoalStrategy**, **EmprestimoGarantidoStrategy**, **EmprestimoConsignadoStrategy**: Implementações específicas das estratégias de empréstimo.

## Como Funciona

### API REST

A API expõe um único endpoint:

- **POST /customer-loans**: Avalia a elegibilidade do cliente para diferentes tipos de empréstimo com base nos dados fornecidos.

### Funcionamento

1. O cliente faz uma requisição POST para `/customer-loans` com um payload JSON que inclui `age`, `cpf`, `name`, `income`, e `location`.
2. O `EmprestimoController` recebe a requisição e a encaminha para o `EmprestimoService`.
3. O `EmprestimoService` itera sobre todas as estratégias disponíveis e aplica aquelas que são aplicáveis ao perfil do cliente.
4. Os empréstimos elegíveis são retornados na resposta, ou uma mensagem indicando que nenhum empréstimo foi encontrado para o perfil.

### Exemplo de Requisição

```json
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Kauê de Quadros",
  "income": 7000.00,
  "location": "SC"
}
```

### Exemplo de Resposta

```json
{
  "customer": "Kauê de Quadros",
  "loans": [
    {
      "type": "CONSIGNMENT",
      "income": 2
    },
    {
      "type": "PERSONAL",
      "income": 4
    },
    {
      "type": "GUARANTEED",
      "income": 3
    }
  ]
}
```

## Importância do Padrão Strategy

O padrão Strategy permite encapsular diferentes algoritmos de forma que eles possam ser facilmente substituídos ou modificados sem alterar o restante do código. Isso é crucial em cenários onde as regras de negócio são complexas e podem variar, como em sistemas de avaliação de crédito. Com o uso do Strategy, podemos adicionar novas regras de empréstimo sem modificar as classes existentes, promovendo a manutenção e a escalabilidade da aplicação.

## Como Executar

1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Execute o comando `mvn spring-boot:run` para iniciar a aplicação.
4. Use um cliente REST como Postman ou cURL para interagir com o endpoint `/customer-loans`.

## Considerações Finais

Este projeto demonstra a aplicação prática do padrão Strategy em um contexto real, proporcionando uma base sólida para sistemas que necessitam de flexibilidade e fácil manutenção em suas regras de negócio. O código é modular e preparado para futuras expansões, como a adição de novos tipos de empréstimos ou mudanças nas regras de elegibilidade.
