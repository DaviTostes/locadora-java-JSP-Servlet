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
        
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario jogo</title>
    </head>
    <body>
        <div>
            <center>
                <form action="JogoSrv" method="POST">
                    <input type="hidden" name="acao" value="<%=acao %>" />
                    <label>
                        Nome: <input type="text" id="nome" name="nome" value="" />
                    </label>
                    <label>
                        Descrição: <textarea id="descricao" name="descricao" rows="5" cols="33" value=""></textarea>
                    </label>
                    <label>
                        Preço: <input type="text" id="preco" name="preco" value="" />
                    </label>
                    <button type="submit">Enviar</button>
                    <button type="reset">Limpar</button>
                </form>
            </center>
        </div>
    </body>
</html>
