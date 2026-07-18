package com.mercado.Fridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mercado.Fridge.Repository.FoodRepository;
import com.mercado.Fridge.model.Food;   

@Service
public class FoodService{

    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }
    
    private final FoodRepository foodRepository;

    // LISTAR
    public List<Food> getAll() {return foodRepository.findAll();}
    // CRIAR
    public Food save(Food food) {return foodRepository.save(food);}
    // DELETAR
    public void delete(Long id){foodRepository.deleteById(id);}
}