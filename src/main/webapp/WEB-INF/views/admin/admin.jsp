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

    <title>RJ- ${title}</title>

    <script>
        window.menu = '${title}';
        window.siteURL='${site_url}';
    </script>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/> " rel="stylesheet">

    <!--Custom theme-->
    <link href="<c:url value="/resources/css/bootstrap-custom-theme.css" />" rel="stylesheet">

    <!--Datatable bootstrap css-->
    <link href="<c:url value="/resources/css/dataTables.bootstrap.css " />" rel="stylesheet">

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
<div class="wrapper">
    <!-- Navigation -->
    <%@ include file="../common/navbar.jsp" %>

    <div class="content">

        <div class="container">

            <div class="row">

                <div class="col-md-3">
                    <%@include file="admin-sidebar.jsp"%>
                </div>

                <div class="col-md-9">

                    <c:if test="${categoriesClicked == true}">
                        <ul class="nav nav-pills">
                            <li role="presentation" class="active"><a href="#viewData">View</a></li>
                            <li role="presentation"><a href="${site_url}/admin/add/category">Add</a></li>
                        </ul>


                        <%--showing success message after edit success--%>
                        <c:if test="${not empty message}">
                            <div class="alert alert-success">
                                <strong>${message}</strong>
                            </div>
                        </c:if>

                        <div id="viewData" class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Status</th>
                                    <th>Name</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--iterating over list of categories for showing categories--%>
                                <c:forEach var="data" items="${categories}">
                                <tr>
                                    <c:choose>
                                        <c:when test="${data.active == true}">
                                            <c:set value="Enabled" var="status"></c:set>
                                        </c:when>
                                        <c:otherwise>
                                            <c:set value="Disabled" var="status"></c:set>
                                        </c:otherwise>
                                    </c:choose>
                                    <td>${data.cid}</td>
                                    <td>${status}</td>
                                    <td>${data.cname}</td>
                                    <td>
                                        <a href="<c:url value="/admin/edit/category/${data.cid}"/> " class="btn btn-success"><span class="glyphicon glyphicon-edit">Edit</span></a>
                                        <a href="<c:url value="/admin/delete/category/${data.cid}"/> " class="btn btn-success"><span class="glyphicon glyphicon-remove">Delete</span> </a>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </div>
                    </c:if>
                    <c:if test="${editCategory == true}">
                        <%@include file="edit-category.jsp"%>
                    </c:if>

                    <c:if test="${addCategory == true}">
                        <%@include file="add-category.jsp"%>
                    </c:if>

                </div>


            </div>

        </div>




    </div>



    <hr>

    <!-- Footer -->
    <%@include file="../common/footer.jsp" %>


    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <!--Data Table-->
    <script src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>

    <!--Data Table js -->
    <script src="<c:url value="/resources/js/dataTables.bootstrap.js" />"></script>


    <!--Custom js -->
    <script src = "<c:url value="/resources/js/custom.js" />"></script>




</div>
</body>

</html>

