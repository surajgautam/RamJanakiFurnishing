<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/23/17
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" id="home" href="${site_url}/index">RJ</a>

        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li id="products">
                    <a href="${site_url}/show/products">View Products</a>
                </li>

                <li id="login">
                    <a href="${site_url}/login">Login</a>
                </li>
                <li id="aboutus">
                    <a href="${site_url}/aboutus">About US</a>
                </li>

                <li id="contact">
                    <a href="${site_url}/contact">Contact</a>
                </li>


                <li id="admin">
                    <a href="${site_url}/admin/manage">Admin Panel</a>
                </li>

                <c:if test="${sessionScope.userName != null}">

                    <li id="name">
                      <a href="#"> Welcome ${sessionScope.userName}!!!</a>
                    </li>

                <li id="logout">
                    <a href="${site_url}/logout">Logout</a>
                </li>
                </c:if>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

