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
        <title>Product Control</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/productControl.css"/>
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
                <li><a href="customerMain.jsp">Dashboard</a></li>
                <li><a href="registerProduct.jsp">Register</a></li>
                <li><a class="active" href="#">Product Control</a></li>
                <li><a href="myOrders.jsp">Orders</a></li>
                <li><a href="shopPage.jsp">shop</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <!-- Update form -->
        <%
            String stockError = (String) session.getAttribute("stockError");
            OrderProductSqlDAO orderProductSqlDAO = (OrderProductSqlDAO) session.getAttribute("orderProductSqlDAO");
            int orderID = (int) session.getAttribute("orderID");
            List<OrderProduct> opList = orderProductSqlDAO.getAllOrderProducts(orderID);
            OrderProducts ops = new OrderProducts();
            ops.addAll(opList);
            int productID = Integer.parseInt(request.getParameter("productID"));
            OrderProduct op = ops.orderProduct(orderID, productID);
            String submitted = request.getParameter("submitted");
            session.setAttribute("orderProduct", op);
        %>


        <div class="container" style="height: 650px!important;">
            <header>Edit Product</header>
            <div class="confirm-field">
                <p style="color: red; text-align: center;">
                    <%if (stockError != null)
                            out.print(stockError);%>
                </p>
            </div>
            <form class="updateForm" method="POST" action="/group1/UpdateOrderServlet">
                <div class="product-details">
                    <div class="fields">
                        <div class="input-field">
                            <div class="input-area">
                                <label for="orderID">Order ID</label>
                                <input type="text" name="orderID" value="<%= op.getOrderID()%>" readonly="true">
                                <i class="icon fas fa-id"></i>
                                <i class="error error-icon fas fa-exclamation-circle"></i>
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="input-area">
                                <label for="productID">Product ID</label>
                                <input type="text" name="productID" value="<%= op.getProductID()%>" readonly="true">
                                <i class="icon fas fa-id"></i>
                                <i class="error error-icon fas fa-exclamation-circle"></i>
                            </div>
                        </div>
                        <div class="input-field">
                            <div class="input-area">
                                <label for="qunatity">Product Quantity <span class="addCustomerError"></span></label>
                                <input type="number" name="qunatity" value="<%= op.getQuantity()%>">
                                <i class="icon fas fa-id"></i>
                                <i class="error error-icon fas fa-exclamation-circle"></i>
                            </div>
                        </div>

                        <input type="hidden" name="submitted" value="submitted">

                        <div class="buttons">
                            <button class="deleteBtn">
                                <span class="btnText"><a href="/group1/DeleteCustomerServlet" style="text-decoration: none; color:#fff;">Delete</a></span>
                            </button>

                            <button class="updateBtn" type="submit">
                                <span class="btnText">Update</span>
                            </button>
                        </div>
                    </div>
                </div>    
            </form>
        </div>

        <%
            submitted = "";
            stockError = "";
            session.setAttribute("submitted", submitted);
            session.setAttribute("stockError", "");
        %>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>

    </body>
</html>
