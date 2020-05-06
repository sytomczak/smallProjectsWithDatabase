package pl.sytomczak.supplementstore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sytomczak.supplementstore.mappings.Protein;
import pl.sytomczak.supplementstore.mappings.Vitamins;
import pl.sytomczak.supplementstore.repositories.ProteinRepository;
import pl.sytomczak.supplementstore.repositories.VitaminsRepository;

@RestController
@RequestMapping("protein")
public class ProteinController {

    private ProteinRepository repository;

    @Autowired
    public ProteinController(ProteinRepository repository) {this.repository = repository; }

    @GetMapping("/getProtein")
    public Protein getProteinById(@RequestParam Integer proteinId) {
        return (Protein) repository.findById(proteinId).orElseGet(Protein::new);
    }

    @PostMapping("/addProtein")
    public void addProtein(@RequestBody Protein protein) {
        repository.save(protein);
        if(protein != null)
            System.out.println("id: " + protein.getId() + ", name: " + protein.getName());
        else
            System.out.println("Error");

    }

    @DeleteMapping("/deleteProtein")
    public void deleteProetinId(@RequestParam Protein proteinId) {
        repository.delete(proteinId);
    }

    @PutMapping("/putProtein")
    public void putProtein(@RequestBody Protein selectProtein) {
        Protein protein = repository.findById(selectProtein.getId()).get();
        if (protein != null) {
            protein.setName(selectProtein.getName());
            repository.save(protein);

            System.out.println("id: " + protein.getId() + ", name: " + protein.getName());
        } else
            System.out.println("Error");
    }


}
