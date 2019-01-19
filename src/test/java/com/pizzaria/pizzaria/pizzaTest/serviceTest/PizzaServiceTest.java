package com.pizzaria.pizzaria.pizzaTest.serviceTest;

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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PizzariaApplication.class)
public class PizzaServiceTest {

  @Autowired
  private PizzaService pizzaService;

  Pizza pizzaCalabresa = new Pizza().builder()
          .id(1)
          .preco(60.5)
          .tamanho(Tamanho.GRANDE)
          .sabor(Sabor.CALABRESA)
          .tempoPreparo(2.5)
          .personalizacaos(Personalizacao.EXTRA_BACON)
          .build();

  Pizza pizzaPortuguesa = new Pizza().builder()
          .id(2)
          .preco(60.5)
          .tamanho(Tamanho.GRANDE)
          .sabor(Sabor.PORTUGUESA)
          .tempoPreparo(2.5)
          .personalizacaos(Personalizacao.BORDA_RECHEADA)
          .build();

  Pizza pizzaPortuguesaBaconExtra = new Pizza().builder()
          .id(3)
          .preco(60.5)
          .tamanho(Tamanho.GRANDE)
          .sabor(Sabor.PORTUGUESA)
          .tempoPreparo(2.5)
          .personalizacaos(Personalizacao.EXTRA_BACON)
          .build();

  @Test
  public void deveSalvarPizzaCalabresa() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaCalabresa);
    Pizza pizzaCalabresaRecuperada = pizzaService.getById(1);
    Assert.assertEquals(pizzaCalabresaRecuperada, pizzaCalabresa);
  }

  @Test
  public void deveSalvarPizzaCalabresaValidarPreco() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaCalabresa);
    Pizza pizzaCalabresaRecuperada = pizzaService.getById(1);
    Assert.assertTrue(pizzaCalabresaRecuperada.getPreco() == 103.5);
  }

  @Test
  public void deveSalvarPizzaCalabresaValidarTempoPreparo() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaCalabresa);
    Pizza pizzaCalabresaRecuperada = pizzaService.getById(1);
    Assert.assertTrue(27.5 == pizzaCalabresaRecuperada.getTempoPreparo());
  }

  @Test
  public void deveSalvarPizzaPortuguesaComBaconExtraValidarPreco() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaPortuguesaBaconExtra);
    Pizza pizzaCalabresaRecuperada = pizzaService.getById(2);
    Assert.assertTrue(103.5 == pizzaCalabresaRecuperada.getPreco());
  }

  @Test
  public void deveRecuperarDuasPizzas() {
    pizzaService.save(pizzaCalabresa);
    pizzaService.save(pizzaPortuguesa);
    List<Pizza> pizzaAll = pizzaService.getAll();
    Assert.assertEquals(2, pizzaAll.size());
  }

  @Test
  public void deveRecuperarPizzaComTrintaSeteMinutosMeioDePreparo() throws PizzaNaoEncontradaException {
    pizzaService.save(pizzaPortuguesa);
    Pizza pizzaRecuperada = pizzaService.getById(1);
    Assert.assertTrue(37.5 == pizzaRecuperada.getTempoPreparo());
  }
}
