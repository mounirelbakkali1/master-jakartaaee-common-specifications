package com.example.masterjpa1.respositories;


import com.example.masterjpa1.model.Student;
import com.example.masterjpa1.model.Teacher;
import com.sun.istack.NotNull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Min;

import java.util.List;

//@ApplicationScoped
@Transactional(Transactional.TxType.SUPPORTS)
public class StudentRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolPUnit");
    EntityManager em = emf.createEntityManager();


    public Student getStudentById(@NotNull @Min(1) Long id){
        return em.find(Student.class,id);
    }
    public Long getStudentsCount(){
            return (Long) em.createQuery("select count(s) from Student s").getSingleResult();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Student saveStudent(@NotNull Student student){
        em.persist(student);
        return student;
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public Teacher saveTeacher(@NotNull Teacher teacher){
        em.persist(teacher);
        return teacher;
    }
    public List<Teacher> getTeachers(){
        return em.createQuery("select t from Teacher t order by t.id").getResultList();
    }


    public List<Student> getAll(){
        return em.createQuery("select s from Student s order by s.id").getResultList();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteStudent(@NotNull @Min(1) Long id){
        em.remove(em.getReference(Student.class,id));
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteAllStudent(){
        em.createQuery("DELETE  FROM Student s WHERE 1=1 ").executeUpdate();
    }


    @Transactional(Transactional.TxType.REQUIRED)
    public void UpdateUserName(Long id , String name){
        em.createQuery("update Student as s  SET s.name='"+name+"' WHERE s.id="+id).executeUpdate();
    }

}
