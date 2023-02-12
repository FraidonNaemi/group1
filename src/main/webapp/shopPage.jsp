<%@page import="com.model.dao.OrderSqlDAO"%>
<%@page import="com.model.Customer"%>
<%@page import="com.model.dao.OrderProductSqlDAO"%>
<%@page import="com.model.Product"%>
<%@page import="com.model.dao.ProductSqlDAO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%
    ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");
    List<Product> products = productSqlDAO.getProducts();

    Customer customer = (Customer) session.getAttribute("customer");
    OrderSqlDAO orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
    int orderID = orderSqlDAO.lastOrderID(customer.getCustomerID());
    session.setAttribute("orderID", orderID);
%>
<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <title>Shop Page</title>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: black">
            <div class="container" style="margin-left: 0; ">
                <h3 style="color:#fff; margin-right: 1100px; margin-left: 100px; font-size: 35px;">AFSY</h3>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto" style="padding: 10px;">
                        <li class="nav-item"><a class="nav-link" href="customerMain.jsp" style="color: #fff; font-size: 24px; margin-right: 10px;">Dashboard</a></li>
                        <li class="nav-item"><a class="nav-link" href="#" style="color: #fff; font-size: 24px; margin-right: 10px;">Shop</a></li>
                        <li class="nav-item"><a class="nav-link" href="myOrders.jsp" style="color: #fff; font-size: 24px; margin-right: 10px;">Orders</a></li>
                        <li class="nav-item"><a class="nav-link" href="/group1/LogoutServlet" style="color: #fff; font-size: 24px;">Logout</a></li>

                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="card-header my-3" style="text-align: center; background-color: black; color: #fff;"><h3>All Products</h3></div>
            <p style="color: green; text-align: center; font-size: 16px; font-weight: 600;">
                <%
                    String createNotification = (String) session.getAttribute("createNotification");
                    if (createNotification != null) {
                        out.println(createNotification);
                    }
                    String orderNotification = (String) session.getAttribute("orderNotification");
                    if (orderNotification != null) {
                        out.println(orderNotification);
                    }
                    String addNotification = (String) session.getAttribute("addNotification");
                    if (addNotification != null)
                        out.println(addNotification);
                %>
            </p>
            <div class="row">
                <%
                    if (!products.isEmpty()) {
                        for (Product p : products) {
                            if (p.getProductStock() > 0) {
                %>
                <div class="col-md-3 my-3">
                    <div class="card w-100">
                        <img class="card-img-top" src="img/<%=p.getProductImage()%>">
                        <div class="card-body">
                            <h5 class="card-title"><%=p.getProductName()%></h5>
                            <h6 class="price">Price: $<%=p.getProductPrice()%></h6>
                            <h6 class="category">Category: <%=p.getProductCategory()%></h6>
                            <h6 class="category">description <%=p.getProductDescription()%></h6>
                            <h6 class="category">Stock <%=p.getProductStock()%></h6>
                            <%int currentProductID = p.getProductID();%>
                            <div class="mt-3 d-flex justify-content-between">
                                <a class="btn btn-dark" href="/group1/CreateOrderProductServlet?currentProductID=<%= currentProductID%>">Add to Cart</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%}
                        }
                    } else {
                        out.println("There is no proucts");
                    }
                    session.setAttribute("createNotification", "");
                    session.setAttribute("addNotification", "");
                    session.setAttribute("orderNotification", "");
                %>
            </div>

        </div>
            
        <!-- Footer -->    
        <footer class="bg-dark text-center text-lg-start">
            <div class="text-center p-3" style="background-color: black; color: #fff; font-size: 20px;">
                AFSY © 2023
            </div>
        </footer>
    </body>
</html>