package com.sisait.myapp.repository;

import com.sisait.myapp.entity.JoinsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//쿼리문을 수행하는 메소드는 jpa프레임워크에 구현되어 있으며
// 해당메소드를 구현하기 위해서는 repository클래스에 JpaRepostory클래스를 상속받는다.
public interface JoinsRepository extends JpaRepository<JoinsEntity, Integer> {
    // select userid, username from joins_entity where userid=? anduserpwd=?
    // findByUseridAndUserpwd(userid, userpwd)
    public JoinsEntity findByUseridAndUserpwd(String userid, String userpwd);
    //회원1명선택하는 메소드
    //select*from joins_entity where userid=?
    public JoinsEntity findByUserid(String userid);

    List<JoinsEntity> findByUsername(String username);
}
