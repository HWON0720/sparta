package spring_basic.spring_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_basic.spring_basic.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
