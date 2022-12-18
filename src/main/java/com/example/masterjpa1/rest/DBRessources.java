package com.example.masterjpa1.rest;

import com.example.masterjpa1.services.JDBCPingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;

@Path("/database")
public class DBRessources {

    @Inject
    JDBCPingService pingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/ping")
    public String pingDB() throws SQLException {
        return pingService.ping();
    }
}
