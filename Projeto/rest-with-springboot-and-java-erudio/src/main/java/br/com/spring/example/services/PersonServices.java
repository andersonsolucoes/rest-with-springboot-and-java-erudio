package br.com.spring.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.spring.example.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person create(Person person) {
		logger.info("Creating one person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person!");
	}
	
	private Person mockPerson(int i) {
		Person person =  new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Anderson " + i);
		person.setLastName("Florencio " + i);
		person.setGender("Male " + i);
		person.setAddress("Pirambu " + i);
		return person;
	}

	public Person findById(String id) {
		logger.info("Finding one person");
		Person person =  new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Anderson");
		person.setLastName("Florencio");
		person.setGender("Male");
		person.setAddress("Pirambu");
		return person;
	}

}
