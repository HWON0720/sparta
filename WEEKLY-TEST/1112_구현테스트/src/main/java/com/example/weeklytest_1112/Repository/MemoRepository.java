package com.example.weeklytest_1112.Repository;

import com.example.weeklytest_1112.Domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}