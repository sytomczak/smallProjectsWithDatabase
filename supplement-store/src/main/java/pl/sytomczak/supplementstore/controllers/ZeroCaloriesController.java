package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.ZeroCalories;
import pl.sytomczak.supplementstore.repositories.ZeroCaloriesRepository;


@RestController
@RequestMapping("zeroCalories")
public class ZeroCaloriesController {

    private ZeroCaloriesRepository repository;

    @Autowired
    public ZeroCaloriesController(ZeroCaloriesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getZeroCalorie")
    public ZeroCalories getZeroCalorieById(@RequestParam Integer zeroCalorieId) {
        return (ZeroCalories) repository.findById(zeroCalorieId).orElseGet(ZeroCalories::new); }
//
//    @GetMapping("/getZeroCalorie/{zeroCalorieName}")
//    @Query("SELECT t.name FROM ZeroCalories t where t.name = :name")
//    //@RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    public ZeroCalories getZeroCaloriesName(@PathVariable String name) {
//        System.out.println("get zero kalooooriees");
//        return repository.getZeroCaloriesByName(name);
//}
        //TODO: getName sprawdzic czy działa i poprawic
    //TODO: pobieranie wsystkich

    @PostMapping("/addZeroCalorie")
    public void addZeroCalorie(@RequestBody ZeroCalories zeroCalories) {
        repository.save(zeroCalories);
        if(zeroCalories != null)
            System.out.println("id: " + zeroCalories.getId() + ", name: " +zeroCalories.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteZeroCalorie")
    public void deleteZeroCalorieId(@RequestParam ZeroCalories zeroCalorieId) {
        repository.delete(zeroCalorieId);
    }

    @PutMapping("/putZeroCalories")
    public void putZeroCalories(@RequestBody ZeroCalories selectZeroCalories) {
        ZeroCalories zeroCalories = repository.findById(selectZeroCalories.getId()).get();
        if (zeroCalories != null) {
            zeroCalories.setName(selectZeroCalories.getName());
            repository.save(zeroCalories);

            System.out.println("id: " + zeroCalories.getId() + ", name: " + zeroCalories.getName());
        } else
            System.out.println("Error");
    }
}

