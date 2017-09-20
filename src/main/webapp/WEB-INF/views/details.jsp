<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/28/17
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session.getAttribute("id")==null){
        response.sendRedirect("/ecommerce/login");
    }
%>


<div class="container">


    <div class="row">

        <div class="col-xs-12">


            <!--bread crumb-->
            <ol class="breadcrumb">
                <li><a href="<c:url value=" ${site_url}/index"/>">Home</a></li>
                <li><a href="<c:url value=" ${site_url}/show/products"/>">Products</a></li>
                <li>${product.pname}</li>
            </ol>

        </div>
    </div>

    <div class="row">

        <%--Display the image for mobile like devices 12--%>
        <div class="col-xs-12 col-sm-7">

            <img src="<c:url value="${product.image}" />" alt="${product.pname}" width="600" height="500"/>


        </div>

        <div class="col-sm-5">
            <h3>${product.pname}</h3>
            <h4>Description</h4>
            <p>${product.description}</p>
            <h4>Price: </h4><strong>${product.price}</strong>


            <c:choose>
            <c:when test="${product.quantity < 1}">


                <h6>Quantity:</h6><strong><span style="color: red">OUT OF STOCK!!</span> </strong>


            </c:when>
                <c:otherwise>
                    <h6>Quantity:</h6><strong>${product.quantity}</strong>
                    <form action="http://dev.esewa.com.np/epay/main" method="POST" ng-controller="PaymentController as pc">
                        <input value="${product.price}" name="amt" type="hidden">
                        <input value="${product.price * 0.10}" name="txAmt" type="hidden">
                        <input value="0" name="psc" type="hidden">
                        <input value="0" name="pdc" type="hidden">
                        <input value="${product.pid}" type="hidden" name="id"/>
                        <input value="${product.price + product.price * 0.10}" name="tAmt" type="hidden">
                        <input value="college_test" name="scd" type="hidden">
                        <input value="XYZ-1234" name="pid" type="hidden">
                        <input value="http://localhost:8080/ecommerce/payment?action=su" type="hidden" name="su">
                        <input value="http://localhost:8080/ecommerce/payment?action=fu" type="hidden" name="fu">
                        <input  class="btn btn-success" value="Checkout using Esewa" ng-click="pc.acceptPayment()" type="submit">
                        <a href="<c:url value="/show/products"/> " class="btn btn-success">Back</a>
                    </form>
                </c:otherwise>

            </c:choose>


            <h6>Views:</h6><strong>${product.views}</strong> <br/>


        </div>
    </div>


</div>

