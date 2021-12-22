package com.todos.domain.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "person")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder(setterPrefix = "set")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    private String avatarUri;

    private String team;

    @OneToOne
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
