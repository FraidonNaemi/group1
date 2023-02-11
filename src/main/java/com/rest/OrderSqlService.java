/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.model.Order;
import com.model.Orders;
import com.model.dao.OrderSqlDAO;
import com.model.dao.SqlDBConnector;
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
 * @author 236369
 */
//had an issue when I set the path to sqlapi
@Path("orderapi")
public class OrderSqlService {

    //get all the orders in the database
    @GET
    @Path("orders") //http://localhost:8080/group1/rest/orderapi/orders
    @Produces(MediaType.APPLICATION_XML)
    public Orders getOrders() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        OrderSqlDAO orderSqlDAO = new OrderSqlDAO(new SqlDBConnector().connection());
        Orders orders = new Orders();
        orders.addAll(orderSqlDAO.getOrders());
        return orders;
    }

    //get all orders for a customer by ID (parameter)
    @GET
    @Path("orders/customerID/{customerID}") //http://localhost:8080/group1/rest/orderapi/orders/customerID/
    @Produces(MediaType.APPLICATION_XML)
    public Orders getOrders(@PathParam("customerID") int customerID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        OrderSqlDAO orderSqlDAO = new OrderSqlDAO(new SqlDBConnector().connection());
        Orders orders = new Orders();
        orders.addAll(orderSqlDAO.getAllOrders(customerID));
        return orders;
    }

    // Add new order and show it
    @GET
    @Path("addOrder") //http://localhost:8080/group1/rest/orderapi/addOrder
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addOrder() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        OrderSqlDAO orderSqlDAO = new OrderSqlDAO(new SqlDBConnector().connection());
        orderSqlDAO.create(1, java.time.LocalDate.now().toString());
        Order order = orderSqlDAO.getOrderByOrderID(orderSqlDAO.lastOrderID(1));
        Orders orders = new Orders();
        orders.add(order);
        return Response.status(200).entity(order).build();
    }

    //Add new order by parameter (customerID) and show it
    @GET
    @Path("addorder/{customerID}") //http://localhost:8080/group1/rest/orderapi/addorder/........
    @Produces(MediaType.APPLICATION_XML)
    public Orders addOrder(@PathParam("customerID") int customerID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {

        OrderSqlDAO orderSqlDAO = new OrderSqlDAO(new SqlDBConnector().connection());
        orderSqlDAO.create(1, java.time.LocalDate.now().toString());
        Order order = orderSqlDAO.getOrderByOrderID(orderSqlDAO.lastOrderID(1));
        Orders orders = new Orders();
        orders.add(order);

        return orders;
    }
}
