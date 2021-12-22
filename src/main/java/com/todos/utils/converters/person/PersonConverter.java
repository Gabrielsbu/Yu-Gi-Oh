package com.todos.utils.converters.person;

import com.todos.domain.dtos.person.CreatePersonDTO;
import com.todos.domain.dtos.person.PersonDTO;
import com.todos.domain.models.Deck;
import com.todos.domain.models.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonConverter {

    PersonDTO toDTO(Person person);

    Person toCreateModel(CreatePersonDTO createPersonDTO);

    List<PersonDTO> toCollectionDTO(List<Person> persons);
}
