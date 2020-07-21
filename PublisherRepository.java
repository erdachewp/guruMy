package guru.springframework.webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import guru.springframework.webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher ,Long> {

}
