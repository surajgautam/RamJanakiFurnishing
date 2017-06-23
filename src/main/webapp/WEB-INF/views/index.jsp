<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/21/17
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="site_url"/>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>RamJanaki Decoration-${title}</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/shop-homepage.css" />" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<!-- Navigation -->
<%@ include file="common/navbar.jsp"%>

<!-- Page Content -->
<c:if test="${userHome == true}">
<%@include file="home.jsp"%>
</c:if>
<!-- /.container -->


<!-- /.container -->
<c:if test="${userAbout == true}">
<%@ include file="about.jsp"%>
</c:if>


<c:if test="${userContact==true}">
<%@ include file="contact.jsp"%>
</c:if>

<div class="container">

    <hr>

    <!-- Footer -->
    <%@include file="common/footer.jsp"%>

</div>

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery.js"/>" ></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</body>

</html>

