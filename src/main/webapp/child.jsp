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
    <title>Panel - Enfants</title>
    <style>
        body {background: #f1f1f1;}
    </style>

</head>
<body>
    <div class="entity-container">
        <div class="table-content">
            <div class="table-title">
                <h2>Liste - Enfants</h2>
                <a href="./addChild.jsp" class="btn"><i class="bi bi-plus-circle-fill"></i></a>
            </div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Num</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Prenom</th>
                        <th scope="col">Age</th>
                        <th scope="col">Section</th>
                        <th scope="col">Parent</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var = "child" items = "${children}">
                    <tr>
                        <th scope="row">${child.numChild}</th>
                        <td>${child.childLastName}</td>
                        <td>${child.childFirstName}</td>
                        <td>${child.childAge}</td>
                        <td>${sections[child]}</td>
                        <td>${child.parent.parLastName} &nbsp; ${child.parent.parFirstName}</td>
                        <td>
                            <a href="editChild?numChild=${child.numChild}" class="bt"><i class="bi bi-pencil"></i></a>&nbsp;
                            <a href="deleteChild?numChild=${child.numChild}" class="bt"><i class="bi bi-trash"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>