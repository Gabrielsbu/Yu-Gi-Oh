package com.todos.services.impl;

import com.todos.domain.dtos.person.CreatePersonDTO;
import com.todos.domain.dtos.person.PersonDTO;
import com.todos.domain.dtos.person.UpdatePersonDTO;
import com.todos.domain.models.Person;
import com.todos.exceptions.GlobalException;
import com.todos.repositories.PersonRepository;
import com.todos.services.PersonService;
import com.todos.utils.converters.person.PersonConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    private Person byId(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new GlobalException("Personagem não encontrado", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<PersonDTO> findAll() {
        return personConverter.toCollectionDTO(personRepository.findAll());
    }

    @Override
    public PersonDTO findById(Long id) {
        return personConverter.toDTO(personRepository.findById(id).orElseThrow(() -> new GlobalException("Personagem não encontrado", HttpStatus.NOT_FOUND)));
    }

    @Override
    public PersonDTO create(CreatePersonDTO person) {

        Person personToBeCreated = personConverter.toCreateModel(person);

        return personConverter.toDTO(personRepository.save(personToBeCreated));
    }

    @Override
    public PersonDTO update(Long id, UpdatePersonDTO person) {
        Person personExistent = personRepository.getById(id);
        personExistent.setFullName(person.getFullName());
        personExistent.setEmail(person.getEmail());
        personExistent.setAvatarUri(person.getAvatarUri());
        personExistent.setTeam(person.getTeam());

        return personConverter.toDTO(personRepository.save(personExistent));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        Person personExistent = byId(id);

        personRepository.deleteById(personExistent.getId());
        return ResponseEntity.noContent().build();
    }
}
