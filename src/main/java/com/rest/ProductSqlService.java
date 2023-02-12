/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.model.Product;
import com.model.Products;
import com.model.dao.ProductSqlDAO;
import com.model.dao.SqlDBConnector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

/**
 *
 * @author 236369
 */
@Path("productsql")
public class ProductSqlService {
// return all the products
    @GET
    @Path("products") //http://localhost:8080/group1/rest/productsql/products
    @Produces(MediaType.APPLICATION_XML)
    public Products getProducts() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        ProductSqlDAO productSqlDAO = new ProductSqlDAO(new SqlDBConnector().connection());
        Products products = new Products();
        products.addAll(productSqlDAO.getProducts());
        return products;
    }
// return one product by id
    @GET
    @Path("product/productID/{productID}") //http://localhost:8080/group1/rest/productsql/product/productID/...
    @Produces(MediaType.APPLICATION_XML)
    public Products getProduct(@PathParam("productID") int productID) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        ProductSqlDAO productSqlDAO = new ProductSqlDAO(new SqlDBConnector().connection());

        Product product = productSqlDAO.getProduct(productID);
        Products products = new Products();
        products.add(product);
        return products;
    }

    // Add new product(fixed value and return response message)
    @GET
    @Path("addProduct") //http://localhost:8080/group1/rest/productsql/addProduct
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response addProduct() throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        ProductSqlDAO productSqlDAO = new ProductSqlDAO(new SqlDBConnector().connection());
        productSqlDAO.create("image", "playstation",20.5,"sport","football",5);

        Product product = productSqlDAO.getProduct("xbox");
        Products products = new Products();
        products.add(product);

        return Response.status(200).entity(product).build();
    }
    //add new product using parameter if not exist , if exist return it .
    @GET
    @Path("addproduct/{productName}") //http://localhost:8080/group1/rest/productsql/addproduct/........
    @Produces(MediaType.APPLICATION_XML)
    public Products addProduct(@PathParam("productName") String productName) throws JAXBException, FileNotFoundException, ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        ProductSqlDAO productSqlDAO = new ProductSqlDAO(new SqlDBConnector().connection());

        Product product = productSqlDAO.getProduct(productName);
        if (product == null){
        productSqlDAO.create(productName);
        }
        product = productSqlDAO.getProduct(productName);   
        Products products = new Products();
        products.add(product);
        return products;
    }
}
