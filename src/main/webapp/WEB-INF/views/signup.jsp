<%--
  Created by IntelliJ IDEA.
  User: surajgautam
  Date: 8/27/17
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" ng-controller="SignupFormValidationController as controller">
    <form name="signupform" action="${site_url}/signup" method="post">

        <div class="row">
            <div class="col-sm-offset-3 col-sm-6">
                <div class="form-group">
                    <label>UserName :</label>
                    <input ng-model="controller.userName" type="input" class="form-control" name="userName" placeholder="Enter your username"  ng-required="true" ng-minlength="6"/>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.userName.$error.required">This is a required field</span>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.userName.$error.minlength">Cannot be less than 6 characters</span>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.userName.$invalid">Invalid</span>

                </div>

                <div class="form-group">

                    <label>Email :</label>
                    <input ng-model="controller.email" type="text" class="form-control" name="email" placeholder="Enter your email" ng-pattern = '/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i' ng-required="true"/>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.email.$error.required">This is a required field</span>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.email.$error.pattern">Email Invalid</span>
                </div>


                <div class="form-group">

                    <label>Password :</label>
                    <input ng-model="controller.password" type="password" class="form-control" name="password" placeholder="Enter your password" ng-pattern="/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/" ng-required="true"/>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.password.$error.required">This is a required field</span>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.password.$error.pattern">Password should be atleast 8 characters long
                    and should contain one number,one character and one special
                    character</span>
                </div>

                <div class="form-group">

                    <label>Mobile Number :</label>
                    <input ng-model="controller.mobileNumber" type="number" class="form-control" name="mobileNumber" placeholder="Enter your phone number" ng-required="true" ng-pattern='/^(?=\d{10}$)(98)\d+/'/>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.mobileNumber.$error.required">This is a required field</span>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.mobileNumber.$error.pattern">Must be 10 digits starting with 98</span>
                </div>
                <div class="form-group">

                    <label>City :</label>
                    <input ng-model="controller.address" type="text" class="form-control" name="address" placeholder="Enter your city name" ng-required="true"/>
                    <span style="color: red;font-size: large" ng-show="signupform.$dirty && signupform.address.$error.required">This is a required field</span>

                </div>
                <input type="submit" ng-disabled ="signupform.$invalid" value="Signup" class="btn btn-primary" />
            </div>
        </div>
    </form>
</div>