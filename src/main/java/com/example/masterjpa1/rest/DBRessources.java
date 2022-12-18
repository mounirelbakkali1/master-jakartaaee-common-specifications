package com.example.masterjpa1.rest;

import com.example.masterjpa1.qualifiers.Price;
import com.example.masterjpa1.services.JDBCPingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.sql.SQLException;

import static com.example.masterjpa1.qualifiers.Price.currency.DH;
import static com.example.masterjpa1.qualifiers.Price.currency.EU;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/database")
public class DBRessources {

    @Inject
    JDBCPingService pingService;

    @Inject @Price(currency = EU) Float priceINEU;

    @GET
    @Produces(TEXT_PLAIN)
    @Path("/ping")
    public String pingDB() throws SQLException {
        return pingService.ping();
    }

    @GET
    @Produces(TEXT_PLAIN)
    @Path("/dh")
    public String getPriceInDH(){
        return "price 1 DH in EU  = "+priceINEU +"     (using @alternative)";
    }
}
