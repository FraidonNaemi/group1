/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Product;
import com.model.dao.ProductSqlDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 236330
 */
public class ProductSearchServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");
        //GET THE product id
        int productID = Integer.parseInt(request.getParameter("productID"));
        //declare and initialise to null 
        Product product = null;
        try {
            //search fro the product by id
            product = productSqlDAO.getProduct(productID);
        } catch (SQLException ex) {
            Logger.getLogger(ProductSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (product != null) {
            //if we have the product inside the database set it to the session
            session.setAttribute("product", product);
            request.getRequestDispatcher("productDashboard.jsp").include(request, response);
        } else {
            //return error message
            session.setAttribute("productError", "product is not found");
            request.getRequestDispatcher("adminProductView.jsp").include(request, response);

        }

    }

}
