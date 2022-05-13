package com.example.weeklytest_1112.Controller;

import com.example.weeklytest_1112.Domain.Memo;
import com.example.weeklytest_1112.Dto.PostDto;
import com.example.weeklytest_1112.Repository.MemoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;

    @PostMapping("/memo")
    public String saveMemo(@RequestBody PostDto dto)  {
        memoRepository.save(new Memo(dto.getContents()));

        return "작성완료";
    }

    @GetMapping("/memo")
    public List<String> getMemo() {
        return memoRepository.findAll().stream()
                .map(m -> new String(m.getContents()))
                .collect(Collectors.toList());
    }
}