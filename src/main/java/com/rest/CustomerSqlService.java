/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.model.Admin;
import com.model.Customer;
import com.model.Customers;
import com.model.dao.SqlDBConnector;
import com.model.dao.CustomerSqlDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;


@Path("customersapi")
public class CustomerSqlService {

    @GET
    @Path("customers") //http://localhost:8080/group1/rest/customersapi/customers
    @Produces(MediaType.APPLICATION_XML)
    public Customers getCustomers() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());
        Customers customers = new Customers();
        customers.addAll(customerSqlDAO.getCustomers());
        return customers;
    }

    @GET
    @Path("customers/ID/{ID}") //http://localhost:8080/group1/rest/customersapi/customers/ID/
    @Produces(MediaType.APPLICATION_XML)
    public Customers getCustomer(@PathParam("ID") int ID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());
        Customer customer = customerSqlDAO.getCustomer(ID);
        Customers customers = new Customers();
        customers.add(customer);
        return customers;
    }

// Add new customer
    @GET
    @Path("addcustomer") //http://localhost:8080/group1/rest/customersapi/addcustomer
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response addCustomer() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());
        customerSqlDAO.create("Sumi A", "sumi.A@store.com", "Hell0sumi123", "1978-10-03", "0478011456", "5 Samphire St, Sydney NSW 2140");
         Customer customer = customerSqlDAO.getCustomer("sumi.A@store.com");
        Customers customers = new Customers();
        customers.add(customer);
        
        return Response.status(200).entity(customer).build();
    }

 
    @GET
    @Path("addcustomer/{customerEmail}") //http://localhost:8080/group1/rest/customersapi/addcustomer/maggie.paul@store.com
    @Produces(MediaType.APPLICATION_XML)
    public Customers addCustomer(@PathParam("customerEmail") String customerEmail) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());
        
        
        Customer customer = customerSqlDAO.getCustomer(customerEmail);
        if(customer == null){
            customerSqlDAO.create(customerEmail);
        }
        customer = customerSqlDAO.getCustomer(customerEmail);
        Customers customers = new Customers();
        customers.add(customer);
        return customers;
    }
}


        
