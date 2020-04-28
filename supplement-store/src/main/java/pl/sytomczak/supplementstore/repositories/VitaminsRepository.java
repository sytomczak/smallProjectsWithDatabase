package pl.sytomczak.supplementstore.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sytomczak.supplementstore.mappings.Vitamins;

public interface VitaminsRepository extends CrudRepository<Vitamins, Integer> {
}
