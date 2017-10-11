<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 20/9/17
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="col-md-offset-3 col-md-offset-6">
        <form method="post" action="${pageContext.request.contextPath}/verify/user">
        <div class="form-group">
            <label>Enter Verification Code:</label>
            <input type="text" name="code" class="form-control" />
        </div>
            <input type="submit" class="btn btn-primary" value="Verify"/>
        </form>
    </div>

</div>