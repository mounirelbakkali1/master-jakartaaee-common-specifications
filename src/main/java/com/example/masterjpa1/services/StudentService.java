package com.example.masterjpa1.services;

import com.example.masterjpa1.model.Student;
import com.example.masterjpa1.qualifiers.EmailGenerator;
import com.example.masterjpa1.qualifiers.HotmailGenerator;
import com.example.masterjpa1.qualifiers.advance.Auditable;
import com.example.masterjpa1.qualifiers.advance.Loggeble;
import com.example.masterjpa1.respositories.StudentRepository;
import com.example.masterjpa1.utils.Generator;
import com.example.masterjpa1.utils.TextUtil;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Random;

import static com.example.masterjpa1.qualifiers.advance.Generator.GeneratorType.HOTMAIL;

@Loggeble
public class StudentService implements Service<Student> {

    @Inject @com.example.masterjpa1.qualifiers.advance.Generator(generatorType = HOTMAIL)
    private Generator generator;

    @Inject
    private StudentRepository repository;

    @Inject
    private TextUtil textUtil;


    /*
    constructor injection : that uses IOC  pattern
    🔐 not flexible  solution is using CDI injection

    public StudentService(Generator generator) {
        this.generator = generator;
    }
    */
    public StudentService() {
    }

    @Override
    public Long countAll() {
        return repository.getStudentsCount();
    }

    @Override
    public Student findById(Long id) {
        return repository.getStudentById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.getAll();
    }

    @Override
    @Loggeble
    @Auditable
    public Student save(Student student) {
        student.setAge(Math.abs(new Random().nextInt(29-18+1)+18));
        student.setEmail(generator.generateString());
        student.setName(textUtil.sanitize("Mounir     El bakkali"));
        return repository.saveStudent(student);
    }

    @Override
    public Student update(Student student) {
        return null;
    }

    @Loggeble(debug = true)
    @Override
    public void delete(Long id) {
        repository.deleteStudent(id);
    }

    public void updateUserName(Long id , String name){
        repository.UpdateUserName(id,name);
    }

    public void deleteAll(){
        repository.deleteAllStudent();
    }
}
