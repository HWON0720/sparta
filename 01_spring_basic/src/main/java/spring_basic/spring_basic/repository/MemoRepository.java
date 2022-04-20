package spring_basic.spring_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_basic.spring_basic.dto.Memo;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
