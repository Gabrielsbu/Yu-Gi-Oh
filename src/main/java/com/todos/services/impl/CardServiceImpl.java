package com.todos.services.impl;

import com.todos.domain.dtos.card.CardDTO;
import com.todos.domain.dtos.card.CreateCardDTO;
import com.todos.domain.dtos.card.UpdateCardDTO;
import com.todos.domain.models.Card;
import com.todos.exceptions.GlobalException;
import com.todos.repositories.CardRepository;
import com.todos.services.CardService;
import com.todos.utils.converters.card.CardConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardConverter cardConverter;

    @Override
    public List<CardDTO> findAll() {
        return cardConverter.toCollectionDTO(cardRepository.findAll());
    }

    @Override
    public CardDTO findById(Long id) {
        return cardConverter.toDTO(cardRepository.findById(id).orElseThrow(() -> new GlobalException("Carta não encontrada", HttpStatus.NOT_FOUND)));
    }

    @Override
    public CardDTO create(CreateCardDTO card) {
        Card cardModel = cardConverter.toCreateModel(card);

        return cardConverter.toDTO(cardRepository.save(cardModel));
    }

    @Override
    public CardDTO update(Long id, UpdateCardDTO card) {
        Card cardExistent = cardRepository.getById(id);
        cardExistent.setName(card.getName());
        cardExistent.setStars(card.getStars());
        cardExistent.setAvatarUri(card.getAvatarUri());
        cardExistent.setDescription(card.getDescription());
        cardExistent.setType(card.getType());

        if(!card.getType().equals("trap")) {
            cardExistent.setAtk(card.getAtk());
            cardExistent.setDef(card.getDef());
        }

        return cardConverter.toDTO(cardRepository.save(cardExistent));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        Card cardExistent = cardRepository.findById(id).orElseThrow();

        cardRepository.deleteById(cardExistent.getId());

        return ResponseEntity.noContent().build();
    }
}
