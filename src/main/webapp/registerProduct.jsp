<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/addProduct.css">
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
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="#">Register Product</a></li>
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
            <div class="error-field-register"> 
                <p><%= (productError != null) ? productError : ""%></p>
            </div>
            <form class="addForm" method="POST" action="/group1/RegexRegisterProductServlet">
                <div class="form first">
                    <div class="details personal">
                        <div class="fields">



                            <div class="input-field">
                                <label for="productImage">product Image <span class="addCustomerError"></span></label>
                                <input type="text" required name="productImage" placeholder="product Link">
                            </div>


                            <div class="input-field">
                                <label for="productName">product Name &emsp;<span class="addCustomerError">&emsp;<%= (productNameError != null) ? productNameError : ""%></span></label>
                                <input type="text" required name="productName" placeholder="Product Name">
                            </div>


                            <div class="input-field">
                                <label for="productPrice">product Price&emsp;<span class="addCustomerError">&emsp;<%= (productPriceError != null) ? productPriceError : ""%></span></label>
                                <input type="number" required  step="any" name="productPrice" placeholder="Product price">
                            </div>
                            <!--
                                            <div class="field productCategory">
                                                <div class="input-area">
                                                    <input type="text" required  name="productCategory" placeholder="product Category">
                                                    <i class="icon fas fa-envelope"></i>
                                                    <i class="error error-icon fas fa-exclamation-circle"></i>
                                                </div>
                                            </div>-->
                            <div class="field productCategory">
                                <div class="input-area">
                                    <label for="productCategory">product Category</label>
                                    <select name="productCategory" id="productCategory">
                                        <option value="Book">Book</option>
                                        <option value="Sport">Sport</option>
                                    </select>
                                </div>
                            </div>


                            <div class="input-field">
                                <label for="productDescription">product Description &emsp;<span class="addCustomerError">&emsp;<%= (productDescriptionError != null) ? productDescriptionError : ""%></span></label>
                                <input type="text" required name="productDescription" placeholder="product Description">
                            </div>


                            <div class="input-field">
                                <label for="productStock">product Stock &emsp;<span class="addCustomerError">&emsp;<%= (productStockError != null) ? productStockError : ""%></span></label>
                                <input type="number" required   name="productStock" placeholder="product Stock">
                            </div>

                            <input type="submit" value="Sing Up">
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

        <!-- Clock - Footer -->
        <div class="clock">
            <span class="clock-time"></span>
            <span class="clock-ampm"></span>
        </div>
        <script src="js/clock.js"></script>
    </body>
</html>