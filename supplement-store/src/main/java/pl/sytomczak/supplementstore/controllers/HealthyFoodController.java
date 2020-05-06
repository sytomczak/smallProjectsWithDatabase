package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.HealthyFood;
import pl.sytomczak.supplementstore.mappings.Vitamins;
import pl.sytomczak.supplementstore.repositories.HealthyFoodRepository;
import pl.sytomczak.supplementstore.repositories.VitaminsRepository;

@RestController
@RequestMapping("food")
public class HealthyFoodController {


    private HealthyFoodRepository repository;

    @Autowired
    public HealthyFoodController(HealthyFoodRepository repository) {this.repository = repository; }

    @GetMapping("/getFood")
    public HealthyFood getFoodById(@RequestParam Integer foodId) {
        return (HealthyFood) repository.findById(foodId).orElseGet(HealthyFood::new);
    }

    @PostMapping("/addFood")
    public void addFood(@RequestBody HealthyFood food) {
        repository.save(food);
        if(food != null)
            System.out.println("id: " + food.getId() + ", name: " + food.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteFood")
    public void deleteFoodId(@RequestParam HealthyFood foodId) {
        repository.delete(foodId);
    }

    @PutMapping("/putFood")
    public void putFood(@RequestBody HealthyFood selectFood) {
        HealthyFood food = repository.findById(selectFood.getId()).get();
        if (food != null) {
            food.setName(selectFood.getName());
            repository.save(food);

            System.out.println("id: " + food.getId() + ", name: " + food.getName());
        } else
            System.out.println("Error");
    }

}
