package com.ldr.dao;

import com.ldr.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    List<Teacher> getTeacher(@Param("tid") int id);
}
