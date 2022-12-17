package com.example.masterjpa1.rest;


import com.example.masterjpa1.qualifiers.EmailGenerator;
import com.example.masterjpa1.qualifiers.HotmailGenerator;
import com.example.masterjpa1.utils.Generator;
import com.example.masterjpa1.utils.TextUtil;
import com.example.masterjpa1.model.Teacher;
import com.example.masterjpa1.respositories.StudentRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static com.example.masterjpa1.qualifiers.advance.Generator.GeneratorType.EMAIL;

@Path("/teachers")
public class TeacherRessource {

    @Inject
    @com.example.masterjpa1.qualifiers.advance.Generator(generatorType = EMAIL)
    private Generator generator;

    @Inject
    private StudentRepository repository;

    @Inject
    private TextUtil textUtil;



    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTechers(){
        List<Teacher> teacherList =repository.getTeachers();
        if (teacherList.size()==0){
            return Response.noContent().build();
        }else{
            return Response.ok(teacherList).build();
        }
    }


    @GET
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveTeacher(){
        var teacher = new Teacher();
        teacher.setName(textUtil.sanitize(generator.generateString()));
        repository.saveTeacher(teacher);
        return Response.ok(teacher).build();
    }
}
