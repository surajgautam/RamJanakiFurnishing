<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 7/7/17
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div class="row">


        <c:if test="${not empty message}">

            <div class="col-sm-offset-1 col-sm-7">
                <div class="alert alert-success alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${message}
                </div>
            </div>

        </c:if>



        <div class="col-sm-offset-1 col-sm-7">

            <div class="panel-primary">
                <div class="panel-heading">
                    <h4>Product Management</h4>
                </div>
                <div class="panel-body">
                    <forms:errors path="product.*" cssClass="errorText"/>
                    <form class="form-horizontal" method="post" action="${site_url}/admin/add/product" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>Product Name:</label>
                            <input type="text" class="form-control" placeholder="Enter Product Name" name="pname"/>
                        </div>

                        <div class="form-group">
                            <label>Product Description:</label>
                            <textarea class="form-control" name="description"
                                      placeholder="Enter description here"></textarea>
                        </div>

                        <div class="form-group">
                            <label>Product Price(Rs):</label>
                            <input type="number" class="form-control" placeholder="Enter Product Price" name="price" required/>
                        </div>

                        <div class="form-group">
                            <label>Product Quantity:</label>
                            <input type="number" class="form-control" placeholder="Enter Product Quantity"
                                   name="quantity" required/>
                        </div>

                        <div class="form-group">
                            <label>Product Image:</label>
                            <input type="file" class="form-control" placeholder="Enter Product Quantity" name="file" accept=".jpg,.jpeg,.png"/>
                        </div>

                        <div class="form-group">
                            <label>Select Category:</label>

                            <select class="form-control" name="category.cid">
                                <c:if test="${not empty categories}">
                                    <c:forEach items="${categories}" var="cat">
                                        <option value="${cat.cid}">${cat.cname}</option>
                                    </c:forEach>
                                </c:if>



                            </select>
                        </div>

                        <div class="form-group">
                            <label>Product Status:</label>
                            <input type="radio" name="active" value="true"/> Enable
                            <input type="radio" name="active" value="false" checked="checked"/> Disable
                        </div>


                        <button type="submit" class="btn btn-success">Save</button>
                        <a class="btn btn-success" href="${site_url}/admin/products">Back</a>


                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
