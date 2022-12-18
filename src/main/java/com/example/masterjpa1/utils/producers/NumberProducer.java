package com.example.masterjpa1.utils.producers;
/*


    ✔
    PRODUCERS ARE USED TO MAKE THIRD-PARTY FRAMEWORKs (Log4j as example) AND APIs MANAGED BY CDI
    fact -> JAVA SE APIs (STRING,DATE...) for example are not packged with java ee archive instead
    they are packaged into rt.jar that doesnt containe beans discriptor so it couldn't be injected
    the solution is to use producers



*/

import com.example.masterjpa1.model.Student;
import com.example.masterjpa1.respositories.StudentRepository;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.POSTFIX;
import static com.example.masterjpa1.qualifiers.advance.NumberProducer.StringProcued.PREFIX;
import static java.nio.file.attribute.PosixFilePermission.OTHERS_READ;
import static java.nio.file.attribute.PosixFilePermission.OTHERS_WRITE;

public class NumberProducer {

    @Inject
    StudentRepository repository;

    @Produces @com.example.masterjpa1.qualifiers.advance.NumberProducer(stringProduced = POSTFIX)
    private String postPrifix = "@gmail-produced.com";
    @Produces
    private int random = Math.abs(new Random().nextInt());


    @Produces @com.example.masterjpa1.qualifiers.advance.NumberProducer(stringProduced = PREFIX)
    private String prefix = "produced-username";

    @Produces
    private Path createFile() throws IOException {
        List<Student> studentList = repository.getAll();
        Path newPath = Files.createFile(Paths.get("C:\\Users\\Youcode\\Documents\\masterjpa-log-history\\file_"+Math.abs(new Random().nextInt())+".txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(newPath.toString(),true));
        writer.append("------------------------------------------------------------------------------\n");
        writer.append(" id             name               age               email                   \n");
        studentList.stream()
                        .forEach(student -> {
                            try {
                                writer.append(student.toStringForList());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
        writer.append("------------------------------------------------------------------------------");
        writer.close();
        return  newPath;
    }
}
