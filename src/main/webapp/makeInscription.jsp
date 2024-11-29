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
    <title>Inscription - Panel</title>
    <style>
        body {background: #f1f1f1;}
    </style>
</head>
<body>
    <div class="entity-container">
        <div class="add-content">
            <div class="title">
                <h2>Faire une inscription</h2>
            </div>
            <form action="#" method="" id="register-form">
                <fieldset>
                    <legend>Inscription</legend>
                    <div class="form-group">
                        <label for="numEnf">Num de l'enfant à inscrire&nbsp;:</label>
                        <input type="number" name="numEnf" id="numEnf" step="1">
                    </div>
                    <div class="form-group">
                        <label for="numEmp">Num de l'employé qui inscrit&nbsp;:</label>
                        <input type="number" name="numEmp" id="numEmp" step="1">
                    </div>
                    <div class="form-group">
                        <label for="numEmpRes">Num de l'éducatrice responsable&nbsp;:</label>
                        <input type="number" name="numEmpRes" id="numEmpRes" step="1">
                    </div>
                </fieldset>
                <div class="form-button">
                    <button type="submit" class="btn">Inscrire</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>