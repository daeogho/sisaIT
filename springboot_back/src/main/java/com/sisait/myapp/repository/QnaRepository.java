package com.sisait.myapp.repository;

import com.sisait.myapp.entity.BbsEntity;
import com.sisait.myapp.entity.QnaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QnaRepository extends JpaRepository<QnaEntity, Integer> {
    // 검색어 없을때 레코드 수
    int countIdBy();
    // 검색어가 subject일때 레코드 수 구하기
    int countIdBySubjectContaining(String searchWord);
    // 검색어가 content일때 레코드 수 구하기
    int countIdByContentContaining(String searchWord);
    // 검색어가 joins_id일때 레코드 수 구하기
    int countIdByJoinsEntity_IdIn(List<Integer> integers);

    List<QnaEntity> findAllByOrderByIdDesc();

    List<QnaEntity> findAllByOrderByIdDesc(PageRequest of);
    // 제목 검색 해당 레코드 선택
    List<QnaEntity> findBySubjectContainingOrderByIdDesc(String searchWord, PageRequest of);
    // 글내용 검색 해당 레코드 선택
    List<QnaEntity> findByContentContainingOrderByIdDesc(String searchWord, PageRequest of);
    // 작성자 검색 해당 레코드 선택
    List<QnaEntity> findByJoinsEntity_IdInOrderByIdDesc(List<Integer> integers, PageRequest pageRequest);

    // Entity의 필드명으로 표기
    @Modifying
    @Transactional
    @Query("update QnaEntity set hit=hit+1 where id=:id")
    int qnaHitCount(@Param("id") Integer id);

    // 삭제
    @Modifying
    @Transactional
    @Query("delete from QnaEntity where id=:id ")
    int qnaDelete(@Param("id") Integer id);

}
