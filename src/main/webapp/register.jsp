<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <title>Gestion d'Immeubles | Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

<main class="form-signin w-25 m-auto mt-5">
    <div class="card mt-5">
        <div class="card-body">
            <h3 class="mt-4 mb-2">Formulaire d'inscription</h3>
            <form action="register.do" method="post">
                <c:if test="${error != null}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:if>
                <div class="form-group row">
                    <div class="form-group mb-2 col-md-6">
                        <label for="first_name" class="form-label">Prenom</label>
                        <input type="text" id="first_name" class="form-control" name="first_name" required/>
                    </div>
                    <div class="form-group mb-2 col-md-6">
                        <label for="last_name" class="form-label">Nom</label>
                        <input type="text" id="last_name" name="last_name" class="form-control" required/>
                    </div>
                </div>
                <div class="form-group mb-2">
                    <label for="username" class="form-label">Nom d'utilisateur</label>
                    <input type="text" id="username" name="username" class="form-control" required/>
                </div>
                <div class="fom-group row">
                    <div class="form-group mb-2 col-md-6">
                        <label for="password" class="form-label">Mot de passe</label>
                        <input type="password" id="password" class="form-control" name="password" required/>
                    </div>
                    <div class="form-group mb-2 col-md-6">
                        <label for="confirm-password" class="form-label">Confirmer le mot de passe</label>
                        <input type="password" id="confirm-password" name="confirm_password" class="form-control" required/>
                    </div>
                </div>
                <div class="form-group mb-2">
                    <label for="address" class="form-label">Adresse</label>
                    <input type="text" id="address" name="address" class="form-control" required/>
                </div>
                <div class="form-group mb-2">
                    <label for="phone_number" class="form-label">Telephone</label>
                    <input type="text" id="phone_number" name="phone_number" class="form-control" required/>
                </div>
                <div class="btn-group">
                    <button type="submit" name="save" class="btn btn-primary">Ajouter</button>
                    <button type="reset" class="btn btn-danger">Annuler</button>
                </div>
            </form>
        </div>
    </div>
</main>

</body>
</html>
