/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.ProductSqlDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 236330
 */
public class RegexUpdateProductServlet extends HttpServlet {

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
        String submitted =(String) session.getAttribute("submitted");


        // set Regex roles
        String productPriceRegEx = "([0-9]+)[.]([0-9]+)";
        String productDescriptionRegex = "([a-zA-Z0-9 ]{2,1000})";
        String productStockRegex = "([0-9]+)";
        //flag to return the error message
        boolean productPriceError = false;
        boolean productDescriptionError = false;
        boolean productStockError = false;
        //match the regex
        if (!productPrice.matches(productPriceRegEx)) {
            session.setAttribute("productPriceError", "Incorrect format");
            productPriceError = true;
        }
        if (!productDescription.matches(productDescriptionRegex)) {
            session.setAttribute("productDescriptionError", "Incorrect format");
            productDescriptionError = true;
        }
        if ((!productStock.matches(productStockRegex)) && theProductStock < 0) {
            session.setAttribute("productStockError", "Incorrect format");
            productStockError = true;
        }
        //if any field doesnt meet the regex return to dashboard page
        if (productPriceError == true
                || productDescriptionError == true
                || productStockError == true) {
            submitted =null;
            session.setAttribute("submitted", submitted);
            request.getRequestDispatcher("productDashboard.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("/UpdateProductServlet").include(request, response);

        }
    }
}
