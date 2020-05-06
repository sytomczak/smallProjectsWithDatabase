package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.FatBurner;
import pl.sytomczak.supplementstore.mappings.Protein;
import pl.sytomczak.supplementstore.repositories.FatBurnersRepository;
import pl.sytomczak.supplementstore.repositories.ProteinRepository;

@RestController
@RequestMapping("fatBurner")
public class FatBurnerController {


    private FatBurnersRepository repository;

    @Autowired
    public FatBurnerController(FatBurnersRepository repository) {this.repository = repository; }

    @GetMapping("/getFatBurner")
    public FatBurner getFatBurnerId(@RequestParam Integer fatBurnerId) {
        return (FatBurner) repository.findById(fatBurnerId).orElseGet(FatBurner::new);
    }

    @PostMapping("/addFatBurner")
    public void addFatBurner(@RequestBody FatBurner fatBurner) {
        repository.save(fatBurner);
        if(fatBurner != null)
            System.out.println("id: " + fatBurner.getId() + ", name: " + fatBurner.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteFatBurner")
    public void deleteFatBurnerId(@RequestParam FatBurner fatBurnerId) {
        repository.delete(fatBurnerId);
    }

    @PutMapping("/putFatBurner")
    public void putFatBurner(@RequestBody FatBurner selectFatBurner) {
        FatBurner fatBurner = repository.findById(selectFatBurner.getId()).get();
        if (selectFatBurner != null) {
            fatBurner.setName(selectFatBurner.getName());
            repository.save(fatBurner);

            System.out.println("id: " + fatBurner.getId() + ", name: " + fatBurner.getName());
        } else
            System.out.println("Error");
    }

}
