package org.maxwell.springframework.respository;

import org.maxwell.springframework.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Long> {

}
