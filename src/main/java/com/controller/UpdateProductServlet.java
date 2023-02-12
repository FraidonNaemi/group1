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

public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");

        String submitted = request.getParameter("submitted");
        int productID = Integer.parseInt(request.getParameter("productID"));

        if (submitted != null && submitted.equals("submitted")) {
            Product product = null;
            try {
                product = productSqlDAO.getProduct(productID);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
          // get the parameter from(productDashboard.jsp) from the session 
            String productImage = request.getParameter("productImage");
            String productName = request.getParameter("productName");
            String productPrice = request.getParameter("productPrice");
            double theProductPrice = Double.parseDouble(productPrice);
            String productCategory = request.getParameter("productCategory");
            String productDescription = request.getParameter("productDescription");
            String productStock = request.getParameter("productStock");
            int theProductStock = Integer.parseInt(productStock);
            
            //update the local product
            product.update(productID, productImage, productName, theProductPrice, productCategory, productDescription, theProductStock);
            try {
                //update the product inside the data base
                productSqlDAO.update(productID, productImage, productName, theProductPrice, productCategory, productDescription,theProductStock);
            } catch (SQLException ex) {
                Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            session.setAttribute("product", product);
            request.getRequestDispatcher("productDashboard.jsp").include(request, response);
        }
    }
}
