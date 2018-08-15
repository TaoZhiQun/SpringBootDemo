package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tao 用户增删改查接口，继承JPA或者CRUD均可，注意CRUD中的save既是保存又是更新(根据id更新)
 */

@Repository(value = "loginUserRepository")
public interface LoginUserRepository extends JpaRepository<User,Long> {
}
