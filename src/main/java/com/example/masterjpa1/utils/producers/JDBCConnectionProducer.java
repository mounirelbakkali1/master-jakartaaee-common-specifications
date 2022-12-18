package com.example.masterjpa1.utils.producers;

import com.example.masterjpa1.qualifiers.UserDataBase;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionProducer {
    @Inject
    Logger logger;

    @Produces @UserDataBase
    private Connection createConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/school","root","");
        logger.info("connection created ...");
        return connection;
    }

    private void closeConnection(@Disposes @UserDataBase Connection connection) throws SQLException {
        connection.close();
        logger.info("connection closed. :)");
    }
}
