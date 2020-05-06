package pl.sytomczak.supplementstore.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sytomczak.supplementstore.mappings.FatBurner;

public interface FatBurnersRepository extends CrudRepository<FatBurner, Integer> {
}
