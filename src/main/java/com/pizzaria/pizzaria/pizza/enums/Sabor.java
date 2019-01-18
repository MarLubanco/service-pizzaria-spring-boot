package com.pizzaria.pizzaria.pizza.enums;

import com.pizzaria.pizzaria.pizza.model.EscolhaSabor;
import com.pizzaria.pizzaria.pizza.model.Pizza;

import static com.sun.activation.registries.LogSupport.log;

public enum Sabor implements EscolhaSabor {
  CALABRESA("calabresa") {
    @Override
    public void prepararSabor(Pizza pizza) {
      log("Pizza de calabresa selecionada");
    }
  },
  MARGUERITA("marguerita") {
    @Override
    public void prepararSabor(Pizza pizza) {
      log("Pizza de marguerita selecionada");
    }
  },
  PORTUGUESA("portuguesa"){
    @Override
    public void prepararSabor(Pizza pizza) {
      pizza.setTempoPreparo(pizza.getTempoPreparo() + 5.0);
      log("Pizza de portuguesa selecionada");
    }
  };

  private String sabor;

  Sabor(String sabor) {
    this.sabor = sabor;
  }
}
