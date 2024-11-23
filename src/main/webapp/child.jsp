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
    <title>Panel - Enfant</title>

</head>
<body>
    <div class="entity-container">
        <div class="table-content">
            <div class="table-title">
                <h2>Liste - Enfants</h2>
                <a href="#" class="btn">Nouvel enfant</a>
            </div>
            <table class="table table-striped">
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
                    <tr>
                        <th scope="row">1</th>
                        <td>Jones</td>
                        <td>Gaby</td>
                        <td>2</td>
                        <td>Petite Section</td>
                        <td>Parent1</td>
                        <td>
                            <a href="#"><i class="bi bi-trash"></i></a>&nbsp;
                            <a href="#"><i class="bi bi-pencil"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>Jones</td>
                        <td>Gaby</td>
                        <td>2</td>
                        <td>Petite Section</td>
                        <td>Parent1</td>
                        <td>
                            <a href="#"><i class="bi bi-trash"></i></a>&nbsp;
                            <a href="#"><i class="bi bi-pencil"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>Jones</td>
                        <td>Gaby</td>
                        <td>2</td>
                        <td>Petite Section</td>
                        <td>Parent1</td>
                        <td>
                            <a href="#"><i class="bi bi-trash"></i></a>&nbsp;
                            <a href="#"><i class="bi bi-pencil"></i></a>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">1</th>
                        <td>Jones</td>
                        <td>Gaby</td>
                        <td>2</td>
                        <td>Petite Section</td>
                        <td>Parent1</td>
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
                <h2>Ajouter un enfant et son parent</h2>
            </div>
            <form action="#" method="" id="kid-content">
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
                        <input type="number" name="age" id="age" step="1">
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Informations du parent</legend>

                    <div class="form-group">
                        <label for="lastNameP">Nom :</label>
                        <input type="text" name="lastNameP" id="lastNameP">
                    </div>

                    <div class="form-group">
                        <label for="firstNameP">Prénom :</label>
                        <input type="text" name="firstNameP" id="firstNameP">
                    </div>

                    <div class="form-group">
                        <label for="contact">Telephone :</label>
                        <input type="number" name="contact" id="contact" step="1">
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