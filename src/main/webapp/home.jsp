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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Parkinsans&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./static/css/styles.css">
    <link rel="stylesheet" href="./static/css/newStyle.css">
    <title>Panel principal</title>
    <style>
            body {background: #f1f1f1;}
    </style>
</head>
<body>
    <div class="side-menu">
        <div class="brand-name">
            <h1><i>ChouChou</i></h1>
        </div>
        <ul>
            <li><a href="home"><img src="./static/icons/dashboard (3).png" alt="">&nbsp; <span>Dashboard</span> </a></li>
            <li><a href="children" target="contentFrame"><img src="./static/icons/baby-30.png" alt="">&nbsp;<span>Enfants</span> </a></li>
            <li><a href="parent.jsp" target="contentFrame"><img src="./static/icons/parent.png" alt="">&nbsp;<span>Parents</span> </a></li>
            <li><a href="voirInscri" target="contentFrame"><img src="./static/icons/inscription.png" alt="">&nbsp;<span>Inscription</span> </a></li>
            <li><a href="employee.jsp" target="contentFrame"><img src="./static/icons/employe.png" alt="">&nbsp;<span>Employés</span> </a></li>
            <li><a href="apropos.jsp" target="contentFrame"><img src="./static/icons/help-web-button.png" alt="">&nbsp; <span>A propos</span> </a></li>
        </ul>
    </div>
    <div class="container">
        <div class="header">
            <div class="nav">
                <div class="search">
                    <h3>Bonjour ${param.emp}</h3>
                </div>
                <div class="user">
                    <a href="./makeInscription.jsp" class="btn">Nouvel enfant</a>
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
                        <h1><c:out value="${count}" /></h1>
                        <h3>Enfants</h3>
                    </div>
                    <div class="icon-case">
                        <img src="icons/inscription.png" alt="">
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1><c:out value="${empCount}" /></h1>
                        <h3>Employés</h3>
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
            <iframe name="contentFrame" src="children"></iframe>
        </div>
    </div>

</body>
</html>