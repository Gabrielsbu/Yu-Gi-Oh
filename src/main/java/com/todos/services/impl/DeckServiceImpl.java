package com.todos.services.impl;

import com.todos.domain.dtos.card.UpdateCardDTO;
import com.todos.domain.dtos.deck.CreateDeckDTO;
import com.todos.domain.dtos.deck.DeckDTO;
import com.todos.domain.dtos.deck.InsertCardDTO;
import com.todos.domain.models.Deck;
import com.todos.exceptions.GlobalException;
import com.todos.repositories.DeckRepository;
import com.todos.services.DeckService;
import com.todos.utils.converters.deck.DeckConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DeckServiceImpl implements DeckService {

    private final DeckRepository deckRepository;
    private final DeckConverter deckConverter;

    private Deck byId(Long id){
        return deckRepository.findById(id).orElseThrow(() -> new GlobalException("Deck não encontrado", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<DeckDTO> findAll() {
        return deckConverter.toCollectionDTO(deckRepository.findAll());
    }

    @Override
    public DeckDTO findById(Long id) {
        return deckConverter.toDTO(byId(id));
    }

    @Override
    public DeckDTO create(CreateDeckDTO createDeckDTO) {
        Deck deck = deckConverter.toCreateModel(createDeckDTO);

        return deckConverter.toDTO(deckRepository.save(deck));
    }

    @Override
    public DeckDTO update(Long id, UpdateCardDTO updateCardDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        Deck deck = byId(id);

        deckRepository.deleteById(deck.getId());

        return ResponseEntity.noContent().build();
    }

    @Override
    public DeckDTO insertCard(Long id, InsertCardDTO cards){
        Deck deck = byId(id);

        if(!cards.getCards().isEmpty()){
            cards.getCards().forEach(card -> deck.getCards().add(card));
        }

        return deckConverter.toDTO(deckRepository.save(deck));
    }
}
