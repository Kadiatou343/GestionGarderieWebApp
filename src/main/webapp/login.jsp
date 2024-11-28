<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <tittle>Login</tittle>
        <link rel="StyleSheet" type="text/css" href="./static/css/loginStyle.css">
        <link href="https://fonts.googleapis.com/css2?family=Jost:wght@500&display=swap" rel="Style">
    </head>

    <body>

        <div class="main">
            <div class="login">
                <form>
                    <label>Login</label>
                    <input type="text"  name="username" placeholder="Username" required="">
                    <input type="Password"  name="pass" placeholder="Password" required="">
                    <button type="submit">Login</button>
                </form>
            </div>


        </div>

    </body>


</html>