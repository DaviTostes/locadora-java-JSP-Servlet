<%-- 
    Document   : Formulario
    Created on : 3 Feb 2024, 16:02:34
    Author     : davitostes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
        
        String acao = request.getParameter("acao");
        
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String preco = request.getParameter("preco");
        System.out.println(id);
        
        if (id == null) {
            nome = "";
            descricao = "";
            preco = "";
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario jogo</title>
        <link rel="stylesheet" type="text/css" href="./styles/formulario.css">
    </head>
    <body>
        <div class="container">
            <form action="JogoSrv" method="POST">
                <input type="hidden" name="acao" value="<%=acao %>" />
                <input type="hidden" name="id" value="<%=id %>" />
                <div class="input_container">
                    <label>Nome:</label>
                    <input type="text" id="nome" name="nome" value="<%=nome%>" />
                </div>
                <div class="input_container">
                    <label>Descrição:</label>
                    <textarea id="descricao" name="descricao"><%=descricao%></textarea>
                </div>
                <div class="input_container">
                    <label>Preço:</label>
                    <input type="text" id="preco" name="preco" value="<%=preco%>" />
                </div>
                <div id="button_container">
                    <button type="submit">Enviar</button>
                    <button type="reset">Limpar</button>
                </div>
            </form>
        </div>
    </body>
</html>
