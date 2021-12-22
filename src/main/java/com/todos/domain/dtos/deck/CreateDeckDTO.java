package com.todos.domain.dtos.deck;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDeckDTO {
    private String type;
}
