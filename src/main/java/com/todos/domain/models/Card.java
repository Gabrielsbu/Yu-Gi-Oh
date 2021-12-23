package com.todos.domain.models;

import com.todos.domain.enums.CardType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "card")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder(setterPrefix = "set")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long stars;

    private String avatarUri;

    private Double price;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private CardType type;

    private Long atk;
    private Long def;

    @ManyToOne(fetch = FetchType.LAZY)
    private Deck deck;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
