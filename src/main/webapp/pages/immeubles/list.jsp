<%--
  Created by IntelliJ IDEA.
  User: Claude
  Date: 6/26/2024
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Gestion Immeubles | Accueil</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/navbar-fixed/">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/navbar-top-fixed.css" rel="stylesheet">
</head>
<body>

<%@include file="navbar.jsp"%>
<main class="container">

    <h1 class="mt-3">Accueil</h1>
    <p class="lead">Cette page affiche la liste des Immeubles</p>
    <c:if test="${error != null}">
        <div class="alert alert-danger" role="alert">
                ${error}
        </div>
    </c:if>

    <div class="card mb-5">
        <div class="card-header">
            <div class="d-flex justify-content-between align-items-center">
                <h5 class="card-title">Lites de tous les immeubles</h5>
                <a href="immeubles?action=add" class="btn btn-primary float-end">Ajouter un immeuble +</a>
            </div>
        </div>
        <div class="card-body">
            <table class="table table-borderless">
                <caption></caption>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Adresse</th>
                    <th>Ville</th>
                    <th>Equipement</th>
                    <th>Description</th>
                    <th>Propriétaire</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${immeubles}" var="i">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.name}</td>
                        <td>${i.address}</td>
                        <td>${i.city}</td>
                        <td>${i.equipments}</td>
                        <td>${i.description}</td>
                        <td>${i.owner.lastName}</td>
                        <td>
                            <a href="immeubles?action=edit&id=${i.id}" class="btn btn-primary">Modifier</a>
                            <a href="immeubles?action=delete&id=${i.id}" class="btn btn-danger">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <hr/>
        </div>
    </div>

</main>


<script src="../../js/bootstrap.bundle.min.js"></script>


</body>
</html>

