package com.example.masterjpa1.rest;

import com.example.masterjpa1.services.StudentService;
import com.example.masterjpa1.utils.EmailGenerator;
import com.example.masterjpa1.utils.Generator;
import com.example.masterjpa1.utils.TextUtil;
import com.example.masterjpa1.model.Student;
import com.example.masterjpa1.respositories.StudentRepository;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.ws.rs.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/students")
public class StudentResource {



   @Inject
   StudentService service;


    @GET
    @Path("/count")
    public Response getStudentsCount(){
        Response response = ClientBuilder.newClient()
                .target("http://localhost:16161/MasterJPA1-1.0-SNAPSHOT/api/students/1")
                .request(APPLICATION_JSON)
                .get();
        System.err.println(response.getEntity());
        var count = service.countAll();
        if (count==0) return Response.noContent().build();
        else return Response.ok(count,"text/plain").build();
    }


    @POST
    @Path("/save")
    @Consumes(APPLICATION_JSON)
    public Response createBook (Student student, @Context UriInfo uriInfo) {
        student=service.save(student);
        URI createdURI = uriInfo.getBaseUriBuilder().path(student.getId().toString()).build();
        return Response.created(createdURI).build();
    }

    @GET
    @Path("/save-test")
    @Produces(APPLICATION_JSON)
    public Student saveInvalidStudentRecordTest(){
        return service.save(new Student());
    }



    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Student getStudentById(@PathParam("id") Long id){
        return service.findById(id);
    }
    @GET
    @Path("/all")
    @Produces(APPLICATION_JSON)
    public Response getAllStudents(){
        return Response.ok(service.findAll()).build();
    }


    @DELETE
    @Path("/delete/{id}")
    public Response deleteStudent(@PathParam("id") Long id){
        service.delete(id);
        return Response.ok("Student with id="+id+" is deleted successfuly", "text/plain").build();
    }

    @DELETE
    @Path("/delete-all")
    public Response deleteAllStudent(){
        service.deleteAll();
        return Response.ok("all students deleted successfully :) ","text/plain").build();
    }


    @GET
    @Path("context")
    public String thisMethodeHelpsMeUnderstantContextAndURIInfo(@Context UriInfo uriInfo){
        return "absolute path : "+uriInfo.getAbsolutePath()+"     getBaseUriBuilder.path(1) ->"+uriInfo.getBaseUriBuilder().path("1");
    }
    @GET
    @Path("/update/{id}/{name}")
    public String updateUsername(@PathParam("id") Long id , @PathParam("name") String name){
        service.updateUserName(id,name);
        return "updated";
    }

}