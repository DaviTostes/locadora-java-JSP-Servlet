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
        <link rel="icon" type="image/x-icon" href="./assets/icon.png">
    </head>
    <body>
        <div class="tab_bar_container">
            <h1 href="index.jsp">Locadora de jogos</h1>
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

        <div class="conteudo">
            <h1>Seja Bem-Vindo à Locadora Game-Over!</h1>
        </div>

        <script>
            let mensagem = <%=mensagem%>; 
            if(mensagem) alert(mensagem);
        </script>

    </body>
</html>
