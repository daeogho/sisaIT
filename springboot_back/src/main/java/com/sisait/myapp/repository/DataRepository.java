package com.sisait.myapp.repository;

import com.sisait.myapp.entity.DataEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataRepository  extends JpaRepository<DataEntity, Integer> {


    int countIdBy();

    int countIdBySubjectContaining(String searchWord);

    int countIdByContentContaining(String searchWord);

    int countIdByJoinsEntity_IdIn(List<Integer> integers);

    List<DataEntity> findAllByOrderByIdDesc(PageRequest of);

    List<DataEntity> findBySubjectContainingOrderByIdDesc(String searchWord, PageRequest of);

    List<DataEntity> findByContentContainingOrderByIdDesc(String searchWord, PageRequest of);

    List<DataEntity> findByJoinsEntity_IdInOrderByIdDesc(List<Integer> integers, PageRequest of);

    @Modifying
    @Transactional
    @Query("update DataEntity set hit= hit+1 where id=:id")
    void hitCount(int id);

    @Modifying
    @Transactional
    @Query("update DataEntity set subject=:subject, content=:content where id = :id")
    int dataUpdate(int id, String subject, String content);


}
