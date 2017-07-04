<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/28/17
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            <h6>Quantity:</h6><strong>${product.quantity}</strong>

            <h6>Views:</h6><strong>${product.views}</strong> <br/>
            <a href="<c:url value="/cart/add/${product.pid}/product"/> " class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart">Add To Cart</span></a>
            <a href="<c:url value="/show/products"/> " class="btn btn-success">Back</a>

        </div>


    </div>


</div>

