package pl.sytomczak.supplementstore.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sytomczak.supplementstore.mappings.Bars;

public interface BarsRepository extends CrudRepository<Bars, Integer> {
}
