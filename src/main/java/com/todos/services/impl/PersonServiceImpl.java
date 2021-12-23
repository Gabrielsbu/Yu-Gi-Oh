package com.todos.services.impl;

import com.todos.domain.dtos.person.CreatePersonDTO;
import com.todos.domain.dtos.person.PersonDTO;
import com.todos.domain.dtos.person.UpdatePersonDTO;
import com.todos.domain.models.Card;
import com.todos.domain.models.Deck;
import com.todos.domain.models.Person;
import com.todos.exceptions.GlobalException;
import com.todos.repositories.DeckRepository;
import com.todos.repositories.PersonRepository;
import com.todos.services.CardService;
import com.todos.services.DeckService;
import com.todos.services.PersonService;
import com.todos.utils.converters.person.PersonConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;
    private final DeckRepository deckRepository;
    private final CardService cardService;
    private final DeckService deckService;

    private Person byId(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new GlobalException("Personagem não encontrado", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<PersonDTO> findAll() {
        return personConverter.toCollectionDTO(personRepository.findAll());
    }

    @Override
    public PersonDTO findById(Long id) {
        return personConverter.toDTO(personRepository.findById(id).orElseThrow(() -> new GlobalException("Personagem não encontrado", HttpStatus.NOT_FOUND)));
    }

    @Override
    public PersonDTO create(CreatePersonDTO person) {
        Person personToBeCreated = personConverter.toCreateModel(person);
        personToBeCreated.setMoney(10000D);
        return personConverter.toDTO(personRepository.save(personToBeCreated));
    }

    @Override
    public PersonDTO update(Long id, UpdatePersonDTO person) {
        Person personExistent = personRepository.getById(id);
        personExistent.setFullName(person.getFullName());
        personExistent.setEmail(person.getEmail());
        personExistent.setAvatarUri(person.getAvatarUri());
        personExistent.setTeam(person.getTeam());

        return personConverter.toDTO(personRepository.save(personExistent));
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        Person personExistent = byId(id);

        personRepository.deleteById(personExistent.getId());
        return ResponseEntity.noContent().build();
    }

    @Override
    public PersonDTO buyDeck(Long id, Long deckId) {
        Person person = byId(id);

        if(person.getDeck() != null) {
            throw new GlobalException("Venda seu atual deck ou troque-o para prosseguir com esta ação", HttpStatus.BAD_REQUEST);
        }
        Deck deck = deckRepository.findById(deckId).orElseThrow(
                () -> new GlobalException("Deck não encontrado", HttpStatus.NOT_FOUND));

        double difference = person.getMoney() - deck.getPrice();
        if(difference < 0) {
            throw new GlobalException("Você não tem dinheiro o suficiente", HttpStatus.BAD_REQUEST);
        }

        person.setDeck(deck);
        person.setMoney(difference);

        deck.setBoss(person.getFullName());
        deckRepository.save(deck);
        return personConverter.toDTO(personRepository.save(person));
    }

    @Override
    public PersonDTO buyCard(Long id, Long cardId) {
        Person person = byId(id);

        Card card = cardService.byId(cardId);

        double difference = person.getMoney() - card.getPrice();

        if(difference < 0) {
            throw new GlobalException("Saldo insuficiente", HttpStatus.BAD_REQUEST);
        }

        if(person.getDeck().getCards().contains(card)){
            throw new GlobalException("Você já possui esta carta", HttpStatus.BAD_REQUEST);
        }

        card.setDeck(person.getDeck());
        person.getDeck().setPrice(person.getDeck().getPrice() + card.getPrice());
        person.setMoney(difference);
        cardService.createSimpleCard(card);

        return personConverter.toDTO(personRepository.save(person));
    }

    @Override
    public PersonDTO sellCard(Long id, Long cardId) {
        Person person = byId(id);

        Card card = cardService.byId(cardId);

        if(!person.getDeck().getCards().contains(card)){
            throw new GlobalException("Você não pode vender uma carta que não possui", HttpStatus.BAD_REQUEST);
        }

        card.setDeck(null);
        cardService.createSimpleCard(card);

        person.getDeck().setPrice(person.getDeck().getPrice() - card.getPrice());
        person.setMoney(person.getMoney() + card.getPrice());
        return personConverter.toDTO(personRepository.save(person));
    }
}
