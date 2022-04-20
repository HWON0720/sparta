package spring_basic.spring_basic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring_basic.spring_basic.dto.Person;
import spring_basic.spring_basic.dto.PersonRequestDto;
import spring_basic.spring_basic.repository.PersonRepository;
import spring_basic.spring_basic.service.PersonService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    private final PersonService personService;

    @GetMapping("/person")
    public List<Person> getPerson() {return personRepository.findAll();}

    @PostMapping("/person")
    public Person createPerson(@RequestBody PersonRequestDto requestDto) {
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto) {
        return personService.update(id, requestDto);
    }

    @DeleteMapping("/person/{id}")
    public Long deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return id;
    }
}
