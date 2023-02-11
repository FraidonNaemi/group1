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
        // set Regex roles
        String productNameRegEx = "([a-zA-Z0-9]{2,50})";
        String productPriceRegEx = "([0-9]+)[.]([0-9]+)";
        String productDescriptionRegex = "([a-zA-Z0-9 ]{2,1000})";
        String productStockRegex = "([0-9]+)";
         
        boolean productNameError = false;
        boolean productPriceError = false;
        boolean productDescriptionError = false;
        boolean productStockError = false;

        if (!productName.matches(productNameRegEx)) {
            session.setAttribute("productNameError", "Incorrect format");
            productNameError = true;
        }
        if (!productPrice.matches(productPriceRegEx)) {
            session.setAttribute("productPriceError", "Incorrect format");
            productPriceError = true;
        }
        if (!productDescription.matches(productDescriptionRegex)) {
            session.setAttribute("productDescriptionError", "Incorrect format");
            productDescriptionError = true;
        }
        if ((!productStock.matches(productStockRegex )) && theProductStock < 0 ) {
            session.setAttribute("productPriceError", "Incorrect format");
            productStockError = true;
        }
        
        if (productNameError == true
                || productPriceError == true
                || productDescriptionError == true
                || productStockError == true) {
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else {
     
        Product productSql = null;
        try {
            productSql = productSqlDAO.getProduct(productName);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (productSql != null) {
            session.setAttribute("productError", "Product already exists");
            request.getRequestDispatcher("registerProduct.jsp").include(request, response);
        } else {
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

}
