package pl.sytomczak.supplementstore.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sytomczak.supplementstore.mappings.Protein;

public interface ProteinRepository extends CrudRepository<Protein, Integer> {
}
