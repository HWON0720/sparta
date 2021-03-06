package spring_basic.spring_basic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring_basic.spring_basic.dto.Person;
import spring_basic.spring_basic.dto.PersonRequestDto;
import spring_basic.spring_basic.repository.PersonRepository;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto) {
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        person1.update(requestDto);
        return person1.getId();
    }
}
