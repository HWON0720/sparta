package spring_basic.spring_basic.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import spring_basic.spring_basic.dto.Memo;
import spring_basic.spring_basic.dto.MemoRequestDto;
import spring_basic.spring_basic.repository.MemoRepository;

@RequiredArgsConstructor // final로 생성된 멤버변수를 포함한 생성자 생성
@Service
public class MemoService {

    private final MemoRepository memoRepository; // final 선언은 반드시 필요한 멤버가 있을 때 用

    @Transactional  // db에 반영하라는 의미입니다.
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}
