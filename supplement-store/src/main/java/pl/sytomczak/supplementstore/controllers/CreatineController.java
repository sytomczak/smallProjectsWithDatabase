package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.Creatine;
import pl.sytomczak.supplementstore.repositories.CreatineRepository;

@RestController
@RequestMapping("creatine")
public class CreatineController {

    private CreatineRepository repository;

    @Autowired
    public CreatineController(CreatineRepository repository) {this.repository = repository; }

    @GetMapping("/getCreatine")
    public Creatine getCreatineId(@RequestParam Integer creatineId) {
        return (Creatine) repository.findById(creatineId).orElseGet(Creatine::new);
    }

    @PostMapping("/addCreatine")
    public void addCreatine(@RequestBody Creatine creatine) {
        repository.save(creatine);
        if(creatine != null)
            System.out.println("id: " + creatine.getId() + ", name: " + creatine.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteCreatine")
    public void deleteCreatineId(@RequestParam Creatine creatineId) {
        repository.delete(creatineId);
    }

    @PutMapping("/putCreatine")
    public void putCreatine(@RequestBody Creatine selectCreatine) {
        Creatine creatine = repository.findById(selectCreatine.getId()).get();
        if (selectCreatine != null) {
            creatine.setName(selectCreatine.getName());
            repository.save(creatine);

            System.out.println("id: " + creatine.getId() + ", name: " + creatine.getName());
        } else
            System.out.println("Error");
    }

}
