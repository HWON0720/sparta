package spring_basic.spring_basic.Controller;

import spring_basic.spring_basic.Domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("김스파르타");
        person.setSex("女");
        person.setAge(20);

        return person;
    }
}
