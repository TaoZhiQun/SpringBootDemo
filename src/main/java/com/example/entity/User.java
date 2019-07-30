package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 用户实体
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_ip")
    private String userIp;

    public User(){}

    public User(String userName, String userIp) {
        this.userName = userName;
        this.userIp = userIp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
