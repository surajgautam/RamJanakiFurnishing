<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 31/8/17
  Time: 11:41 PM
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
