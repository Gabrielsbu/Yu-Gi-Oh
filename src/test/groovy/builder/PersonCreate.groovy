package builder

import com.todos.domain.dtos.person.CreatePersonDTO
import com.todos.domain.dtos.person.UpdatePersonDTO
import com.todos.domain.models.Deck
import com.todos.domain.models.Person

import java.time.LocalDateTime

class PersonCreate {

    static  buildCreatePersonDto(props = null) {
        applyProperties(props, new CreatePersonDTO(
                fullName: "Gabriel Maia",
                email: "gabrielmaiasbu@gmail.com",
                avatarUri: null,
                team: "blue",
                createdAt: LocalDateTime.now(),
        ))
    }

    static  buildUpdatePersonDto(props = null) {
        applyProperties(props, new UpdatePersonDTO(
                id: 1L,
                fullName: "Gabriel Ramos",
                email: "gabrielmaiasbu@gmail.com",
                avatarUri: null,
                team: "red",
                money: 100D,
                updatedAt: LocalDateTime.now(),
        ))
    }

    static <T> T applyProperties(props, T object) {
        if(props) {
            props.each { k, v -> object[k] = v }
        }
        object
    }
}
