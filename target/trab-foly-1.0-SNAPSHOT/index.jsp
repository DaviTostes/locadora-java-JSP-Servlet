<%-- 
    Document   : index
    Created on : 29 Jan 2024, 21:14:50
    Author     : davitostes
--%>

<%@page import="java.util.List"%>
<%@page import="model.Jogo"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="model.dao.InterfaceDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%
        String mensagem = request.getParameter("mensagem");
    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
        <link rel="stylesheet" type="text/css" href="./styles/index.css">
    </head>
    <body>
        <div class="container">
            <h1>Locadora de jogos</h1>
            <div class="buttonContainer">
                <a href="FormularioJogo.jsp?acao=inclusao">Cadastrar jogo</a>
                <a href="JogoSrv?acao=listagem">Listar jogos</a>
            </div>
            <div class="buttonContainer">
                <a href="FormularioCliente.jsp?acao=inclusao">Cadastrar cliente</a>
                <a href="ClienteSrv?acao=listagem">Listar clientes</a>                
            </div>
            <div class="buttonContainer">
                <a href="FormularioEmprestimo.jsp?acao=inclusao">Criar emprestimo</a>
                <a href="EmprestimoSrv?acao=listagem">Listar emprestimos</a>                 
            </div>
        </div>
        <script>
            let mensagem = <%=mensagem%>; 
            if(mensagem) alert(mensagem);
        </script>
    </body>
</html>
