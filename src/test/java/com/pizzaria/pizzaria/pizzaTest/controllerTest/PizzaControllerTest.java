package com.pizzaria.pizzaria.pizzaTest.controllerTest;

import com.pizzaria.pizzaria.pizza.enums.Personalizacao;
import com.pizzaria.pizzaria.pizza.enums.Sabor;
import com.pizzaria.pizzaria.pizza.enums.Tamanho;
import com.pizzaria.pizzaria.pizza.model.Pizza;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PizzaControllerTest {

  @Autowired
  private MockMvc mockMvc;

  Pizza pizza = new Pizza().builder()
          .id(1)
          .preco(60.5)
          .tamanho(Tamanho.GRANDE)
          .sabor(Sabor.CALABRESA)
          .tempoPreparo(2.5)
          .personalizacaos(Personalizacao.EXTRA_BACON)
          .build();

  @Test
  public void deveRecuperarTodasAsPizzas() throws Exception {
    mockMvc.perform(
            get("/pizzas")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Content-Type", "application/json"))
            .andExpect(status().isOk());
  }

  @Test
  public void deveRecuperarUmaPizza() throws Exception {
    mockMvc.perform(
            get("/pizzas/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .header("Content-Type", "application/json"))
            .andExpect(status().isOk());
  }
}
