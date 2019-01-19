## Serviço de Pedido de Pizzas
##### Pedido de pizza onde o usuário escolhe o sabor, tamanho e adicionais da pizza, retorna um resumo do pedido com o preço final e o tempo de preparo da pizza. 


### Tecnolôgias:
```
 Framework: Spring Boot, Hibernate e JPA
 Linguagem: Java 8
 Banco de dados: H2
```

### Cardápio
```
 Tamanhos   | Sabores    | Personalizações
 ----------- ----------- -----------------
 Pequena    | Calabresa  | Extra bacon
 Média      | marguerita | Sem cebola
 Grande     | portuguesa | Borda recheada
```


### A controller possue os métodos:

```
 getPizza -  retorna os dados da pizza pelo id
 getAll   -  retorna todas as pizzas
 save     -  realiza o pedido da pizza 
```

