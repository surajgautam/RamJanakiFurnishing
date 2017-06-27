<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 6/25/17
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p class="lead">RamJanaki Decoration</p>
<div class="list-group">
    <c:forEach items="${categories}" var="category">
        <a href="${site_url}/show/category/${category.cid}/products" class="list-group-item">${category.cname}</a>
    </c:forEach>
</div>
