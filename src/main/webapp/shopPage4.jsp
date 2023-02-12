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
        <%@include file="/includes/head.jsp"%>
        <title>Shop Page</title>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <div class="container">
            <div class="card-header my-3">All Products</div>
            <div>
                <%
                    String createNotification = (String) session.getAttribute("createNotification");
                    if(createNotification != null)
                    out.println(createNotification);
                    String addNotification = (String) session.getAttribute("addNotification");
                    if(addNotification != null)
                    out.println(addNotification);
                %>
            </div>
            <div class="row">
                <%
                    if (!products.isEmpty()) {
                        for (Product p : products) {
                            if (p.getProductStock() > 0) {
                %>
                <div class="col-md-3 my-3">
                    <div class="card w-100">
                        <img class="card-img-top" src="product-image/<%=p.getProductImage()%>"
                             alt="Card image cap">
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
                %>
            </div>

        </div>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>