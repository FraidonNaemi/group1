<%@page import="com.model.Admin"%>
<%@page import="com.model.dao.AdminSqlDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
        <title>Account</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/account.css">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    </head>
    <body>
        <%
            String emailView = (String) session.getAttribute("emailView");
        %>

        <!-- Navigation Bar -->
        <nav>
            <div class="logo">
                FASY
            </div>
            <input type="checkbox" id="click">
            <label for="click" class="menu-btn">
                <i class="fas fa-bars"></i>
            </label>
            <ul>
                <li>
                    <!-- Work in this part -->
                    <a href="adminMain.jsp">Dashboard</a>
                </li>
                <li><a class="active" href="#">Admin Account</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <%
            AdminSqlDAO adminSqlDAO = (AdminSqlDAO) session.getAttribute("adminSqlDAO");
            Admin admin = (Admin) session.getAttribute("admin");
            String submitted = request.getParameter("submitted");

            String adminNameError = (String) session.getAttribute("adminNameError");
            String adminPasswordError = (String) session.getAttribute("adminPasswordError");
            String adminDOBError = (String) session.getAttribute("adminDOBError");
            String adminPhoneNumberError = (String) session.getAttribute("adminPhoneNumberError");
            String adminAddressError = (String) session.getAttribute("adminAddressError");
        %>

        <!-- Update Admin Form -->
        <div class="container" style="text-align: left!important; margin: 10% 25%;">
        <header>Update Account</header>
        <form class="updateForm" method="POST" action="/group1/AdminAccountServlet">
            <div class="form first">
                <div class="details personal">
                    <span class="title">ID: <%=admin.getAdminID()%></span>

                    <div class="fields">
                        <div class="input-field">
                            <label for="adminName">Full Name <span style="color: red;">&emsp;<%= (adminNameError != null) ? adminNameError : "" %></span></label>
                            <input type="text" name="adminName" value="<%= (adminNameError != null && !adminNameError.isEmpty()) ? "" : admin.getAdminName()%>">
                        </div>

                        <div class="input-field">
                            <label for="adminEmail">Email</label>
                            <input type="text" name="adminEmail" value="<%= admin.getAdminAddress()%>" readonly="true">
                        </div>

                        <div class="input-field">
                            <label for="adminPassword">Password &emsp;<span style="color: red;">&emsp;<%= (adminPasswordError != null) ? adminPasswordError : "" %></span></label>
                            <input type="text" name="adminPassword" value="<%= (adminPasswordError != null && !adminPasswordError.isEmpty()) ? "" : admin.getAdminPassword()%>">
                        </div>

                        <div class="input-field">
                            <label for="adminDOB">Date of Birth</label>
                            <input type="date" name="adminDOB" value="<%= admin.getAdminDOB()%>">
                        </div>

                        <div class="input-field">
                            <label for="adminPhoneNumber">Phone Number &emsp;<span style="color: red;">&emsp;<%= (adminPhoneNumberError != null) ? adminPhoneNumberError : "" %></span></label>
                            <input type="text" name="adminPhoneNumber" value="<%= (adminPhoneNumberError != null && !adminPhoneNumberError.isEmpty()) ? "" : admin.getAdminPhoneNumber()%>">
                        </div>

                        <div class="input-field">
                            <label for="adminAddress">Address &emsp;<span style="color: red;">&emsp;<%= (adminAddressError != null) ? adminAddressError : "" %></span></label>
                            <input type="text" name="adminAddress" value="<%= (adminAddressError != null && !adminAddressError.isEmpty()) ? "" : admin.getAdminAddress()%>">
                        </div>
                        
                        <input type="hidden" name="submitted" value="submitted">
                        <input type="hidden" name="adminID" value="<%=admin.getAdminID()%>">
                        
                        <div class="buttons">
                            <button class="deleteBtn">
                               <span class="btnText"><a href="/group1/DeleteAdminServlet?adminEmail=<%= admin.getAdminEmail()%>" style="text-decoration: none; color:#fff;">Delete</a></span>
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
            
            adminNameError = "";
            adminPasswordError = "";
            adminDOBError = "";
            adminPhoneNumberError = "";
            adminAddressError = "";
            submitted = "";
            
            
            session.setAttribute("adminNameError", adminNameError);
            session.setAttribute("adminPasswordError", adminPasswordError);                
            session.setAttribute("adminDOBError", adminDOBError);          
            session.setAttribute("adminPhoneNumberError", adminPhoneNumberError);        
            session.setAttribute("adminAddressError", adminAddressError);
            session.setAttribute("submitted", submitted);

        %>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>

