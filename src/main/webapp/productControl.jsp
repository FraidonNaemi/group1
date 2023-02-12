<%-- 
    Document   : index
    Created on : Jan 24, 2023, 9:43:17 AM
    Author     : group1
--%>

<%@page import="java.util.List"%>
<%@page import="com.model.dao.OrderProductSqlDAO"%>
<%@page import="com.model.OrderProduct"%>
<%@page import="com.model.OrderProducts"%>
<%@page import="com.model.Products"%>
<%@page import="com.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <!-- Navigation Bar -->
        <nav>
            <div class="logo">
                AFSY
            </div>
            <input type="checkbox" id="click">
            <label for="click" class="menu-btn">
                <i class="fas fa-bars"></i>
            </label>
            <ul>
                <li><a class="active" href="#">Home</a></li>
                <li><a href="registerProduct.jsp">Register</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="shopPage.jsp">shop</a></li>

            </ul>
        </nav>

        <!--        --------------------->

        <!-- Update Form -->
        <%
            String stockError = (String) session.getAttribute("stockError");

            OrderProductSqlDAO orderProductSqlDAO = (OrderProductSqlDAO) session.getAttribute("orderProductSqlDAO");
            int orderID = (int) session.getAttribute("orderID");
            //int orderID = Integer.parseInt(request.getParameter("orderID"));
            List<OrderProduct> opList = orderProductSqlDAO.getAllOrderProducts(orderID);
            OrderProducts ops = new OrderProducts();
            ops.addAll(opList);
            //int productID = (int) session.getAttribute("productID");
            int productID = Integer.parseInt(request.getParameter("productID"));
            OrderProduct op = ops.orderProduct(orderID, productID);

            String submitted = request.getParameter("submitted");
            session.setAttribute("orderProduct", op);
        %>


        <div class="wrapper-account" style="height: 650px!important;">
            <header>Item Edit</header>
            <div class="confirm-field">
                <p>
                    <%if (stockError != null)
                            out.print(stockError);%>
                </p>
            </div>
            <form method="POST" action="/group1/UpdateOrderServlet">
                <div class="field ID">
                    <div class="input-area">
                        <label for="productImage">Order ID<span class="addCustomerError"></span></label>
                        <input type="text" name="orderID" value="<%= op.getOrderID()%>" readonly="true">
                        <i class="icon fas fa-id"></i>
                        <i class="error error-icon fas fa-exclamation-circle"></i>
                    </div>
                </div>
                <div class="field ID">
                    <div class="input-area">
                        <label for="productImage">Product ID<span class="addCustomerError"></span></label>
                        <input type="text" name="productID" value="<%= op.getProductID()%>" readonly="true">
                        <i class="icon fas fa-id"></i>
                        <i class="error error-icon fas fa-exclamation-circle"></i>
                    </div>
                </div>
                <div class="field ID">
                    <div class="input-area">
                        <label for="productImage">Product Quantity <span class="addCustomerError"></span></label>
                        <input type="number" name="qunatity" value="<%= op.getQuantity()%>">
                        <i class="icon fas fa-id"></i>
                        <i class="error error-icon fas fa-exclamation-circle"></i>
                    </div>
                </div>
                <input type="hidden" name="submitted" value="submitted">
                <div class="account-div">
                    <table class="account-table">
                        <tr>
                            <td class="acc-td"><span class="account-delete-button" style="background: #FF2305; color: white; padding-top: 14px; padding-bottom: 14px; padding-left: 20px; padding-right: 20px; border-radius: 5px; font-size: 18px;"><a href="/group1/DeleteOrderProductServlet?productID=<%= op.getProductID()%>" class="account-delete-link" style="color: white;">Delete</a></span></td>
                            <td class="acc-td"><input type="submit" class="update-input-account" value="Update" style="width: 100px;"></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>
        <%
            submitted = "";
            session.setAttribute("submitted", submitted);
            session.setAttribute("stockError", "");
        %>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>

    </body>
</html>
