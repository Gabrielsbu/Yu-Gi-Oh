package com.todos.domain.dtos.person;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CreatePersonDTO {

    private String fullName;
    private String email;
    private String avatarUri;
    private String team;

    private LocalDateTime createdAt;
}
