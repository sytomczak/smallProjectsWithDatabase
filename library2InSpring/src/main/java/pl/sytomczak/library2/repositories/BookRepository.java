package pl.sytomczak.library2.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.sytomczak.library2.mappings.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
}
