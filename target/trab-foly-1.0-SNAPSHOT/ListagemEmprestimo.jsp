<%-- 
    Document   : index
    Created on : 3 Feb 2024, 17:53:29
    Author     : davitostes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de emprestimo</title>
        <link rel="stylesheet" type="text/css" href="./styles/lista.css">
    </head>

    <%
        String listaHTML = request.getParameter("lista");
    %>

    <body>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Cliente</th>
                    <th>Jogo</th>
                    <th>Data de emprestimo</th>
                    <th>Data de devolução</th>
                    <th>Situação</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=listaHTML%>
            </tbody>
        </table>
</body>
</html>
