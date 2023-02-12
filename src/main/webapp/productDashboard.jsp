<%@page import="com.model.dao.ProductSqlDAO"%>
<%@page import="com.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Dashboard</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/productDashboard.css">
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
                <li><a href="adminProductView.jsp">View Products</a></li>
                <li><a class="active" href="#">Product Dashboard</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <%
            String productPriceError = (String) session.getAttribute("productPriceError");
            String productDescriptionError = (String) session.getAttribute("productDescriptionError");
            String productStockError = (String) session.getAttribute("productStockError");
            String submitted = (String) session.getAttribute("submitted");

            Product product = null;
            String productID = request.getParameter("productID");
            if (productID != null) {
                ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");
                product = productSqlDAO.getProduct(Integer.parseInt(productID));
            } else {
                product = (Product) session.getAttribute("product");
            }
            session.setAttribute("product", product);
        %>

        <!-- Update Form -->

        <div class="container">
            <header>Update Product</header>
            <div class="confirm-field" style="text-align: center;">
                <p style="color: green;"><%= (submitted != null  ) ? "Updated successfully" : ""%></p>
            </div>
            <form method="POST" action="/group1/RegexUpdateProductServlet">
                <div class="form first">
                    <div class="product-details">
                        <span class="title">ID: <%=product.getProductID()%></span>
                        
                        <div class="fields">
                            <div class="input-field">
                                <label for="productImage">Image URL<span class="updateProductError"></span></label>
                                <input type="text" name="productImage" value="<%= product.getProductImage()%>">
                            </div>

                            <div class="input-field">
                                <label for="productName">Name</label>
                                <input type="text" name="productName" value="<%= product.getProductName()%>" readonly="true">
                            </div>

                            <div class="input-field">
                                <label for="productPrice">Price&emsp;<span class="updateProductError">&emsp;<%= (productPriceError != null) ? productPriceError : ""%></span></label>
                                <input type="text" name="productPrice" value="<%= product.getProductPrice()%>" >
                            </div>

                            <div class="input-field">
                                <div class="input-area">
                                    <label for="productCategory">Category</label>
                                    <select name="productCategory" id="productCategory" class="select-option">
                                        <option value="sport" class="select-option">Sport</option>
                                        <option value="tech" class="select-option">Tech</option>
                                        <option value="healthAndBeauty" class="select-option">Health & Beauty</option>
                                        <option value="chocolate" class="select-option">Chocolate</option>
                                    </select>
                                </div>
                            </div>

                            <div class="input-field">
                                <label for="productStock">Stock &emsp;<span class="addCustomerError">&emsp;<%= (productStockError != null) ? productStockError : ""%></span></label>
                                <input type="text" name="productStock" value="<%= product.getProductStock()%>" >
                            </div>
                            
                            <div class="input-field">
                                <label for="productDescription">Description &emsp;<span class="addCustomerError">&emsp;<%= (productDescriptionError != null) ? productDescriptionError : ""%></span></label>
                                <input type="text" name="productDescription" value="<%= product.getProductDescription()%>">
                            </div> 
                            
                            <input type="hidden" name="submitted" value="submitted">
                            <input type="hidden" name="productID" value="<%=product.getProductID()%>">
                            
                            <div class="buttons">
                                <button class="deleteBtn">
                                    <span class="btnText"><a href="/group1/DeleteProductServlet" style="text-decoration: none; color:#fff;">Delete</a></span>
                                </button>

                                <button class="updateBtn" type="submit">
                                    <span class="btnText">Update</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <%
            submitted ="";
            productPriceError ="";
            productDescriptionError ="";
            productStockError ="";
            session.setAttribute("submitted", submitted);
            session.setAttribute("productPriceError", productPriceError);
            session.setAttribute("productDescriptionError", productDescriptionError);
            session.setAttribute("productStockError", productStockError);
        %>
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>