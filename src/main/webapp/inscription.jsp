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
    <title>Inscription - Panel</title>
</head>
<body>
    <div class="entity-container">
        <div class="table-content">
            <div class="table-title">
                <h2>Inscriptions</h2>
                <a href="#" class="btn">Nouveau</a>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Num Enfant</th>
                        <th scope="col">Num Employe</th>
                        <th scope="col">Date Insc.</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <th scope="row">1</th>
                        <td>2024-01-01</td>
                        <td>
                            <a href="#"><i class="bi bi-trash"></i></a>&nbsp;
                            <a href="#"><i class="bi bi-pencil"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <th scope="row">1</th>
                        <td>2024-01-01</td>
                        <td>
                            <a href="#"><i class="bi bi-trash"></i></a>&nbsp;
                            <a href="#"><i class="bi bi-pencil"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <th scope="row">1</th>
                        <td>2024-01-01</td>
                        <td>
                            <a href="#"><i class="bi bi-trash"></i></a>&nbsp;
                            <a href="#"><i class="bi bi-pencil"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <th scope="row">1</th>
                        <td>2024-01-01</td>
                        <td>
                            <a href="#"><i class="bi bi-trash"></i></a>&nbsp;
                            <a href="#"><i class="bi bi-pencil"></i></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
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
                        <label for="numEmp">Num de l'employé responsable&nbsp;:</label>
                        <input type="number" name="numEmp" id="numEmp" step="1">
                    </div>
                </fieldset>
                <div class="form-button">
                    <button type="submit" class="btn">Inscrire</button>
                    <button type="reset" class="btn">Réinitiliser le formulaire</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>