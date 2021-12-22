package com.todos.utils.converters.deck;

import com.todos.domain.dtos.deck.CreateDeckDTO;
import com.todos.domain.dtos.deck.DeckDTO;
import com.todos.domain.models.Card;
import com.todos.domain.models.Deck;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeckConverter {

    DeckDTO toDTO(Deck deck);

    List<DeckDTO> toCollectionDTO(List<Deck> decks);

    Deck toCreateModel(CreateDeckDTO createDeckDTO);
}
