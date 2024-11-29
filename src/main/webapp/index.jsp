<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Login</title>
        <link rel="StyleSheet" type="text/css" href="./static/css/loginStyle.css">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="Style">
        <style>
            .message  {
                text-align: center;
                color: red;
                font-weight: bold;
            }
        </style>
    </head>

    <body>

        <div class="main">
            <div class="login">
                <form action="login" method="post">
                    <label>Login</label>
                    <input type="number"  name="numEmp" placeholder="Num Employé" required step="1">
                    <input type="Password"  name="password" placeholder="Mot de passe" required>
                    <button type="submit">Se connecter</button>
                </form>
            </div>
            <p class="message"> <c:out value="${message}" /> </p>

        </div>

    </body>


</html>