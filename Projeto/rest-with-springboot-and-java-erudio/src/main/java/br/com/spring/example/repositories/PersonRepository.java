package br.com.spring.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.example.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{

}
