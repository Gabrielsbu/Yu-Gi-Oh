import builder.PersonCreate
import com.todos.domain.models.Deck
import com.todos.domain.models.Person
import com.todos.exceptions.GlobalException
import com.todos.repositories.DeckRepository
import com.todos.repositories.PersonRepository
import com.todos.services.impl.CardServiceImpl
import com.todos.services.impl.PersonServiceImpl
import com.todos.utils.converters.person.PersonConverterImpl
import spock.lang.Specification

import java.time.LocalDateTime

class FirstSpecification extends Specification {

    def personRepository = Mock(PersonRepository)
    def personConverter = new PersonConverterImpl()
    def deckRepository = Mock(DeckRepository)
    def cardService = Mock(CardServiceImpl)

    def personService = new PersonServiceImpl(personRepository, personConverter, deckRepository, cardService)

    def "find all persons" () {
        given:
        def people = [new Person()]
        personRepository.findAll() >> people

        when:
        def result = personService.findAll()

        then:
        result[0] == personConverter.toCollectionDTO(people)[0]
    }

    def "findById: deve retornar a pessoa convertida para personDTO" () {

        given: "Configurar pessoa"
        def id = 1L
        def deck = new Deck()
        def person = new Person(id, "Gabriel Maia", "gabrielmaiasbu@gmail.com", null, "red", 10000D, deck, LocalDateTime.now(), null)
        def personConverted = personConverter.toDTO(person)

        and: "Mockar o retorno do personRepository"
        1*personRepository.findById(id) >> Optional.of(person)

        when:
        def result = personService.findById(id)

        then:
        personConverted.id == result.id
        personConverted.fullName == "Gabriel Maia"
        personConverted == result
    }

    def "findById: deve retornar GlobalException caso o personagem não seja encontrado " () {

        given: "mockagem do repositorio"
        personRepository.findById(_) >> Optional.empty()

        when:
        personService.findById(2L)

        then:
        def exception = thrown GlobalException
        exception.message == "Personagem não encontrado"

    }

    def "create: deve retornar um usuário criado convertido para PersonDTO" (){

        given:
        def createPersonDTO = PersonCreate.buildCreatePersonDto()
        def personConverted = personConverter.toCreateModel(createPersonDTO)

        def personDto = personConverter.toDTO(personConverted)

        1*personRepository.save(_) >> personConverted

        when:
        def result = personService.create(createPersonDTO)

        then:
        result == personDto
    }

    def "update: deve retornar um personagem atualizado convertido para PersonDTO" () {
        given:
        when:
        then:

    }
}