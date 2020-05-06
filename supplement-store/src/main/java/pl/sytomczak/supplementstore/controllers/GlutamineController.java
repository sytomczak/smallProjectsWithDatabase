package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.Glutamine;
import pl.sytomczak.supplementstore.mappings.Vitamins;
import pl.sytomczak.supplementstore.repositories.GlutamineRepository;
import pl.sytomczak.supplementstore.repositories.VitaminsRepository;


@RestController
@RequestMapping("glutamine")
public class GlutamineController {

    private GlutamineRepository repository;

    @Autowired
    public GlutamineController(GlutamineRepository repository) {this.repository = repository; }

    @GetMapping("/getGlutamine")
    public Glutamine getGlutamineById(@RequestParam Integer glutamineId) {
        return (Glutamine) repository.findById(glutamineId).orElseGet(Glutamine::new);
    }

    @PostMapping("/addGlutamine")
    public void addGlutamine(@RequestBody Glutamine glutamine) {
        repository.save(glutamine);
        if(glutamine != null)
            System.out.println("id: " + glutamine.getId() + ", name: " + glutamine.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteGlutamine")
    public void deleteGlutamineId(@RequestParam Glutamine glutamineId) {
        repository.delete(glutamineId);
    }

    @PutMapping("/putGlutamine")
    public void putGlutamine(@RequestBody Glutamine selectGlutamine) {
        Glutamine glutamine = repository.findById(selectGlutamine.getId()).get();
        if (glutamine != null) {
            glutamine.setName(selectGlutamine.getName());
            repository.save(glutamine);

            System.out.println("id: " + glutamine.getId() + ", name: " + glutamine.getName());
        } else
            System.out.println("Error");
    }


}
