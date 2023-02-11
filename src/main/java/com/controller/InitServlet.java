package com.controller;

import com.model.dao.AdminSqlDAO;
import com.model.dao.CustomerSqlDAO;
import com.model.dao.OrderProductSqlDAO;
import com.model.dao.OrderSqlDAO;
import com.model.dao.ProductSqlDAO;
import com.model.dao.SqlDBConnector;
import java.io.IOException;
import java.sql.Connection;
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
 * @author group1
 */
public class InitServlet extends HttpServlet {

    private CustomerSqlDAO customerSqlDAO;
    private AdminSqlDAO adminSqlDAO;
    private ProductSqlDAO productSqlDAO;
    private OrderSqlDAO orderSqlDAO;
    private OrderProductSqlDAO orderProductSqlDAO;

    private SqlDBConnector dBConnector;
    private Connection connection;

    @Override
    public void init() {
        try {
            dBConnector = new SqlDBConnector();
            connection = dBConnector.connection();
            adminSqlDAO = new AdminSqlDAO(connection);
            productSqlDAO = new ProductSqlDAO(connection);
            customerSqlDAO = new CustomerSqlDAO(connection);
            orderSqlDAO = new OrderSqlDAO(connection);
            orderProductSqlDAO = new OrderProductSqlDAO(connection);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("adminSqlDAO", adminSqlDAO);
        session.setAttribute("customerSqlDAO", customerSqlDAO);
        session.setAttribute("productSqlDAO", productSqlDAO);
        session.setAttribute("orderSqlDAO", orderSqlDAO);
        session.setAttribute("orderProductSqlDAO", orderProductSqlDAO);

    }

    @Override
    public void destroy() {
        try {
            dBConnector.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(InitServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
