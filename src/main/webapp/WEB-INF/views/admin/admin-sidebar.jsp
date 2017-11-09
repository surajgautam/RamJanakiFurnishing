<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 7/4/17
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="site_url" value="${pageContext.request.contextPath}"/>
<div class="list-group">
    <a href="${site_url}/admin/categories" class="list-group-item">Categories</a>
    <a href="${site_url}/admin/products" class="list-group-item">Products</a>
<%--    <a href="${site_url}/admin/slider" class="list-group-item">Slider</a>--%>
    <a href="${site_url}/admin/get/subscribers" class="list-group-item">Subscribers</a>
    <a href="${site_url}/admin/export/report" class="list-group-item">Report</a>
    <%--<a href="#" class="list-group-item">Reviews</a>
    <a href="#" class="list-group-item">Bar Diagram</a>
    <a href="#" class="list-group-item">Pie chart</a>
    <a href="#" class="list-group-item">Histogram</a>
    <a href="#" class="list-group-item">Transactions</a>--%>
</div>
