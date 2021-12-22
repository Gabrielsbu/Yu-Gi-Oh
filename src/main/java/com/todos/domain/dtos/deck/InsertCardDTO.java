package com.todos.domain.dtos.deck;

import com.todos.domain.models.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsertCardDTO {

    private List<Card> cards = new ArrayList<>();
}
