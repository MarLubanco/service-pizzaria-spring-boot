package com.pizzaria.pizzaria.pizza.repository;

import com.pizzaria.pizzaria.pizza.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
