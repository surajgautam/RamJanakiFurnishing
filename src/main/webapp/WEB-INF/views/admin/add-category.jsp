<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 7/4/17
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="${site_url}/admin/add/category/" method="post">

    <div class="form-group">
        <label><strong>Category Name :</strong></label><br/>
        <input class="form-control" type="text" name="cname"/>

    </div>

    <div class="form-group">
        <label><strong>Category Status :</strong></label>
        <input type="radio" name="active" value="true"/>Enable
        <input type="radio" name="active" value="false"/>Disable
    </div>


    <button type="submit" class="btn btn-success">Add</button>
    <a class="btn btn-success" href="${site_url}/admin/categories">Back</a>
</form>
