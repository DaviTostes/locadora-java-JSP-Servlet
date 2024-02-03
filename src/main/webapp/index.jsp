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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
    </head>
    <body>
        <div>
            <center>
                <button><a href="FormularioJogo.jsp?acao=inclusao">Cadastrar jogo</a></button>
                <button><a href="FormularioCliente.jsp?acao=inclusao">Cadastrar cliente</a></button>
                <button><a href="JogoSrv?acao=listagem">Listar jogos</a></button>
                <button><a href="ClienteSrv?acao=listagem">Listar clientes</a></button>
            </center>
        </div>
    </body>
</html>
