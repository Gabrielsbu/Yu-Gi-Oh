package com.todos.domain.dtos.card;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateCardDTO {

    private String name;
    private Long stars;
    private String avatarUri;
    private String description;
    private String type;
    private Long atk;
    private Long def;
    private Double price;

    private LocalDateTime createdAt;
}
