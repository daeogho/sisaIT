package com.sisait.myapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="QNA_ENTITY")
@Data
@NoArgsConstructor //매개변수가 없는 생성자
@AllArgsConstructor //매개변수 전체가 있는 생성자
public class QnaEntity {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name="QNA_ID")
    private Integer id;

    @Column(nullable = false,length = 200)
    private String subject;

    @Column(nullable = false,columnDefinition = "LONGTEXT")
    private String content;

    @Column(columnDefinition = "int default 0")
    private Integer hit = 0; //기본값:0

    @UpdateTimestamp
    @Column(columnDefinition = "DATETIME default now()")
    private String writedate;
    //글쓴이

    //외래키 설정
    @ManyToOne// 1 : N @OneToMany N : 1
    @JoinColumn(name="JOINS_ID")
    private JoinsEntity joinsEntity; // joins_id,userid,userpwd,tel,username,email,writedate

}
