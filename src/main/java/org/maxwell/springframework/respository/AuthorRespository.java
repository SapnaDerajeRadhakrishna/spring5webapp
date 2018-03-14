package org.maxwell.springframework.respository;

import org.maxwell.springframework.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRespository extends CrudRepository<Author, Long> {

}
