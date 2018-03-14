package org.maxwell.springframework.bootstrap;

import org.maxwell.springframework.model.Author;
import org.maxwell.springframework.model.Book;
import org.maxwell.springframework.model.Publisher;
import org.maxwell.springframework.respository.AuthorRespository;
import org.maxwell.springframework.respository.BookRespository;
import org.maxwell.springframework.respository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRespository authorRespository;
	private BookRespository bookRespository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRespository authorRespository, BookRespository bookRespository,
	        PublisherRepository publisherRepository) {
		this.authorRespository = authorRespository;
		this.bookRespository = bookRespository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}

	private void init() {

		Publisher publisher = new Publisher();
		publisher.setName("foo");
		publisher.setAddress("12th Street, LA");
		publisherRepository.save(publisher);

		// Eric

		Author eric = new Author("Eric", "Evans");
		Book book1 = new Book("Domain Driven Design", "1234", publisher);
		eric.getBooks().add(book1);
		book1.getAuthors().add(eric);
		authorRespository.save(eric);
		bookRespository.save(book1);

		// Rod

		Author rod = new Author("Rod", "Johnson");
		Book book2 = new Book("J2EE Development without EJB", "23444", publisher);
		rod.getBooks().add(book2);
		book2.getAuthors().add(rod);
		authorRespository.save(rod);
		bookRespository.save(book2);

	}

}
