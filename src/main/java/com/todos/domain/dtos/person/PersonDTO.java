package com.todos.domain.dtos.person;

import com.todos.domain.dtos.deck.DeckDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class PersonDTO {

    private Long id;

    private String fullName;
    private String email;
    private String avatarUri;
    private String team;
    private Double money;

    private DeckDTO deck;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
