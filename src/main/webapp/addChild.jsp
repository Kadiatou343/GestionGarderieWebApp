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
    <title>Panel - Enfant</title>
    <style>
        body {background: #f1f1f1;}
    </style>
</head>
<body>
    <div class="entity-container">
        <div class="add-content">
            <div class="title">
                <h2>Ajouter un enfant et son parent</h2>
            </div>
            <form action="addChild" method="post" id="kid-content">
                <fieldset>
                    <legend>Informations de l'enfant</legend>
                    <!-- Le num de l'enfant pourra etre genere par la base de donnnees donc pas de input Num-->

                    <div class="form-group">
                        <label for="last_name">Nom :</label>
                        <input type="text" name="lastNameE" id="lastNameE">
                    </div>

                    <div class="form-group">
                        <label for="firstName">Prénom :</label>
                        <input type="text" name="firstNameE" id="firstNameE">
                    </div>

                    <div class="form-group">
                        <label for="age">Age :</label>
                        <input type="number" name="age" id="age" step="1" max="7">
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Informations du parent</legend>

                    <div class="form-group">
                        <label for="numPar">Id :</label>
                        <input type="number" name="numPar" id="numPar" step="1">
                    </div>

                    <div class="form-group" id="nom">
                        <label for="lastNameP">Nom :</label>
                        <input type="text" name="lastNameP" id="lastNameP">
                    </div>

                    <div class="form-group" id="pren">
                        <label for="firstNameP">Prénom :</label>
                        <input type="text" name="firstNameP" id="firstNameP">
                    </div>

                    <div class="form-group" id="tel">
                        <label for="contact">Telephone :</label>
                        <input type="text" name="contact" id="contact">
                    </div>
                </fieldset>
                <div class="form-button">
                    <button type="submit" class="btn">Ajouter</button>
                    <button type="reset" class="btn">Reinitiliser le formulaire</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>