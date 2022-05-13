package weeklytest_1119.Repository;

import weeklytest_1119.Domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}