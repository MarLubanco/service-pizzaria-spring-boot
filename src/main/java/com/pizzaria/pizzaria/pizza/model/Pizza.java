package com.pizzaria.pizzaria.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
  private Sabor sabor;

  @Column
  @Enumerated(EnumType.STRING)
  private Tamanho tamanho;

  @Column
  private Double preco;

  @Column
  private Double tempoPreparo;
}
