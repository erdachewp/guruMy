package guru.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.webapp.domain.Author;

public interface AuthorRepository extends CrudRepository <Author, Long> {

}
