package com.todos.domain.dtos.deck;

import com.todos.domain.dtos.card.CardDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeckDTO {

    private Long id;

    private String type;

    private List<CardDTO> cards = new ArrayList<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
