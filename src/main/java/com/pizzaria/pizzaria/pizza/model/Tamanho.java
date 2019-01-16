package com.pizzaria.pizzaria.pizza.model;

public enum Tamanho {
  PEQUENA("pequena:"),
  MEDIA("media"),
  GRANDE("grande:");

  private String tamanho;

  Tamanho(String tamanho) {
    this.tamanho = tamanho;
  }
}
