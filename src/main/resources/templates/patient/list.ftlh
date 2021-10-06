<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Liste des patients</title>
</head>
<body>
    <h1>Liste des patients</h1>
    <table>
        <#list patients as patient>
            <tr>
                <td>${patient.id}</td>
                <td>${patient.surname}</td>
                <td>${patient.name}</td>
            </tr>
        </#list>
    </table>

    <#if sUser??>
    <div>${sUser.username}</div>
    </#if>

</body>
</html>