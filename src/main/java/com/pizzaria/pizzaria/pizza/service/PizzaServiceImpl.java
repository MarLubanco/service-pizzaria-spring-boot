package com.pizzaria.pizzaria.pizza.service;

import com.pizzaria.pizzaria.pizza.exception.PizzaNaoEncontradaException;
import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.repository.PizzaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PizzaServiceImpl implements PizzaService {

  @Autowired
  private PizzaRepository pizzaRepository;

  public Pizza getById(Integer id) throws PizzaNaoEncontradaException {
    return pizzaRepository.findById(id).orElseThrow(() -> new PizzaNaoEncontradaException("Pizza não encontrada"));
  }

  public Pizza save(Pizza pizza) {
    gerarPedido(pizza);
    return pizzaRepository.save(pizza);
  }

  public void gerarPedido(Pizza pizza) {
    pizza.getTamanho().selecionarTamanhoPizza(pizza);
    pizza.getSabor().prepararSabor(pizza);
    pizza.getPersonalizacaos().atualizarPizza(pizza);
  }

  public List<Pizza> getAll() {
    return pizzaRepository.findAll();
  }
}
