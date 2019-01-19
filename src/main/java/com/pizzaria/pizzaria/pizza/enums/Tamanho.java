package com.pizzaria.pizzaria.pizza.enums;

import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.model.EscolhaTamanho;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Tamanho implements EscolhaTamanho {
  PEQUENA("pequena") {
    @Override
    public void selecionarTamanhoPizza(Pizza pizza) {
      pizza.setPreco(pizza.getPreco() + 20.0);
      pizza.setTempoPreparo(pizza.getTempoPreparo() + 15);
    }
  },
  MEDIA("media") {
    @Override
    public void selecionarTamanhoPizza(Pizza pizza) {
      pizza.setPreco(pizza.getPreco() + 30.0);
      pizza.setTempoPreparo(pizza.getTempoPreparo() + 20);
    }
  },
  GRANDE("grande") {
    @Override
    public void selecionarTamanhoPizza(Pizza pizza) {
      pizza.setPreco(pizza.getPreco() + 40.0);
      pizza.setTempoPreparo(pizza.getTempoPreparo() + 25);
    }
  };

  private String tamanho;

  Tamanho(String tamanho) {
    this.tamanho = tamanho;
  }
}
