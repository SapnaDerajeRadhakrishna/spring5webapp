package org.maxwell.springframework.respository;

import org.maxwell.springframework.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
