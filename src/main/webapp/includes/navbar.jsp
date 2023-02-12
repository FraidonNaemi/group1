<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">My Order</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="orderView.jsp">Order View <span class="badge badge-danger">${cart_list.size()}</span> </a></li>

                <li class="nav-item"><a class="nav-link" href="myOrders.jsp">Orders</a></li>
                <li class="nav-item"><a class="nav-link" href="main.jsp">my Detailes</a></li>
                <li class="nav-item"><a class="nav-link" href="/group1/LogoutServlet">Logout</a></li>

            </ul>
        </div>
    </div>
</nav>