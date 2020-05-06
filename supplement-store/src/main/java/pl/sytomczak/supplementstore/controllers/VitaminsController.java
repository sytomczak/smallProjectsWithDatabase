package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.Vitamins;
import pl.sytomczak.supplementstore.repositories.VitaminsRepository;

@RestController
@RequestMapping("vitamins")
public class VitaminsController {

    private VitaminsRepository repository;

    @Autowired
    public VitaminsController(VitaminsRepository repository) {this.repository = repository; }

    @GetMapping("/getVitamins")
    public Vitamins getVitaminsById(@RequestParam Integer vitaminsId) {
        return (Vitamins) repository.findById(vitaminsId).orElseGet(Vitamins::new);
    }

    @PostMapping("/addVitamins")
    public void addZeroCalorie(@RequestBody Vitamins vitamins) {
        repository.save(vitamins);
        if(vitamins != null)
            System.out.println("id: " + vitamins.getId() + ", name: " + vitamins.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteVitamins")
    public void deleteZeroCalorieId(@RequestParam Vitamins vitaminsId) {
        repository.delete(vitaminsId);
    }

    @PutMapping("/putVitamins")
    public void putZeroCalories(@RequestBody Vitamins selectVitamins) {
        Vitamins vitamins = repository.findById(selectVitamins.getId()).get();
        if (vitamins != null) {
            vitamins.setName(selectVitamins.getName());
            repository.save(vitamins);

            System.out.println("id: " + vitamins.getId() + ", name: " + vitamins.getName());
        } else
            System.out.println("Error");
    }


}