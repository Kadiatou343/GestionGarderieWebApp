<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./static/css/styles.css">
    <title>Panel principal</title>
</head>
<body>
    <div class="side-menu">
        <div class="brand-name">
            <h1><i>ChouChou</i></h1>
        </div>
        <ul>
            <li><a href="index.jsp"><img src="./static/icons/dashboard (3).png" alt="">&nbsp; <span>Dashboard</span> </a></li>
            <li><a href="child.jsp" target="contentFrame"><img src="./static/icons/baby-30.png" alt="">&nbsp;<span>Enfants</span> </a></li>
            <li><a href="parent.jsp" target="contentFrame"><img src="./static/icons/parent.png" alt="">&nbsp;<span>Parents</span> </a></li>
            <li><a href="inscription.jsp" target="contentFrame"><img src="./static/icons/inscription.png" alt="">&nbsp;<span>Inscription</span> </a></li>
            <li><a href="employee.jsp" target="contentFrame"><img src="./static/icons/employe.png" alt="">&nbsp;<span>Employés</span> </a></li>
            <li><a href="apropos.jsp" target="contentFrame"><img src="./static/icons/help-web-button.png" alt="">&nbsp; <span>A propos</span> </a></li>
        </ul>
    </div>
    <div class="container">
        <div class="header">
            <div class="nav">
                <div class="search">
                    <input type="text" placeholder="Search..">
                    <button type="submit"><img src="./static/icons/search.png" alt=""></button>
                </div>
                <div class="user">
                    <a href="#" class="btn">Add New</a>
                    <img src="./static/icons/notifications.png" alt="">
                    <div class="img-case">
                        <img src="./static/icons/user.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <div class="card-content">
            <div class="cards">
                <div class="card">
                    <div class="box">
                        <h1>25</h1>
                        <h3>Enfants</h3>
                    </div>
                    <div class="icon-case">
                        <img src="icons/inscription.png" alt="">
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1>45</h1>
                        <h3>Employes</h3>
                    </div>
                    <div class="icon-case">
                        <img src="icons/employes-case.png" alt="">
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1>1</h1>
                        <h3>Garderie</h3>
                    </div>
                    <div class="icon-case">
                        <img src="icons/bear.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <div class="main-content">
            <iframe name="contentFrame" src="child.jsp"></iframe>
        </div>
    </div>

</body>
</html>