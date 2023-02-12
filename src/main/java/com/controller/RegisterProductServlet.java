package com.controller;

import com.model.Product;
import com.model.dao.ProductSqlDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");
        // get the parameter from(registerProduct.jsp) from the session 
        String productImage = request.getParameter("productImage");
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        double theProductPrice = Double.parseDouble(productPrice);
        String productCategory = request.getParameter("productCategory");
        String productDescription = request.getParameter("productDescription");
        String productStock = request.getParameter("productStock");
        int theProductStock = Integer.parseInt(productStock);
        // declare and initialize product to null
        Product productSql = null;
        try {
            //search for product fron the database
            productSql = productSqlDAO.getProduct(productName);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //if we have the product return error message
        if (productSql != null) {
            session.setAttribute("productError", "Product already exists");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else {
            //create new product
            try {
                productSqlDAO.create(productImage, productName, theProductPrice, productCategory, productDescription, theProductStock);
                Product product = productSqlDAO.getProduct(productName);
                session.setAttribute("product", product);
                request.getRequestDispatcher("productDashboard.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
