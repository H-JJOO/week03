package com.sparta.week03.controller;

import com.sparta.week03.domain.Memo;
import com.sparta.week03.domain.MemoRepository;
import com.sparta.week03.domain.MemoRequestDto;
import com.sparta.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor//Spring 이 생성자 만들어줌
@RestController//Spring 이 생성자 만들어줌
public class MemoController {
    private final MemoRepository memoRepository;//생성,조회,삭제 위해서
    private final MemoService memoService;//업데이트를 위해서

    //생성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {//@RequestBody : 요청할때 body 내용을 넣어줘
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    //조회
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();//생성일자 내림차순(최신~)
    }

    //수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        memoService.update(id, requestDto);
        return id;
    }

    //삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {//주소에있는것을 변수로 받기위해서 @PathVariable
        memoRepository.deleteById(id);
        return id;
    }




}



