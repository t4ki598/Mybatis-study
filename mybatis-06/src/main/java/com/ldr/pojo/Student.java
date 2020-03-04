package com.ldr.pojo;

/**
 * 项目名称：mybatis2
 * 类 名 称：Student
 * 类 描 述：TODO
 * 创建时间：2020-03-03 15:48
 * 创 建 人：t4ki
 */
public class Student {
    private String name;
    private int id;
    private int tid;

    public Student() {
    }

    public Student(String name, int id, int tid) {
        this.name = name;
        this.id = id;
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", tid=" + tid +
                '}';
    }
}
