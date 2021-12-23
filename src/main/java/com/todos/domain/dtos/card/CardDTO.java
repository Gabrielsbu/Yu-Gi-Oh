package com.todos.domain.dtos.card;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDTO {

    private Long id;

    private String name;
    private Long stars;
    private String avatarUri;
    private String description;
    private String type;
    private Double price;

    private Long atk;
    private Long def;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
