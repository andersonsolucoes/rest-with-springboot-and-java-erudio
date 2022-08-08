package br.com.spring.example.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.example.controller.BookController;
import br.com.spring.example.data.vo.v1.BookVO;
import br.com.spring.example.exceptions.RequiredObjectIsNullException;
import br.com.spring.example.exceptions.ResourceNotFoundException;
import br.com.spring.example.mapper.DozerMapper;
import br.com.spring.example.model.Book;
import br.com.spring.example.repositories.BookRepository;

@Service
public class BookServices {

	private Logger logger = Logger.getLogger(BookServices.class.getName());
	
	@Autowired
	BookRepository repository;
	
	public List<BookVO> findAll(){
		logger.info("Find all books!");
		var books =  DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
		books
			.stream()
			.forEach(p -> {
				try {
					p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		return books;
	}
	
	public BookVO findById(Long id) throws Exception {
		logger.info("Finding one BookVO");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var vo = DozerMapper.parseObject(entity, BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		
		return vo;
	}
	
	public BookVO create(BookVO book) throws Exception {
		
		if(book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public BookVO update(BookVO book) throws Exception {

		if(book == null) throw new RequiredObjectIsNullException();
		
		logger.info("Updating one BookVO!");
		var entity = repository.findById(book.getKey()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
		entity.setAuthor(book.getAuthor());
		entity.setTitle(book.getTitle());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);
		vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		logger.info("Deleting one BookVO!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}
