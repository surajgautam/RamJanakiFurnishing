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

<html lang="en" ng-app="RamJanakiApp">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <script src="<c:url value="/resources/lib/angular-min.js"/>"></script>

    <script>
        window.menu = '${title}';
        window.siteURL='${site_url}';
    </script>
    <script src='https://www.google.com/recaptcha/api.js'></script>

    <link rel="icon" href="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAMNmunnnY1G90k5bCoPuxdb7SLgQfZE3mc-QdkkxvGRM6bLKZeV2fdQ"/>
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
<!-- for subscribe-->


<c:if test="${not empty subscribeMessage}">
        <div class="alert alert-success alert-dismissable" id="subscibe-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            ${subscribeMessage}
    </div>
</c:if>


<div class="wrapper">
    <!-- Navigation -->
    <%@ include file="./common/navbar.jsp" %>

    <div class="content">

        <!-- Page Content -->
        <c:if test="${userHome == true}">
            <%@include file="home.jsp" %>
        </c:if>
        <!-- /.container -->


        <!-- /.container -->
        <c:if test="${userAbout == true}">
            <%@ include file="about.jsp" %>
        </c:if>


        <c:if test="${userContact==true}">
            <%@ include file="contact.jsp" %>
        </c:if>

        <c:if test="${userLogin==true}">
            <%@ include file="login.jsp" %>
        </c:if>

        <c:if test="${userSingleProduct==true or userAllProducts==true}">
            <%@ include file="products.jsp" %>
        </c:if>

        <c:if test="${userProductDetail == true}">
            <%@ include file="details.jsp" %>
        </c:if>

        <c:if test="${userErrorStatus == true}">
            <%@ include file="errorpage.jsp" %>
        </c:if>

        <c:if test="${esewaTest ==true}">
            <%@include file="esewatest.jsp"%>
        </c:if>

        <c:if test="${userSignup == true}">
            <%@ include file="signup.jsp" %>
        </c:if>

        <c:if test="${payment == true}">
            <%@include file="payment.jsp"%>
        </c:if>

        <c:if test="${signupSuccessful == true}">
            <%@include file="login.jsp"%>
        </c:if>
        


        <c:if test="${userHome == true}">
        <center>
            <form action="${site_url}/subscribe/newsletter" method="post">
                <div class="form-group">
                    <forms:errors path="email" cssClass="errorText"/>
                    <input type="email" id="email" name="email" placeholder="Enter your email" required/>
                    <input type="submit" id="subscribeBtn" class="btn btn-primary" value="Subscribe"/>
                </div>
            </form>
        </center>
        </c:if>

    </div>


        <hr>

        <!-- Footer -->
        <%@include file="./common/footer.jsp" %>


    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <!--Data Table-->
    <script src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>

    <!--Data Table js -->
    <script src="<c:url value="/resources/js/dataTables.bootstrap.js" />"></script>

    <%--<!--Recaptcha js -->
    <script src = "<c:url value="/resources/js/recaptcha.js" />"></script>--%>

    <!--Custom js -->
    <script src = "<c:url value="/resources/js/custom.js" />"></script>

    <script src="<c:url value="/resources/app.js" />"> </script>
    <script src="<c:url value="/resources/controllers/signupformvalidationcontroller.js" />"> </script>
    <script src="<c:url value="/resources/services/signupservice.js" />"> </script>

<%--

    <script>

        //jqeury ajax call for subscribe newsletter
        $(document).ready(function(){

            $('#subscribeBtn').click(function(){

                var email = $('#email').val();
                $.ajax({
                   url: '${site_url}/subscribe/newsletter',
                    method:'POST',
                    contentType:"application/json",
                    data: JSON.stringify(email)
                }).done(function (data) {
                    $('#subscibe-success').show();
                    setTimeout(function(){
                        $('#subscibe-success').hide();
                    },5000);
                });

                console.log("Clicked")
            });


        });

    </script>
--%>



</div>

</body>

</html>

