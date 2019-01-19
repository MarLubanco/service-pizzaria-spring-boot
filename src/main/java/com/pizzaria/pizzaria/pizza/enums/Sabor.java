package com.pizzaria.pizzaria.pizza.enums;

import com.pizzaria.pizzaria.pizza.model.EscolhaSabor;
import com.pizzaria.pizzaria.pizza.model.Pizza;
import lombok.extern.slf4j.Slf4j;

import static com.sun.activation.registries.LogSupport.log;

@Slf4j
public enum Sabor implements EscolhaSabor {
  CALABRESA("calabresa") {
    @Override
    public void prepararSabor(Pizza pizza) {
      log.info("Pizza de calabresa selecionada");
    }
  },
  MARGUERITA("marguerita") {
    @Override
    public void prepararSabor(Pizza pizza) {
      log.info("Pizza de marguerita selecionada");
    }
  },
  PORTUGUESA("portuguesa") {
    @Override
    public void prepararSabor(Pizza pizza) {
      pizza.setTempoPreparo(pizza.getTempoPreparo() + 5.0);
      log.info("Pizza de portuguesa selecionada");
    }
  };

  private String sabor;

  Sabor(String sabor) {
    this.sabor = sabor;
  }
}
