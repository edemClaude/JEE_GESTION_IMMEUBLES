<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <title>Gestion d'Immeubles | Connexion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body class="text-center">

<main class="form-signin w-25 m-auto mt-5">
    <div class="card mt-5">
        <div class="card-body">
            <h3 class="mt-4 mb-2">Veuillez vous connecter</h3>
            <form action="login.do" method="post">
                <c:if test="${error != null}">
                    <div class="alert alert-danger" role="alert">
                            ${error}
                    </div>
                </c:if>
                <div class="form-floating">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="username" required>
                    <label for="username">Nom d'utilisateur</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" name="password" id="floatingPassword" required
                           placeholder="Password">
                    <label for="floatingPassword">Mot de passe</label>
                </div>

                <a href="register.jsp" class="nav-item mt-3">Créer un compte</a>
                <button class="w-100 btn btn-lg btn-primary mt-3" type="submit">Se connecter</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017–2022</p>
            </form>
        </div>
    </div>
</main>

</body>
</html>
