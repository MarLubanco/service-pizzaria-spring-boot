package com.pizzaria.pizzaria.pizza.service;

import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

  @Autowired
  private PizzaRepository pizzaRepository;

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
    pizza.getTamanho().selecionarTamanhoPizza(pizza);
    pizza.getSabor().prepararSabor(pizza);
    pizza.getPersonalizacaos().atualizarPizza(pizza);
    return pizzaRepository.save(pizza);
  }

}
