package pl.sytomczak.supplementstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.Bars;
import pl.sytomczak.supplementstore.mappings.Creatine;
import pl.sytomczak.supplementstore.repositories.BarsRepository;
import pl.sytomczak.supplementstore.repositories.CreatineRepository;

@RestController
@RequestMapping("bars")
public class BarsController {

    private BarsRepository repository;

    @Autowired
    public BarsController(BarsRepository repository) {this.repository = repository; }

    @GetMapping("/getBars")
    public Bars getBarsId(@RequestParam Integer barsId) {
        return (Bars) repository.findById(barsId).orElseGet(Bars::new);
    }

    @PostMapping("/addBars")
    public void addBars(@RequestBody Bars bars) {
        repository.save(bars);
        if(bars != null)
            System.out.println("id: " + bars.getId() + ", name: " + bars.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteBars")
    public void deleteBarsId(@RequestParam Bars barsId) {
        repository.delete(barsId);
    }

    @PutMapping("/putBars")
    public void putBars(@RequestBody Bars selectBars) {
        Bars bars = repository.findById(selectBars.getId()).get();
        if (selectBars != null) {
            bars.setName(selectBars.getName());
            repository.save(bars);

            System.out.println("id: " + bars.getId() + ", name: " + bars.getName());
        } else
            System.out.println("Error");
    }

}
