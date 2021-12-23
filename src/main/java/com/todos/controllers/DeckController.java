package com.todos.controllers;

import com.todos.domain.dtos.card.UpdateCardDTO;
import com.todos.domain.dtos.deck.CreateDeckDTO;
import com.todos.domain.dtos.deck.DeckDTO;
import com.todos.domain.dtos.deck.InsertCardDTO;
import com.todos.domain.models.Card;
import com.todos.domain.models.Deck;
import com.todos.services.DeckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deck")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @GetMapping
    public List<DeckDTO> getAll(){
        return deckService.findAll();
    }

    @GetMapping("/{id}")
    public DeckDTO getById(@PathVariable Long id){
        return deckService.findById(id);
    }

    @PostMapping
    public DeckDTO create(@RequestBody CreateDeckDTO createDeckDTO){
        return deckService.create(createDeckDTO);
    }

    @PutMapping("/{id}")
    public DeckDTO update(@PathVariable Long id, @RequestBody UpdateCardDTO updateCardDTO) {
        return deckService.update(id, updateCardDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return deckService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public DeckDTO insertCard(@PathVariable Long id, @RequestBody InsertCardDTO cards){
        return deckService.insertCard(id, cards);
    }
}
