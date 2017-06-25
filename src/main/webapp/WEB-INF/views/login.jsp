<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/24/17
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Click To Call</h1>

    <p>Click To Call converts your website's users into engaged customers by creating an easy way
        for your customers to contact your sales and support teams right on your website.</p>

    <p>Here's an example of how it's done!</p>
    <hr />
    <div class="row">
        <div class="col-md-12">
            <form id="contactform" role="form" action="#" method="POST">
                <div class="form-group">
                    <h3>Call Sales</h3>

                    <p class="help-block">
                        Are you interested in impressing your friends and confounding your enemies?
                        Enter your phone number below, and our team will contact you right away.
                    </p>
                </div>
                <label>Your number</label>
                <div class="form-group">
                    <input class="form-control" type="text" name="userPhone" id="userPhone"
                           placeholder="(651) 555-7889"/>
                </div>
                <label>Sales team number</label>
                <div class="form-group">
                    <input class="form-control" type="text" name="salesPhone" id="salesPhone"
                           placeholder="(651) 555-7889"/>
                </div>
                <button type="submit" class="btn btn-default">Contact Sales</button>
            </form>

        </div>
    </div>
</div>
<!-- /page -->
</body>
<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="/resources/intl-phone/js/intlTelInput.js" data-turbolinks-track="true"></script>
<script src="/resources/intl-phone/libphonenumber/build/utils.js" data-turbolinks-track="true"></script>
<script src="/resources/js/clicktocall.js" data-turbolinks-track="true"></script>
</html>
</body>
</html>
