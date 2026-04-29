package com.sisait.myapp.repository;

import com.sisait.myapp.entity.FileEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {

    List<FileEntity> findByDataEntity_id(int id);

    List<FileEntity> findByIdIn(List<Integer> delFile);

    int deleteByIdIn(List<Integer> delFile);


}
