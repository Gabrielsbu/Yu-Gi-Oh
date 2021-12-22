package com.todos.services;

import com.todos.domain.dtos.person.CreatePersonDTO;
import com.todos.domain.dtos.person.PersonDTO;
import com.todos.domain.dtos.person.UpdatePersonDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    List<PersonDTO> findAll();

    PersonDTO findById(Long id);

    PersonDTO create(CreatePersonDTO person);

    PersonDTO update(Long id, UpdatePersonDTO person);

    ResponseEntity<Void> deleteById(Long id);
}
