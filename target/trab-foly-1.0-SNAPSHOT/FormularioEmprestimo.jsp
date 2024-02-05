<%-- 
    Document   : Emprestimo
    Created on : 4 Feb 2024, 12:08:07
    Author     : davitostes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        
        String acao = request.getParameter("acao");
        
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de emprestimos</title>
        <link rel="stylesheet" type="text/css" href="./styles/formulario.css">
    </head>
    <body>
        <div class="container">
            <form action="EmprestimoSrv" method="POST">
                <input type="hidden" name="acao" value="<%=acao %>" />
                <div class="input_container">
                    <label>Id do cliente:</label>
                    <input type="number" id="cliente_id" name="cliente_id" min="0" />
                </div>
                <div class="input_container">
                    <label>Id do jogo:</label>
                    <input type="number" id="jogo_id" name="jogo_id" min="0" />
                </div>
                <div id="button_container">
                    <button type="submit">Enviar</button>
                    <button type="reset">Limpar</button>
                </div>
            </form>
        </div>
    </body>
</html>
