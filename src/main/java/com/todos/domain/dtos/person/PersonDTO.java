package com.todos.domain.dtos.person;

import com.todos.domain.dtos.deck.DeckDTO;
import com.todos.domain.models.Deck;
import lombok.*;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO {

    private Long id;

    private String fullName;
    private String email;
    private String avatarUri;
    private String team;

    private DeckDTO deck;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
