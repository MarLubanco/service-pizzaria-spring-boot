package com.pizzaria.pizzaria.pizza.controller;

import com.pizzaria.pizzaria.pizza.exception.PizzaNaoEncontradaException;
import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;

  /**
   * Validar e persistir pizza no banco de dados,
   * caso de sucesso irá retornar o status 201 (created)
   *
   * @param pizza Nova pizza
   * @return
   */
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Pizza save(@RequestBody @Valid Pizza pizza) {
    return pizzaService.save(pizza);
  }

  /**
   * Recupera uma pizza pelo id
   *
   * @param id id de uma pizza já existente
   * @return
   */
  @GetMapping("{id}")
  public Pizza getPizza(@PathVariable Integer id) throws PizzaNaoEncontradaException {
    return pizzaService.getById(id);
  }

  /**
   * Retorna todas as pizzas
   *
   * @return
   */
  @GetMapping
  public List<Pizza> getAll() {
    return pizzaService.getAll();
  }

}
