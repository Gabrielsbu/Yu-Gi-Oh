package com.todos.controllers;

import com.todos.domain.dtos.card.CardDTO;
import com.todos.domain.dtos.card.CreateCardDTO;
import com.todos.domain.dtos.card.UpdateCardDTO;
import com.todos.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<CardDTO> getAll(){
        return cardService.findAll();
    }

    @GetMapping("/{id}")
    public CardDTO getById(@PathVariable Long id){
        return cardService.findById(id);
    }

    @PostMapping
    public CardDTO create(@RequestBody CreateCardDTO card){
        return cardService.create(card);
    }

    @PutMapping("/{id}")
    public CardDTO update(@PathVariable Long id, @RequestBody UpdateCardDTO card){
        return cardService.update(id, card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return cardService.deleteById(id);
    }
}
