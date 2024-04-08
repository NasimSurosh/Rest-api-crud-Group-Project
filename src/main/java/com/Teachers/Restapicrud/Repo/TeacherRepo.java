package com.Teachers.Restapicrud.Repo;

import com.Teachers.Restapicrud.Entity.Teachers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherRepo implements DaoInterface{

    private EntityManager em;
    @Autowired
    public TeacherRepo(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Teachers> findTeachers() {
        TypedQuery query = em.createQuery("FROM Teachers ", Teachers.class);
        List<Teachers> list = query.getResultList();
        return list;
    }

    @Override
    public Teachers findTeacherById(int id) {
        Teachers teacher = em.find(Teachers.class, id);
        return teacher;
    }

    @Override
    public Teachers updateTeacher(Teachers teachers) {
        Teachers teachers1 = em.merge(teachers);
        return null;
    }

    @Override
    public void deleteTeacher(int id) {
        Teachers teacher = em.find(Teachers.class, id);
        em.remove(teacher);


    }

    @Override
    public Teachers addTeacher(Teachers teachers) {
        Teachers teachers1 = em.merge(teachers);
        return teachers1;
    }
}
