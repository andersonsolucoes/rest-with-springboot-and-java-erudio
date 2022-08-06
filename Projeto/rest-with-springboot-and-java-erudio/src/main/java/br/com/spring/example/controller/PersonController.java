package br.com.spring.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.example.model.Person;
import br.com.spring.example.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
		@Autowired
		private PersonServices service;
		
		@RequestMapping(method=RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Person> findAll() throws Exception {
			return service.findAll(); 
		}
		
		@RequestMapping(value = "/{id}",
				method=RequestMethod.GET,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Person findById(@PathVariable(value = "id") String id) throws Exception {
			return service.findById(id); 
		}
		
		@RequestMapping(method=RequestMethod.POST,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Person create(@RequestBody Person person) throws Exception {
			return service.create(person); 
		}
		
		@RequestMapping(method=RequestMethod.PUT,
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public Person update(@RequestBody Person person) throws Exception {
			return service.update(person); 
		}
		
		@RequestMapping(value = "/{id}",
				method=RequestMethod.DELETE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public void delete(@PathVariable(value = "id") String id) throws Exception {
			service.delete(id); 
		}
}