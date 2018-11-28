package com.first.blog.domain;

/**
 * 用户实体类
 */

public class User {

    private Long id;//实体一个唯一标示
    private String name;
    private String email;
    public User(){  //无参构造函数
    }

    public User(Long id,String name,String email){  //有参构造函数
        this.id = id;
        this.name =  name;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
