package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

/**
 * @author Tao 用户增删改查接口，继承JPA或者CRUD均可，注意CRUD中的save既是保存又是更新(根据id更新)
 */

@Repository(value = "loginUserRepository")
public interface LoginUserRepository extends JpaRepository<User,Long> {

    User findById(Long id);

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "select u from User u where u.userName = :userName and u.userIp = :userIp  ")
    User findByUserNameAndUserIp(@Param("userName") String userName, @Param("userIp")String userIp);

}
