<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Register</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    <link href="<c:url value="/css/login_register.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="login-form">
        <form action="/examples/actions/confirmation.php" method="post">
            <h2 class="text-center"><tag:message code="register"></tag:message></h2>
            <div class="form-group has-error">
                <input type="text" class="form-control" name="name" placeholder="<tag:message code="name"></tag:message>" required="required">
            </div>
            <div class="form-group has-error">
                <input type="email" class="form-control" name="email" placeholder="<tag:message code="email"></tag:message>" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="<tag:message code="password"></tag:message>" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="passwordConfirm" placeholder="<tag:message code="confirm"></tag:message> <tag:message code="password"></tag:message>" 
                	required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-lg btn-block"><tag:message code="register"></tag:message></button>
            </div>
        </form>
        <p class="text-center small"><tag:message code="haveAccount"></tag:message> <a href="#"><tag:message code="login"></tag:message></a></p>
    </div>
</body>
</html>