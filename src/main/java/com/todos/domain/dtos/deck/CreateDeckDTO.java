package com.todos.domain.dtos.deck;

import com.todos.domain.dtos.card.CardDTO;
import com.todos.domain.models.Card;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDeckDTO {

    private String type;

    private List<CardDTO> cards = new ArrayList<>();

    private LocalDateTime createdAt;
}
