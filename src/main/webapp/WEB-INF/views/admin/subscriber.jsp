<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 8/12/17
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty message}">


        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
                ${message}
        </div>

</c:if>


<div class="col-xs-9">
    <form method="post" action="${site_url}/admin/subscribe/send/mail">
    <table class="table table-responsive">
        <caption>Subscribers List</caption>
        <thead>
        <th>ID</th>
        <th>Email</th>
        <th>Status</th>
        <th>Check</th>
        </thead>
        <tbody>
        <c:forEach items="${subscribers}" var="subs">
            <tr>
            <td>${subs.sid}</td>
            <td>${subs.email}</td>
            <td>${subs.status}</td>
                <td><input class="form-control" value="${subs.email}" type="checkbox" name="emails"></td>
            </tr>
        </c:forEach>

        </tbody>

    </table>

        <div class="form-group">
            <input type="submit" class="btn-primary" value="Send NewsLetter" />
        </div>

    </form>
</div>
