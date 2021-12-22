package com.todos.services;

import com.todos.domain.dtos.card.UpdateCardDTO;
import com.todos.domain.dtos.deck.CreateDeckDTO;
import com.todos.domain.dtos.deck.DeckDTO;
import com.todos.domain.dtos.deck.InsertCardDTO;
import com.todos.domain.models.Card;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DeckService {


    List<DeckDTO> findAll();

    DeckDTO findById(Long id);

    DeckDTO create(CreateDeckDTO createDeckDTO);

    DeckDTO update(Long id, UpdateCardDTO updateCardDTO);

    ResponseEntity<Void> deleteById(Long id);

    DeckDTO insertCard(Long id, InsertCardDTO cards);
}
