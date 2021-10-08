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

    <h1>Liste des patients</h1>
    <table>
        <#list patients as patient>
            <tr>
                <td>${patient.id}</td>
                <td>${patient.surname}</td>
                <td>${patient.name}</td>
                <td><button type="button" class="btn btn-primary">Éditer</button></td>
                <td><button type="button" class="btn btn-danger">Supprimer</button></td>
            </tr>
        </#list>
    </table>


</body>
</html>