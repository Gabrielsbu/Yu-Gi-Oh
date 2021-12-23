package com.todos.domain.dtos.deck;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDeckDTO {

    private Long id;

    private String type;

    private Double price;

    private LocalDateTime updatedAt;
}
