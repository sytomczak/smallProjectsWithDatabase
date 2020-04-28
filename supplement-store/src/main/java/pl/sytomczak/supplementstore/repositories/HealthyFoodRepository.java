package pl.sytomczak.supplementstore.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sytomczak.supplementstore.mappings.HealthyFood;

public interface HealthyFoodRepository extends CrudRepository<HealthyFood, Integer> {
}
