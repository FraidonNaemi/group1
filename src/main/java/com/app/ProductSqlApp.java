/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.model.Product;
import com.model.dao.ProductSqlDAO;
import com.model.dao.SqlDBConnector;
import com.utils.In;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 236330
 */
public class ProductSqlApp {
       private SqlDBConnector connector;
    private Connection connection;
    private ProductSqlDAO productSqlDAO;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
       ProductSqlApp app = new ProductSqlApp();
        //app.menu();
    }
    
    public ProductSqlApp() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException{
        connector = new SqlDBConnector();
        connection = connector.connection();
        productSqlDAO = new ProductSqlDAO(connection);
    }
    
    private String read(String prompt){
        System.out.print(prompt);
        return In.nextLine();
    }
     private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }
    //Testing the SQL Create Query
   private void testCreate() throws SQLException{
        System.out.println();
        System.out.println("Creating a new user: ");
        productSqlDAO.create();
        System.out.println("product has been added to the database");
    }
    
    //Testing the SQL Read Query - Read by ID
    //private void testRead() throws SQLException{
       // String email = read("Email: ");
       // String password = read("Password: ");
       // Product product = ProductSqlDAO.login(email, password);
       // if (user != null){
        //    System.out.println(user);
      //  }else
        //    System.out.print("user is not found");
    //}
    
    //Testing the SQL Read - Many Query
    private void testGetAll() throws SQLException{
        System.out.println();
        List<Product> products = productSqlDAO.getProducts();
        products.forEach(p -> System.out.println(p));
    }
   
    //Testing the SQL Update Query - Update (name, password) by ID
//    private void testUpdate() throws SQLException{
//        int productID = readInt("id: ");
//        Product product = productSqlDAO.getProduct(productID); 
//        if(product != null){
//            System.out.println("Update user record: ");
//            String productImage = read("image: ");
//            String productName = read("name: ");
//            double productPrice = 22.22;
//            String productCtegory="sport";
//            String productDescription= read("desc: ");
//            int productStock=5;
//            
//            
//            productSqlDAO.update(productID,productImage, productName, productPrice, productCtegory,productDescription.productStock);
//        }else{
//            System.out.println("User does not exist");
//        }
//    }
  
//    //Testing the SQL Delete Query - by ID
//    private void testDelete() throws SQLException{
//        int productID = Integer.parseInt(read("ID: "));
//        Product product = productSqlDAO.getProduct(productID); 
//        if(product != null){
//            System.out.println("Deleting user record: ");
//            productSqlDAO.delete(productID);
//        }else{
//            System.out.println("User does not exist");
//        }
//    }
//
//
//    private void menu() throws SQLException{
//        char c;
//        help();
//        while((c=read("Command [c/r/u/d/f/x]: ").charAt(0)) != 'x'){
//            switch(c){
//                case 'c': testCreate();break;
//                //case 'r': testRead(); break;
//                case 'u': testUpdate(); break;
//                case 'd': testDelete();break;
//                case 'f': testGetAll();break;
//                default: help(); break;
//            }
//        }
//    }
//    private void help(){
//        System.out.println("Database Operations: \n"
//                + "c = Create User \n"
//                + "r = Read User by ID-Password \n"
//                + "u = Update User by ID \n"
//                + "d = Delete User by ID\n"
//                + "f = Fetch all Users\n");
//    }
}
//

