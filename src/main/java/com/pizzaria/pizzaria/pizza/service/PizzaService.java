package com.pizzaria.pizzaria.pizza.service;

import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.repository.PizzaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

  @Autowired
  private PizzaRepository pizzaRepository;

  /**
   * Deve retornar todas as pizzas do banco de dados
   * @return
   */
  public List<Pizza> getAll() {
    return pizzaRepository.findAll();
  }

  /**
   * Ao passar o id da pizza como parâmetro deve retornar a pizza
   * @param id
   * @return
   */
  public Pizza getPizza(Long id) {
    return pizzaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pizza não encontrada"));
  }

  /**
   * Ao receber o objeto pizza irá persistir os dados no banco de dados
   * @param pizza
   * @return
   */
  public Pizza save(Pizza pizza) {
    return pizzaRepository.save(pizza);
  }

  /**
   * Ao passar o id da pizza, a mesma deve ser deletada do banco de dados
   * @param id
   */
  public void delete(Long id) {
    pizzaRepository.deleteById(id);
  }

}
