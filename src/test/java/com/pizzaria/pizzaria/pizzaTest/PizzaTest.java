package com.pizzaria.pizzaria.pizzaTest;

import com.pizzaria.pizzaria.PizzariaApplication;
import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.model.Sabor;
import com.pizzaria.pizzaria.pizza.model.Tamanho;
import com.pizzaria.pizzaria.pizza.service.PizzaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PizzariaApplication.class)
public class PizzaTest {

  @Autowired
  private PizzaService pizzaService;

  Pizza pizzaCalabresa = new Pizza().builder()
          .id(1L)
          .preco(60.5)
          .tamanho(Tamanho.GRANDE)
          .sabor(Sabor.CALABRESA)
          .tempoPreparo(2.5)
          .build();

  Pizza pizzaPortuguesa = new Pizza().builder()
          .id(2L)
          .preco(60.5)
          .tamanho(Tamanho.GRANDE)
          .sabor(Sabor.CALABRESA)
          .tempoPreparo(2.5)
          .build();


  @Test
  public void deveSalvarPizzaCalabresa() {
    pizzaService.save(pizzaCalabresa);
    Pizza pizzaCalabresaRecuperada = pizzaService.getPizza(1L);
    Assert.assertEquals(pizzaCalabresaRecuperada, pizzaCalabresa);
  }

  @Test
  public void deveRecuperarDuasPizzas() {
    pizzaService.save(pizzaPortuguesa);
    pizzaService.save(pizzaCalabresa);
    List<Pizza> pizzaAll = pizzaService.getAll();
    Assert.assertEquals(pizzaAll.size(), 2);
  }
}
