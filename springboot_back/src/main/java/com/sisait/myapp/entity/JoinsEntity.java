package com.sisait.myapp.entity;
// Entity는 서버가 실행되면 데이터베이스에 테이블이 자동생성된다.
// DTO, VO의 역할도 한다
// 클래스명이 테이블명으로 생성된다.

/*
@Entity
데이터베이스에 연결된 객체
Entity 이노테이션을 표기하여야 쿼리문을 작성하여 사용할 수 있다.

@Data
Getter, Setter, ToString, Equals를 생성해준다.

@NoArgsConstructor
@AllArgsConstructor
생성자 메소드 : public
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

/*
@Table
    테이블명을 지정하는 이노테이션이다. 생략가능하다.
@Id
    Primary key 제약조건을 설정한다. 생략시 에러 발생한다.
 @GeneratedValue
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="JOINS_ENTITY") // 테이블명을 지정:생략해도 됨
public class JoinsEntity { //클래스명이 테이블명으로 생성된다.
    // Entity로 테이블을 생성할 때는 반드시 @id가 있어야 한다.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="JOINS_ID", nullable=false)
    private Integer id; //number

    @Column(name="USERID", nullable=false, length=20, unique=true)
    private String userid;
    @Column(nullable=false, length=20)
    private String userpwd;
    @Column(nullable=false, length=20)
    private String username;
    @Column(nullable=false, columnDefinition = "varchar(15) default '010-0000-0000'")
    private String tel;
    @Column(nullable=false, length=45)
    private String email;

    @UpdateTimestamp
    @Column(columnDefinition = "DATETIME default now()")
    private String writedate;
}
