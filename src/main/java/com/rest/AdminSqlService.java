/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.model.Admin;
import com.model.Admins;
import com.model.dao.SqlDBConnector;
import com.model.dao.AdminSqlDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;


@Path("adminsapi")
public class AdminSqlService {

    @GET
    @Path("admins") //http://localhost:8080/group1/rest/adminsapi/admins
    @Produces(MediaType.APPLICATION_XML)
    public Admins getAdmins() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        AdminSqlDAO adminSqlDAO = new AdminSqlDAO(new SqlDBConnector().connection());
        Admins admins = new Admins();
        admins.addAll(adminSqlDAO.getAdmins());
        return admins;
    }

    @GET
    @Path("admins/ID/{ID}") //http://localhost:8080/group1/rest/adminsapi/admins/ID/10
    @Produces(MediaType.APPLICATION_XML)
    public Admins getAdmin(@PathParam("ID") int ID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        AdminSqlDAO adminSqlDAO = new AdminSqlDAO(new SqlDBConnector().connection());
        Admin admin = adminSqlDAO.getAdmin(ID);
        Admins admins = new Admins();
        admins.add(admin);
        return admins;
    }

//      // Add new admin
    @GET
    @Path("addadmin") //http://localhost:8080/group1/rest/adminsapi/addadmin
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addAdmin() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        AdminSqlDAO adminSqlDAO = new AdminSqlDAO(new SqlDBConnector().connection());
        adminSqlDAO.create("Hello Hello", "hello.hello@store.com", "Hellothere123", "2000-10-10", "0423142567", "40 Queens st, Sydney NSW 2222");
        Admin admin = adminSqlDAO.getAdmin("admin");
        Admins admins = new Admins();
        admins.add(admin);
        
        return Response.status(200).entity(admin).build();
    }

 
    @GET
    @Path("addadmin/{adminEmail}") //http://localhost:8080/group1/rest/adminsapi/addadmin/matt.smith@store.com
    @Produces(MediaType.APPLICATION_XML)
    public Admins addadmin(@PathParam("adminEmail") String adminEmail) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        AdminSqlDAO adminSqlDAO = new AdminSqlDAO(new SqlDBConnector().connection());
        
        
        Admin admin = adminSqlDAO.getAdmin(adminEmail);
        if(admin == null){
            adminSqlDAO.create(adminEmail);
        }
        admin = adminSqlDAO.getAdmin(adminEmail);
        Admins admins = new Admins();
        admins.add(admin);
        return admins;
    }
}
