<%@page import="com.model.dao.ProductSqlDAO"%>
<%@page import="com.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Dashboard</title>
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
                <li><a class="active" href="#">Product Dashboard</a></li>
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
            <div class="confirm-field">
                <p><%= (submitted != null) ? "Updated successfully" : ""%></p>
            </div>



            <form method="POST" action="/group1/RegexUpdateProductServlet">
                <div class="form first">
                    <div class="details personal">
                        <div class="fields">

                            <div class="input-field">
                                <label for="productID">product ID <span class="addCustomerError"></span></label>
                                <input type="text" name="productID" value="<%= product.getProductID()%>" readonly="true">
                            </div>

                            <div class="input-field">
                                <label for="productImage">product Image <span class="addCustomerError"></span></label>
                                <input type="text" name="productImage" value="<%= product.getProductImage()%>">
                            </div>

                            <div class="input-field">
                                <label for="productName">product Name &emsp;<span class="addCustomerError"></span></label>
                                <input type="text" name="productName" value="<%= product.getProductName()%>" readonly="true">
                            </div>

                            <div class="input-field">
                                <label for="productPrice">product Price&emsp;<span class="addCustomerError">&emsp;<%= (productPriceError != null) ? productPriceError : ""%></span></label>
                                <input type="text" name="productPrice" value="<%= product.getProductPrice()%>" >
                            </div>
                            <!--                    <div class="field productCategory">
                                                    <div class="input-area">
                                                        <input type="text" name="productCategory" value="">
                                                        <i class="icon fas fa-lock"></i>
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
                                <input type="text" name="productDescription" value="<%= product.getProductDescription()%>">
                            </div>  





                            <div class="input-field">
                                <label for="productStock">product Stock &emsp;<span class="addCustomerError">&emsp;<%= (productStockError != null) ? productStockError : ""%></span></label>
                                <input type="text" name="productStock" value="<%= product.getProductStock()%>" >
                            </div>


                            <input type="hidden" name="submitted" value="submitted">
                            <div class="account-div">
                                <table class="account-table">
                                    <tr>
                                        <td class="acc-td"><span class="account-delete-button" style="background: #FF2305; color: white; padding-top: 14px; padding-bottom: 14px; padding-left: 20px; padding-right: 20px; border-radius: 5px; font-size: 18px;"><a href="/group1/DeleteProductServlet" class="account-delete-link" style="color: white;">Delete</a></span></td>
                                        <td class="acc-td"><input type="submit" class="update-input-account" value="Update" style="width: 100px;"></td>
                                    </tr>
                                </table>
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
        <!-- Clock - Footer -->
        <div class="clock">
            <span class="clock-time"></span>
            <span class="clock-ampm"></span>
        </div>
        <script src="js/clock.js"></script>
    </body>
</html>