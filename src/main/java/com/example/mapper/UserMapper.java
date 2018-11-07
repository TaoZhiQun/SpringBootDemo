package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserMapper {
    /**
     * 返回全部用户
     * @return
     */
    List<User> findAllUser();


    int saveUser(User user);

    List<User> findByUserNames(@Param("request") User user);
}
