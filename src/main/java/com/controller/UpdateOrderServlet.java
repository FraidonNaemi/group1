/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.OrderProduct;
import com.model.Product;
import com.model.Products;
import com.model.dao.OrderProductSqlDAO;
import com.model.dao.ProductSqlDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 236369
 */
public class UpdateOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        OrderProductSqlDAO orderProductSqlDAO = (OrderProductSqlDAO) session.getAttribute("orderProductSqlDAO");
        String submitted = request.getParameter("submitted");
        ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");

        List<Product> productList = new ArrayList<>();
        try {
            productList = productSqlDAO.getProducts();
            Products products = new Products();
            products.addAll(productList);
            int productID = Integer.parseInt(request.getParameter("productID"));
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            //the new qunatity
            int quantity = Integer.parseInt(request.getParameter("qunatity"));
            //the customer's product
            OrderProduct orderProduct = orderProductSqlDAO.getOrderProduct(orderID, productID);
            //quantity before update
            int quantityBeforUpdate = orderProduct.getQuantity();
            //the product form the db
            Product product = productSqlDAO.getProduct(productID);
            if (submitted != null && submitted.equals("submitted") && (quantity > 0)) {

                //buying
                if (quantity > quantityBeforUpdate) {
                    int stockBeforeUpdate = product.getProductStock();
                    int newQuant = quantity - quantityBeforUpdate;
                    if (newQuant <= stockBeforeUpdate) {

                        orderProductSqlDAO.update(quantity, orderID, productID);
                        int newStock = stockBeforeUpdate - newQuant;
                        productSqlDAO.updateStock(productID, newStock);

                    } else {
                        //erorr
                    }

                    //salling
                } else if (quantity < quantityBeforUpdate) {
                    int newQuant = quantityBeforUpdate - quantity;
                    int stockBeforeUpdate = product.getProductStock();

                    int newStock = stockBeforeUpdate + newQuant;
                    productSqlDAO.updateStock(productID, newStock);
                    orderProductSqlDAO.update(quantity, orderID, productID);

                } else {
                    session.setAttribute("stockErorr", "Not Enoughe Stock!");
                    request.getRequestDispatcher("productControl.jsp").include(request, response);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UpdateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("orderView.jsp").include(request, response);
    }
}
