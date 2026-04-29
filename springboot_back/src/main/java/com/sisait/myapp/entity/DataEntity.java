package com.sisait.myapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="DATA_ENTITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"fileList", "joinsEntity"})  // 🔥 순환 참조 방지 핵심
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DATA_ID")
    private int id;

    @Column(nullable = false,length = 200)
    private String subject;

    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content;

    @Column(columnDefinition = "int default 0")
    private Integer hit = 0;

    @CreationTimestamp // 처음에 한번 생성
    //@UpdateTimestamp // 글이 수정될 때 마다 그날의 글자가 수정된다.
    @Column(columnDefinition = "DATETIME default now()")
    private String writedate;

    // 글쓴이
    @ManyToOne
    @JoinColumn(name="JOINS_ID") // JoinsEntity의 아이디와 조인
    private JoinsEntity joinsEntity;

    @OneToMany(
        mappedBy="dataEntity",
        cascade=CascadeType.ALL,
        orphanRemoval=true // 부모와의 관계가 끊어진 자식 엔티티를 자동으로 DB에서 삭제한다.
    )

    @JsonManagedReference
    private List<FileEntity> fileList = new ArrayList<>();

    //첨부파일
    @Transient // db에 필드를 생성하지 않는다.
    List<MultipartFile> files;

    //삭제 파일
    @Transient
    List<Integer> delFile;
}
