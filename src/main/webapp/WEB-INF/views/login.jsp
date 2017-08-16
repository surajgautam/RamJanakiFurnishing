<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/24/17
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
<form action="" method="post">

    <div class="row">
        <div class="col-sm-offset-3 col-sm-6">
            <div class="form-group">
                <label>Username :</label>
                <input type="input" class="form-control" name="username" placeholder="Enter your username" />

            </div>

            <div class="form-group">

                <label>Password :</label>
                <input type="password" class="form-control" name="password" placeholder="Enter your password" />
            </div>


            <div class="g-recaptcha" data-sitekey="6LetWygUAAAAAJwUFW3hR8TpNCBp26hn27WTbrig"></div>

            <button type="button" class="btn btn-primary">Login</button>
        </div>
    </div>
</form>
</div>




