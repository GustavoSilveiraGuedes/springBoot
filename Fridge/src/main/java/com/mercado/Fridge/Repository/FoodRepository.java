package com.mercado.Fridge.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercado.Fridge.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long>{

}