package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.Carbo;
import pl.sytomczak.supplementstore.mappings.Creatine;
import pl.sytomczak.supplementstore.repositories.CarboRepository;
import pl.sytomczak.supplementstore.repositories.CreatineRepository;

@RestController
@RequestMapping("carbo")
public class CarboController {


    private CarboRepository repository;

    @Autowired
    public CarboController(CarboRepository repository) {this.repository = repository; }

    @GetMapping("/getCarbo")
    public Carbo getCarboId(@RequestParam Integer carboId) {
        return (Carbo) repository.findById(carboId).orElseGet(Carbo::new);
    }

    @PostMapping("/addCarbo")
    public void addCarbo(@RequestBody Carbo carbo) {
        repository.save(carbo);
        if(carbo != null)
            System.out.println("id: " + carbo.getId() + ", name: " + carbo.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteCarbo")
    public void deleteCarboId(@RequestParam Carbo carboId) {
        repository.delete(carboId);
    }

    @PutMapping("/putCarbo")
    public void putCarbo(@RequestBody Creatine selectCarbo) {
        Carbo carbo = repository.findById(selectCarbo.getId()).get();
        if (selectCarbo != null) {
            carbo.setName(selectCarbo.getName());
            repository.save(carbo);

            System.out.println("id: " + carbo.getId() + ", name: " + carbo.getName());
        } else
            System.out.println("Error");
    }
}
