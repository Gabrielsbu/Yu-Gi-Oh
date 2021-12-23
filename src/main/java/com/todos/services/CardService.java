package com.todos.services;

import com.todos.domain.dtos.card.CardDTO;
import com.todos.domain.dtos.card.CreateCardDTO;
import com.todos.domain.dtos.card.UpdateCardDTO;
import com.todos.domain.models.Card;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CardService {

    List<CardDTO> findAll();

    Card byId(Long id);

    CardDTO createSimpleCard(Card card);

    CardDTO findById(Long id);

    CardDTO create(CreateCardDTO card);

    CardDTO update(Long id, UpdateCardDTO card);

    ResponseEntity<Void> deleteById(Long id);
}
