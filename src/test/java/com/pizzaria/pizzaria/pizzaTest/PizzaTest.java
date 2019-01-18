package com.pizzaria.pizzaria.pizzaTest;

import com.pizzaria.pizzaria.PizzariaApplication;
import com.pizzaria.pizzaria.pizza.enums.Personalizacao;
import com.pizzaria.pizzaria.pizza.enums.Sabor;
import com.pizzaria.pizzaria.pizza.enums.Tamanho;
import com.pizzaria.pizzaria.pizza.exception.PizzaNaoEncontradaException;
import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.service.PizzaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertThat;

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
          .personalizacaos(Personalizacao.EXTRA_BACON)
          .build();

  Pizza pizzaPortuguesa = new Pizza().builder()
          .id(2L)
          .preco(60.5)
          .tamanho(Tamanho.GRANDE)
          .sabor(Sabor.PORTUGUESA)
          .tempoPreparo(2.5)
          .personalizacaos(Personalizacao.BORDA_RECHEADA)
          .build();

  @Test
  public void deveSalvarPizzaCalabresa() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaCalabresa);
    Pizza pizzaCalabresaRecuperada = pizzaService.getPizza(1L);
    Assert.assertEquals(pizzaCalabresaRecuperada, pizzaCalabresa);
  }

  @Test
  public void deveSalvarPizzaCalabresaValidarPreco() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaCalabresa);
    Pizza pizzaCalabresaRecuperada = pizzaService.getPizza(1L);
    Assert.assertTrue(pizzaCalabresaRecuperada.getPreco() == 103.5);
  }

  @Test
  public void deveSalvarPizzaCalabresaValidarTempoPreparo() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaCalabresa);
    Pizza pizzaCalabresaRecuperada = pizzaService.getPizza(1L);
    Assert.assertTrue(27.5 == pizzaCalabresaRecuperada.getTempoPreparo());
  }

  @Test
  public void deveRecuperarDuasPizzas() {
    pizzaService.save(pizzaCalabresa);
    pizzaService.save(pizzaPortuguesa);
    pizzaService.save(pizzaCalabresa);
    List<Pizza> pizzaAll = pizzaService.getAll();
    Assert.assertEquals(2, pizzaAll.size());
  }

  @Test
  public void deveRecuperarPizzaComTrintaSeteMinutosMeioDePreparo() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaPortuguesa);
    Pizza pizzaRecuperada = pizzaService.getPizza(1L);
    Assert.assertTrue(37.5 == pizzaRecuperada.getTempoPreparo());
  }
}
