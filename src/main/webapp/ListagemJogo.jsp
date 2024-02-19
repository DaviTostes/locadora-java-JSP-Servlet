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
        <link rel="stylesheet" type="text/css" href="./styles/lista.css">
        <link rel="icon" type="image/x-icon" href="./assets/icon.png">
    </head>

    <%
        String listaHTML = request.getParameter("lista");
    %>

    <body>
        <div class="tab_bar_container">
            <h1>Locadora de jogos</h1>
            <div class="buttonContainer">
                <a href="index.jsp">Inicio</a>
            </div>
            <div class="buttonContainer">
                <a href="FormularioJogo.jsp?acao=inclusao">Cadastrar jogo</a>
                <a href="JogoSrv?acao=listagem">Listar jogos</a>
            </div>
            <div class="buttonContainer">
                <a href="FormularioCliente.jsp?acao=inclusao">Cadastrar cliente</a>
                <a href="ClienteSrv?acao=listagem">Listar clientes</a>                
            </div>
            <div class="buttonContainer">
                <a href="FormularioEmprestimo.jsp?acao=inclusao">Fazer emprestimo</a>
                <a href="EmprestimoSrv?acao=listagem">Listar emprestimos</a>                 
            </div>
        </div>
        <div class="container">
            <h2>Jogos cadastrados</h2>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
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
        </div>
    </body>
</html>
