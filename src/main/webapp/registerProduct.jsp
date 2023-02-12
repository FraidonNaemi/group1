<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/registerProduct.css">
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
                <li><a class="active" href="#">Register Product</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <!-- Downloading the errors -->
        <%
            String productNameError = (String) session.getAttribute("productNameError");
            String productPriceError = (String) session.getAttribute("productPriceError");
            String productDescriptionError = (String) session.getAttribute("productDescriptionError");
            String productStockError = (String) session.getAttribute("productStockError");
            String productError = (String) session.getAttribute("productError");
        %>

        <!-- Sign up - Form -->
        <div class="container">
            <header>Register Product</header>
            <div class="error-field-register" style="text-align: center;"> 
                <p style="color: red;"><%= (productError != null) ? productError : ""%></p>
            </div>
            <form class="addForm" method="POST" action="/group1/RegexRegisterProductServlet">
                <div class="form first">
                    <div class="product-details">
                        <div class="fields">
                            <div class="input-field">
                                <label for="productImage">Image URL<span class="addProductError"></span></label>
                                <input type="text" required name="productImage" placeholder="product URL">
                            </div>
                            
                            <div class="input-field">
                                <label for="productName">Name &emsp;<span class="addProductError">&emsp;<%= (productNameError != null) ? productNameError : ""%></span></label>
                                <input type="text" required name="productName" placeholder="Product Name">
                            </div>

                            <div class="input-field">
                                <label for="productPrice">Price&emsp;<span class="addProductError">&emsp;<%= (productPriceError != null) ? productPriceError : ""%></span></label>
                                <input type="number" required  step="any" name="productPrice" placeholder="Product Price">
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
                                <label for="productStock">Stock &emsp;<span class="addProductError">&emsp;<%= (productStockError != null) ? productStockError : ""%></span></label>
                                <input type="number" required   name="productStock" placeholder="Product Stock">
                            </div>    
                                
                            <div class="input-field">
                                <label for="productDescription">Description &emsp;<span class="addProductError">&emsp;<%= (productDescriptionError != null) ? productDescriptionError : ""%></span></label>
                                <input type="text" required name="productDescription" placeholder="Product Description">
                            </div>
                                
                            <button class="addBtn" type="submit">
                                <span class="btnText">Add</span>
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <%

            productNameError = "";
            productPriceError = "";
            productDescriptionError = "";
            productStockError = "";
            productError = "";

            session.setAttribute("productNameError", productNameError);
            session.setAttribute("productPriceError", productPriceError);
            session.setAttribute("productDescriptionError", productDescriptionError);
            session.setAttribute("productStockError", productStockError);
            session.setAttribute("productError", productError);

        %>

         <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>