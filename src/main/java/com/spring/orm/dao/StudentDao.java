package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student) {
        int r = (Integer) this.hibernateTemplate.save(student);
        return r;
    }

    public Student getStudent(int studentId) {
        // when to use get() and when to use load to fetch data
        /*
         * get(): Performs an immediate database hit to retrieve the entity. If the
         * entity is found in the session cache, it returns the cached object.
         * Otherwise, it executes a SELECT query to fetch the data from the database.
         * load(): Returns a proxy object (a "fake" instance) without immediately
         * hitting the database. The actual database query to load the entity's data is
         * only executed when a non-identifier property of the proxy object is accessed
         * (lazy loading). This can improve performance by deferring database calls
         * until the data is truly needed.
         */
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
    }

    public List<Student> getAllStudents() {
        List<Student> students = this.hibernateTemplate.loadAll(Student.class);
        return students;
    }

    @Transactional
    public void deleteStudent(int studentId) {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(student);
    }

    @Transactional
    public void updateStudent(Student student) {
        this.hibernateTemplate.update(student);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

}
