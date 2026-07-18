package com.mercado.Fridge.controller;

import java.util.List;
import com.mercado.Fridge.model.Food;
import com.mercado.Fridge.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodControler {

    public FoodControler(FoodService foodService){
        this.foodService = foodService;
    }

    //ingeção de dependencia
    private final FoodService foodService;

    @GetMapping
    public List<Food> getAll(){return foodService.getAll();}

    @PostMapping
    public Food criate(@RequestBody Food food){return foodService.save(food);}
}