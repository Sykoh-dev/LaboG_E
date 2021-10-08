<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${springMacroRequestContext.contextPath}/css/styles.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
          crossorigin="anonymous">
    <title>Homepage</title>
</head>
<body>
    <h1>HOMEPAGE</h1>

    <div class="card">
        <div class="card-body">
            <a href="/patient/list">Liste des patients</a>
            <a href="/patient/create">Ajouter un patient</a>
            <a href="/patient/edit">Éditer un patient</a>
            <a href="/patient/delete">Supprimer un patient</a>
        </div>
    </div>


</body>
</html>
