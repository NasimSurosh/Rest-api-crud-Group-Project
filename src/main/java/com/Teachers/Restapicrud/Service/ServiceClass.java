package com.Teachers.Restapicrud.Service;

import com.Teachers.Restapicrud.Entity.Teachers;
import com.Teachers.Restapicrud.Repo.DaoInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceClass implements ServiceInterface{

    private DaoInterface daoInterface;

    @Autowired
    public ServiceClass(DaoInterface dao) {
        this.daoInterface = dao;
    }
    @Override
    public List<Teachers> findTeachers() {
        return daoInterface.findTeachers();
    }

    @Override
    public Teachers findTeacherById(int id) {
        return daoInterface.findTeacherById(id);
    }

    @Transactional
    @Override
    public Teachers updateTeacher(Teachers teachers) {
        return daoInterface.updateTeacher(teachers);
    }

    @Transactional
    @Override
    public void deleteTeacher(int id) {
    daoInterface.deleteTeacher(id);
    }

    @Transactional
    @Override
    public Teachers addTeacher(Teachers teachers) {
        return daoInterface.addTeacher(teachers);
    }
}
