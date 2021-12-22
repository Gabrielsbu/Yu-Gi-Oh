package com.todos.utils.converters.card;

import com.todos.domain.dtos.card.CardDTO;
import com.todos.domain.dtos.card.CreateCardDTO;
import com.todos.domain.models.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardConverter {

    CardDTO toDTO(Card card);

    Card toCreateModel(CreateCardDTO card);

    List<CardDTO> toCollectionDTO(List<Card> cards);
}
