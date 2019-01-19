package com.pizzaria.pizzaria.pizza.service;

import com.pizzaria.pizzaria.pizza.exception.PizzaNaoEncontradaException;
import com.pizzaria.pizzaria.pizza.model.Pizza;

import java.util.List;

public interface PizzaService {

  /**
   * Ao passar o id da pizza como parâmetro deve retornar a pizza
   *
   * @param id id da pizza já existente
   * @return
   */
   Pizza getById(Integer id) throws PizzaNaoEncontradaException;

  /**
   * Ao receber o objeto pizza irá persistir os dados no banco de dados
   *
   * @param pizza Nova pizza
   * @return
   */
   Pizza save(Pizza pizza);

  /**
   * Gera a pizza custumizada a partir das entradas de dados,
   * gerando o tamanho, sabor e preço
   *
   * @param pizza as propriedades tamanho, sabor e personalização definem o tempo de preparo e preço
   */
   void gerarPedido(Pizza pizza);


  /**
   * Recupera todas as pizzas do banco de dados
   *
   * @return
   */
   List<Pizza> getAll();

}
