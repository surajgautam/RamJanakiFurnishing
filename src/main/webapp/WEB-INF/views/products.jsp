<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/25/17
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

    <%--<div class="row">--%>

    <%--<!-- sidebar view-->--%>
    <%--<div class="col-md-3">--%>
    <%--<%@include file="common/sidebar.jsp"%>--%>
    <%--</div>--%>

    <%--<div class="col-md-9">--%>

    <%--<div class="row">--%>

    <%--<div class="col-lg-12">--%>

    <%--<c:if test="${userAllProducts == true}">--%>
    <%--<ol class="breadcrumb">--%>
    <%--<li><a href="<c:url value="${site_url}/index" />">Home</a></li>--%>
    <%--<li class="active">All Products</li>--%>
    <%--</ol>--%>
    <%--</c:if>--%>

    <%--<c:if test="${userSingleProduct == true}">--%>
    <%--<ol class="breadcrumb">--%>
    <%--<li><a href="<c:url value="${site_url}/index" />">Home</a></li>--%>
    <%--<li class="active">Category</li>--%>
    <%--<li class="active">${category.cname}</li>--%>
    <%--</ol>--%>
    <%--</c:if>--%>

    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--</div>--%>

    <div class="row">

        <div class="col-md-3">

            <%@include file="common/sidebar.jsp" %>


        </div>

    <!-- actual products -->
        <div class="col-md-9">

            <div class="row">
                <div class="col-lg-12">

                    <c:if test="${userAllProducts == true}">
                        <script>
                            window.categoryID='';
                        </script>
                        <ol class="breadcrumb">
                            <li><a href="${site_url}/index">Home</a></li>
                            <li class="active">All Products</li>
                        </ol>
                    </c:if>

                    <c:if test="${userSingleProduct == true}">
                        <script>
                            window.categoryID='${category.cid}';
                        </script>
                        <ol class="breadcrumb">
                            <li><a href="${site_url}/index">Home</a></li>
                            <li class="active">Category</li>
                            <li class="active">${category.cname}</li>
                        </ol>
                    </c:if>

                </div>


            </div>


            <div class="row">

                <div class="col-xs-12">

                    <table id="productListTable" class="table table-striped table-bordered">


                        <thead>

                        <tr>
                            <th></th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th></th>
                        </tr>


                        </thead>




                    </table>



                </div>


            </div>


        </div>


    </div>

</div>


