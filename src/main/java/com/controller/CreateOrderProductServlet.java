/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Customer;
import com.model.OrderProduct;
import com.model.OrderProducts;
import com.model.Product;
import com.model.dao.OrderProductSqlDAO;
import com.model.dao.OrderSqlDAO;
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

/**
 *
 * @author 236369
 */
public class CreateOrderProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            OrderSqlDAO orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
            OrderProductSqlDAO orderProductSqlDAO = (OrderProductSqlDAO) session.getAttribute("orderProductSqlDAO");
            Customer customer = (Customer) session.getAttribute("customer");

            int orderID = orderSqlDAO.lastOrderID(customer.getCustomerID());
            int productID = Integer.parseInt(request.getParameter("currentProductID"));

            OrderProducts orderProducts = new OrderProducts();
            orderProducts.addAll(orderProductSqlDAO.getAllOrderProducts(orderID));
            OrderProduct orderProduct = orderProductSqlDAO.getOrderProduct(orderID, productID);

            ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");
            Product product = productSqlDAO.getProduct(productID);

            if ((product.getProductStock() >= 1)) {

                if (orderProducts.isProductExsist(orderID, productID)) {

                    product.decProductStock(1);
                    int newStock = product.getProductStock();
                    productSqlDAO.updateStock(productID, newStock);
                    int newQuant = orderProduct.getQuantity() + 1;
                    orderProduct.setQuantity(newQuant);
                    session.setAttribute("createNotification", "Added one more of the product to the last Order!");
                } else {
                    product.decProductStock(1);
                    int newStock = product.getProductStock();
                    productSqlDAO.updateStock(productID, newStock);
                    orderProductSqlDAO.create(orderID, productID, 1);
                    session.setAttribute("createNotification", "Product is added to the last Order!");
                }

            } else {
                session.setAttribute("stockError", "Not Enough Stock!");
            }
            session.setAttribute("orderID", orderID);
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("shopPage.jsp").include(request, response);
    }
}
