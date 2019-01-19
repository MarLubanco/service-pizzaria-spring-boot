package com.pizzaria.pizzaria.pizza.model;

import com.pizzaria.pizzaria.pizza.enums.Personalizacao;
import com.pizzaria.pizzaria.pizza.enums.Sabor;
import com.pizzaria.pizzaria.pizza.enums.Tamanho;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PIZZA")
@Slf4j
public class Pizza {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_sequence")
  @SequenceGenerator(name = "pizza_sequence", sequenceName = "pizza_seq", allocationSize = 1)
  private Integer id;

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

  @Column
  private LocalTime dataPedido;

  @PrePersist
  public void pedidoPronto() {
    this.dataPedido =  LocalDateTime.now().toLocalTime();
    DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("HH:mm");
    log.info("Pedido realizado com sucesso : Horário do pedido " + this.dataPedido.format(dataFormato));
  }
}
