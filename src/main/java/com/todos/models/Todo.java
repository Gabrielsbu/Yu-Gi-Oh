package com.todos.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Entity(name = "todos")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder(setterPrefix = "set")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Boolean done;

    @Min(value = 1)
    private Long numberDays;

    private LocalDateTime dateExpired;

    private Boolean expired;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
        this.dateExpired = LocalDateTime.now().plusDays(this.getNumberDays());
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
