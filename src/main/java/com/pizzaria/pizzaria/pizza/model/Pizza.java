package com.pizzaria.pizzaria.pizza.model;

import com.pizzaria.pizzaria.pizza.enums.Personalizacao;
import com.pizzaria.pizzaria.pizza.enums.Sabor;
import com.pizzaria.pizzaria.pizza.enums.Tamanho;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pizza {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  @Enumerated(EnumType.STRING)
  @NotNull
  private Sabor sabor;

  @Column
  @Enumerated(EnumType.STRING)
  @NotNull
  private Tamanho tamanho;

  @Column
  private Double preco;

  @Column
  private Double tempoPreparo;

  @Column
  private Personalizacao personalizacaos;
}
