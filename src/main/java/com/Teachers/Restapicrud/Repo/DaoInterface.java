package com.Teachers.Restapicrud.Repo;

import com.Teachers.Restapicrud.Entity.Teachers;

import java.util.List;

public interface DaoInterface {

    List<Teachers> findTeachers();

    Teachers findTeacherById(int id);

    Teachers updateTeacher(Teachers teachers);

    void deleteTeacher(int id);
    Teachers addTeacher(Teachers teachers);
}
