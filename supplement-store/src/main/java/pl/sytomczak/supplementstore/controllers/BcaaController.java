package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.Bcaa;
import pl.sytomczak.supplementstore.mappings.Carbo;
import pl.sytomczak.supplementstore.mappings.Creatine;
import pl.sytomczak.supplementstore.repositories.BcaaRepository;
import pl.sytomczak.supplementstore.repositories.CarboRepository;

@RestController
@RequestMapping("bcaa")
public class BcaaController {

    private BcaaRepository repository;

    @Autowired
    public BcaaController(BcaaRepository repository) {this.repository = repository; }

    @GetMapping("/getBcaa")
    public Bcaa getBcaaId(@RequestParam Integer bcaaId) {
        return (Bcaa) repository.findById(bcaaId).orElseGet(Bcaa::new);
    }

    @PostMapping("/addBcaa")
    public void addBcaa(@RequestBody Bcaa bcaa) {
        repository.save(bcaa);
        if(bcaa != null)
            System.out.println("id: " + bcaa.getId() + ", name: " + bcaa.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteBcaa")
    public void deleteBcaaId(@RequestParam Bcaa bcaaId) {
        repository.delete(bcaaId);
    }

    @PutMapping("/putBcaa")
    public void putBcaa(@RequestBody Bcaa selectBcaa) {
        Bcaa bcaa = repository.findById(selectBcaa.getId()).get();
        if (selectBcaa != null) {
            bcaa.setName(selectBcaa.getName());
            repository.save(bcaa);

            System.out.println("id: " + bcaa.getId() + ", name: " + bcaa.getName());
        } else
            System.out.println("Error");
    }
}
