<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/styles.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
          crossorigin="anonymous">
    <title>Liste des patients</title>
</head>
<body>
    <a href="/">Retour</a>

    <h1>Ajouter un patient</h1>
    <form method="post" action="/patient/create">


        <div class="mb-3">
            <label for="surname" class="form-label">Prénom</label>
            <input name="surname" type="text" class="form-control" id="surname" aria-describedby="surname">
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Nom</label>
            <input name="name" type="text" class="form-control" id="name" aria-describedby="name">
        </div>
        <div class="mb-3">
            <label for="adress" class="form-label">Adresse</label>
            <input name="adress" type="text" class="form-control" id="adress" aria-describedby="adress">
        </div>
        <div class="mb-3">
            <label for="mail" class="form-label">Email</label>
            <input name="mail" type="email" class="form-control" id="mail" aria-describedby="mail">
        </div>
        <div class="mb-3">
            <label for="dateOfBirth" class="form-label">Date de naissance</label>
            <input name="dateOfBirth" type="text" class="form-control" id="dateOfBirth" aria-describedby="dateOfBirth">
        </div>


        <button type="submit" class="btn btn-primary">Ajouter le patient</button>
    </form>



</body>
</html>