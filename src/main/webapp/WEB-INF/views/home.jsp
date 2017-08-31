<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/23/17
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">

    <div class="row">

        <div class="col-md-3">
            <br/>
            <%@include file="common/sidebar.jsp"%>
        </div>

        <div class="col-md-9">

            <div class="row carousel-holder">

                <div class="col-md-12">
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img class="slide-image" src="<c:url value="/resources/images/slider.jpg" />" alt="slider 1">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="<c:url value="/resources/images/slider2.jpg" />" alt="slider 2">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="<c:url value="/resources/images/slider3.jpg" />" alt="slider 3">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="<c:url value="/resources/images/slider4.jpg" />" alt="slider 4">
                            </div>
                            <div class="item">
                                <img class="slide-image" src="<c:url value="/resources/images/slider5.jpg" />" alt="slider 4">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>

            </div>

            <div class="row">

                <c:forEach items="${products}" var="product">

                <div class="col-sm-4 col-lg-4 col-md-4">
                    <div class="thumbnail">
                        <a href="${site_url}/show/${product.pid}/product">
                        <div class="img-responsive">
                        <img src="<c:url value="${product.image}" />" alt="${product.pname}" width="100" height="100"/>
                        </div>
                        </a>
                            <div class="caption">
                            <h6>${product.pname}</h6>
                                Price(Rs) : ${product.price}
                        </div>
                        <div class="ratings">
                            <p class="pull-right">15 reviews</p>
                            <p>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                            </p>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>

        </div>

    </div>

</div>