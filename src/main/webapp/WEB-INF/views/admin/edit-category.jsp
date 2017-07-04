<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 7/4/17
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class=form-horizontal action="${site_url}/admin/edit/category" method="post">
    <div class="form-group">
        <label>Id :</label>
        <input type="text" class="form-control" name="cid" value="${category.cid}" readonly>
    </div>
    <div class="form-group">
        <label>Status :</label> <br/>

        <%--setting radio button as per database--%>
        <c:if test="${category.active == true}">
            <input type="radio" name="active" value="true" checked="checked" /> Enable
            <input type="radio" name="active" value="false"/> Disable
        </c:if>
        <c:if test="${category.active == false}">
            <input type="radio" name="active" value="true"  /> Enable
            <input type="radio" name="active" value="false" checked="checked"/> Disable
        </c:if>

    </div>
    <div class="form-group">
        <label>Name :</label>
        <input type="text" class="form-control" name="cname" value="${category.cname}">
    </div>


        <button type="submit" class="btn btn-success">Save</button>
        <a class="btn btn-success" href="${site_url}/admin/categories">Back</a>
</form>
