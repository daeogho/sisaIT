package com.sisait.myapp.controller;


import com.sisait.myapp.entity.PagingVO;
import com.sisait.myapp.entity.QnaEntity;
import com.sisait.myapp.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnaController {
    private final QnaService qnaService; // @RequiredArgsConstructor 어노테이션이 생성자를 만들어 객체 생성한다.

    // 뉴스등록
    @PostMapping("/qnaWrite")
    public QnaEntity qnaWrite(@RequestBody QnaEntity qnaEntity){
        qnaEntity.setHit(0);

        return qnaService.qnaInsertOrUpdate(qnaEntity);
    }
    // 뉴스목록 : 총 레코드수, 총페이지 수, 현재페이지
    @GetMapping("/qnaList")                                        //sort :정렬할 필드, direction :asc,desc
    public Map<String, Object> qnaList(PagingVO pVO, @PageableDefault(sort="id",direction= Sort.Direction.DESC) Pageable pageable){
        // 해당페이지 레코드 선택하는 법
        // 컨트롤러의 매개변수에 @PageableDefault어노테이션을 기술한다.

        // 총 레코드 수 구하기
        pVO.setTotalRecord(qnaService.qnaTotalRecord(pVO));

        System.out.println("페이지,검색정보=>"+pVO.toString());

        // React에게 보낼 객체
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pages",pVO);
        // 레코드 선택 : 페이지와 검색어가 없을때
        //  List<BbsEntity> list = bbsService.bbsList(pVO);
        // 레코드 선택 : 페이지와 검색어가 있을때
        List<QnaEntity> list = qnaService.qnaList(pVO);

        System.out.println("선택된 레코드 수 : "+list.size());
        map.put("qnaList",list);

        return map;
    }
    // 글내용보기, 글수정하기폼 : 레코드 선택
    @GetMapping("/qnaDetail/{id}")
    public QnaEntity qnaDetail(@PathVariable("id") Integer id){
        //조회수 증가
        qnaService.qnaHitCount(id);
        // 글 선택
        Optional<QnaEntity> entity = qnaService.qnaSelect(id);

        return entity.get();
    }
    // 글 수정
    @PostMapping("/qnaEditOk")
    public QnaEntity qnaEntityOk(@RequestBody QnaEntity qnaEntity){ //글번호, 제목, 글내용

        //글쓴이, 조회수, 등록일이 없다.
        QnaEntity dbEntity = qnaService.qnaSelect(qnaEntity.getId()).get(); // 글번호,제목,글내용,글쓴이,조회수,등록일

        // 제목과 글 내용을 수정한 내용으로 변경
        dbEntity.setSubject(qnaEntity.getSubject());
        dbEntity.setContent(qnaEntity.getContent());

        return qnaService.qnaInsertOrUpdate(dbEntity);
    }
    // 글 삭제
    @DeleteMapping("/qnaDelete/{id}")
    public int qnaDelete(@PathVariable("id") Integer id){
        return qnaService.qnaDelete(id);
    }
}
