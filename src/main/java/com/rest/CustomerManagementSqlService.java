package com.rest;

import com.model.Customer;
import com.model.Customers;
import com.model.dao.SqlDBConnector;
import com.model.dao.CustomerSqlDAO;
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

/**
 *
 * @author group1
 */
@Path("customermanagementapi")
public class CustomerManagementSqlService {
    // Show all customers
    @GET
    @Path("customers") // http://localhost:8080/group1/rest/customermanagementapi/customers
    @Produces(MediaType.APPLICATION_XML)
    public Customers getCustomers() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());
        Customers customers = new Customers();
        customers.addAll(customerSqlDAO.getCustomers());
        return customers;
    }

    // Show a customer by ID
    @GET
    @Path("customer/customerID/{customerID}") // http://localhost:8080/group1/rest/customermanagementapi/customer/customerID/15
    @Produces(MediaType.APPLICATION_XML)
    public Customers getCustomer(@PathParam("customerID") int customerID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());
        Customer customer = customerSqlDAO.getCustomer(customerID);
        Customers customers = new Customers();
        customers.add(customer);
        return customers;
    }

    // Add a new customer
    @GET
    @Path("addCustomer") // http://localhost:8080/group1/rest/customermanagementapi/addCustomer
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addCustomer() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());
        customerSqlDAO.create("Test Test", "test.test@store.com", "Hellotest123", "2001-01-01", "0479181221", "11 George Ave, Sydney 2141");
        Customer customer = customerSqlDAO.getCustomer("test.test@store.com");
        Customers customers = new Customers();
        customers.add(customer);
        
        return Response.status(200).entity(customer).build();
    }
    
    // Add a new customer by email
    @GET
    @Path("addcustomer/{customerEmail}") // http://localhost:8080/group1/rest/customermanagementapi/addcustomer/test.test@store.com
    @Produces(MediaType.APPLICATION_XML)
    public Customers addCustomer(@PathParam("customerEmail") String customerEmail) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        CustomerSqlDAO customerSqlDAO = new CustomerSqlDAO(new SqlDBConnector().connection());

        Customer customer = customerSqlDAO.getCustomer(customerEmail);
        if (customer == null){
        customerSqlDAO.create(customerEmail);
        }
        customer = customerSqlDAO.getCustomer(customerEmail);   
        Customers customers = new Customers();
        customers.add(customer);
        return customers;
    }
}