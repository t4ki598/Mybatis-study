package com.ldr.pojo;

/**
 * describe:
 *
 * @author xxx
 * @date 2020/02/04
 */


//实体类

//@Alias("hello")
public class User {
    private int id;
    private String name;
    //属性名和字段名不一致
    //数据库中password字段为pwd非属性名password
    private String password;

    public User() {
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
