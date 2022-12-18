package com.example.masterjpa1.services;

import com.example.masterjpa1.qualifiers.UserDataBase;
import jakarta.inject.Inject;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPingService {

    @Inject
    Logger logger;

    private static int index=1;
    @Inject @UserDataBase
    Connection connection;
     public String ping() throws SQLException {
         ResultSet set = connection.createStatement().executeQuery("SELECT name from students where id="+index);
         String name = null;
         if(set.next()){
             name="Successfuly Ping database and retreive the next result :"+set.getString(1);
             logger.info("Ping..");
             index++;
         }
         return name;
     }
}
