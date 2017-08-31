<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/24/17
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty message}">

    <div class="col-sm-offset-1 col-sm-7">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
                ${message}
        </div>
    </div>

</c:if>
<div class="container">
<form action="${site_url}/login" method="post">

    <div class="row">
        <div class="col-sm-offset-3 col-sm-6">
            <div class="form-group">
                <label>Username :</label>
                <input type="input" class="form-control" name="userName" placeholder="Enter your username" />

            </div>

            <div class="form-group">

                <label>Password :</label>
                <input type="password" class="form-control" name="password" placeholder="Enter your password" />
            </div>


            <div class="g-recaptcha" data-sitekey="6LcjVS4UAAAAAAXoP4QwtTIr1PX3hMfXQVXBu66W"></div>


            <input type="submit" class="btn btn-primary" value="Login"/>

            <a href="${site_url}/signup" class="btn btn-primary">Don't have an account?</a>

            <%--<button class="btn btn-primary"><a href="${site_url}/signup">Signup</a></button>--%>
        </div>
    </div>
</form>
</div>




