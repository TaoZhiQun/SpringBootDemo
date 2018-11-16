package com.example.service;

import com.example.entity.User;

/**
 * @author Tao
 */

public interface RedisToMySqlService {
    void readAndWriteDB(User user);

    void lockTableTest();
}
