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
        <title>Listagem de jogos</title>
    </head>

    <%
        String listaHTML = request.getParameter("lista");
    %>

    <body>
        <br>
        <br>
    <center>
        <table border="0">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=listaHTML%>
            </tbody>
        </table>
    </center>
</body>
</html>
