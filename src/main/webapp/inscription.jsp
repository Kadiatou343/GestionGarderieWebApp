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
    <title>Inscription - Panel</title>
    <style>
        body {background: #f1f1f1;}
        .bt {
            background: #32435F;
            color: white;
            padding: 5px 10px;
            text-align: center;
        }

        .bt:hover {
            color: #32435F;
            background: white;
            padding: 3px 8px;
            border: 2px solid ;
        }
    </style>
</head>
<body>
    <div class="entity-container">
        <div class="table-content">
            <div class="table-title">
                <h2>Inscriptions</h2>
                <a href="./makeInscription.jsp" class="btn"><i class="bi bi-plus-circle-fill"></i></a>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Enfant inscrit</th>
                        <th scope="col">Employé responsable</th>
                        <th scope="col">Date Inscription</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var = "insc" items = "${inscriptions}" >
                    <tr>
                        <td>${insc.child.childLastName} &nbsp; ${insc.child.childFirstName}</td>
                        <td>${insc.employee.empLastName} &nbsp; ${insc.employee.empFirstName}</td>
                        <td>${insc.inscriptionDate}</td>
                        <td>
                            <a href="deleteInscri?numEmp=${insc.employee.numEmp}&numChild=${insc.child.numChild}" class="bt"><i class="bi bi-trash"></i></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>