package com.todos.domain.dtos.card;

import com.todos.domain.enums.CardType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCardDTO {

    private Long id;
    private String name;
    private Long stars;
    private String avatarUri;
    private String description;
    private Double price;

    @Enumerated(EnumType.STRING)
    private CardType type;
    private Long atk;
    private Long def;

    private LocalDateTime updatedAt;

}
