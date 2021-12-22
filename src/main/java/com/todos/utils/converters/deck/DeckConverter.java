package com.todos.utils.converters.deck;

import com.todos.domain.dtos.deck.DeckDTO;
import com.todos.domain.models.Card;
import com.todos.domain.models.Deck;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeckConverter {

    DeckDTO toDTO(Deck deck);
}
