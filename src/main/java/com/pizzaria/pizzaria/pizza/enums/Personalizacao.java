package com.pizzaria.pizzaria.pizza.enums;

import com.pizzaria.pizzaria.pizza.model.Pizza;
import com.pizzaria.pizzaria.pizza.repository.PersonalizacaoInterface;

import static com.sun.activation.registries.LogSupport.log;

public enum Personalizacao implements PersonalizacaoInterface {
  EXTRA_BACON("Extra bacon") {
    @Override
    public void atualizarPizza(Pizza pizza) {
      pizza.setPreco(pizza.getPreco() + 3.00);
      log("Personalização de Extra bacon selecionado");
    }
  },
  SEM_CEBOLA("Sem cebola") {
    @Override
    public void atualizarPizza(Pizza pizza) {
      log("Personalização de sem cebola selecionado");
    }
  },
  BORDA_RECHEADA("Borda recheada") {
    @Override
    public void atualizarPizza(Pizza pizza) {
      pizza.setPreco(pizza.getPreco() + 5.00);
      pizza.setTempoPreparo(pizza.getTempoPreparo() + 5.00);
      log("Personalização de Borda recheada selecionado");
    }
  };

  private String personalizacao;

  Personalizacao(String personalizacao) {
    this.personalizacao = personalizacao;
  }
}
