/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.model.dao.SqlDBConnector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

/**
 *
 * @author 236369
 */
@Path("sqlapi")
public class OrderSqlService {
    
//    @GET
//    @Path("users") //http://localhost:8080/demo/rest/sqlapi/users
//    @Produces(MediaType.APPLICATION_XML)
//    public Order getOrders() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
//        UserSqlDAO userSqlDAO = new UserSqlDAO(new SqlDBConnector().connection());
//        Users users = new Users();
//        users.addAll(userSqlDAO.getUsers());
//        return users;
//    }
}
