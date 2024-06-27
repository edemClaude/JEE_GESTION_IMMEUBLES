<%--
  Created by IntelliJ IDEA.
  User: Claude
  Date: 6/27/2024
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <title>Gestion d'Immeubles | Ajout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


    <!-- Custom styles for this template -->
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="navbar.jsp"%>
<section class="container mt-5">
        <div class="row align-items-center justify-content-between">
            <div class="col-md-6">
                <h1> Ajouter Une Immeuble </h1>
                <p class="lead"> Cette page vous permet d'ajouter une immeuble </p>
            </div>
            <div class="col-md-6">
                <div class="btn-group float-end">
                    <a href="immeubles?action=list" class="btn btn-sm btn-secondary">
                        <i class="fa fa-arrow-left"></i> Retour</a>
                </div>
            </div>
        </div>
        <hr/>
        <div class="card col-md-6 my-4">
            <div class="card-header">
                Ajouter un immeuble
            </div>
            <c:if test="${error != null}">
                <div class="alert alert-danger" role="alert">
                        ${error}
                </div>
            </c:if>
            <div class="card-body">
                <form action="immeubles?action=store" method="POST" class="needs-validation" novalidate >
                    <div class="form-group mb-2">
                        <label for="name" class="form-label">Nom de l'immeuble</label>
                        <input class="form-control" id="name" name="name" required type="text">
                    </div>
                    <div class="form-group mb-2">
                        <label for="address" class="form-label">Adresse</label>
                        <input class="form-control" id="address" name="address" required type="text">
                    </div>
                    <div class="form-group mb-2">
                        <label for="city" class="form-label">Ville</label>
                        <input class="form-control" id="city" name="city" required type="text">
                    </div>
                    <div class="form-group mb-2">
                        <label for="description" class="form-label">Description</label>
                        <textarea class="form-control" id="description" name="description" required></textarea>
                    </div>
                    <div class="form-group mb-2">
                        <label for="equipments" class="form-label">Equipements</label>
                        <select name="equipments" id="equipments" class="form-control">
                            <option value="" disabled>Choisir un equipement</option>
                            <option value="Tout equipe">Tout équipé</option>
                            <option value="Sans equipement">Sans équipement</option>
                            <option value="Piscine">Avec Piscine</option>
                            <option value="Sauna">Avec Sauna</option>
                        </select>
                    </div>
                    <div class="form-group mb-2">
                        <label for="owner" class="form-label">Propriétaire</label>
                        <select name="owner_id" id="owner" class="form-control">
                            <option value="" disabled>Choisir le propriétiare</option>
                            <c:forEach items="${owners}" var="o">
                                <option value="${o.id}">${o.firstName} ${o.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">
                        Ajouter Immeuble
                    </button>
                </form>
            </div>
        </div>
    </main>
</section>
</body>
</html>
