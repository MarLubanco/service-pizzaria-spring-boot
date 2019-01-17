package com.pizzaria.pizzaria.pizza.controller;

import com.pizzaria.pizzaria.pizza.exception.PizzaNaoEncontradaException;
import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.service.PizzaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/pizzas")
public class PizzaController {

  @Autowired
  private PizzaService pizzaService;

  /**
   * Ao receber o objeto pizza irá validar e persistir os dados no banco de dados,
   * em caso de sucesso irá retornar o status 201 (created)
   * @param pizza
   * @return
   */
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Pizza save(@RequestBody @Valid Pizza pizza) {
    return pizzaService.save(pizza);
  }

  /**
   * Deve retornar todas as pizzas do banco de dados
   * @return
   */
  @GetMapping
  public List<Pizza> getAll() {
    return pizzaService.getAll();
  }

  /**
   * Ao passar o id da pizza como parâmetro deve retornar a pizza
   * @param id
   * @return
   */
  @GetMapping("{id}")
  public Pizza getPizza(@PathVariable Long id) throws PizzaNaoEncontradaException {
    return pizzaService.getPizza(id);
  }

}
