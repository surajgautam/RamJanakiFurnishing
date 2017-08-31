<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 7/7/17
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="http://dev.esewa.com.np/epay/main" method="POST">
    <input value="100" name="tAmt" type="hidden">
    <input value="90" name="amt" type="hidden">
    <input value="5" name="txAmt" type="hidden">
    <input value="2" name="psc" type="hidden">
    <input value="3" name="pdc" type="hidden">
    <input value="college_test" name="scd" type="hidden">
    <input value="XYZ-1234" name="pid" type="hidden">
    <input value="http://localhost:8080/ecommerce/payment?action=su" type="hidden" name="su">
    <input value="http://localhost:8080/ecommerce/payment?action=fu" type="hidden" name="fu">
    <input value="Submit" type="submit">
</form>
