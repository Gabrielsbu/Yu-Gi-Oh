package com.todos.controllers;

import com.todos.domain.dtos.person.CreatePersonDTO;
import com.todos.domain.dtos.person.PersonDTO;
import com.todos.domain.dtos.person.UpdatePersonDTO;
import com.todos.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> getAll(){
        return personService.findAll();
    }
    
    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PostMapping
    public PersonDTO create(@RequestBody CreatePersonDTO person){
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public PersonDTO update(@PathVariable Long id, @RequestBody UpdatePersonDTO person){
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return personService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public PersonDTO buyDeck(@PathVariable Long id, @RequestParam Long deckId){
        return personService.buyDeck(id, deckId);
    }

    @PatchMapping("/{id}/buy-card")
    public PersonDTO buyCard(@PathVariable Long id, @RequestParam Long cardId){
        return personService.buyCard(id, cardId);
    }

    @PatchMapping("/{id}/sell-card")
    public PersonDTO sellCard(@PathVariable Long id, @RequestParam Long cardId){
        return personService.sellCard(id, cardId);
    }
}
