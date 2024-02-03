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
        <title>Formulario cliente</title>
    </head>
    <body>
        <div>
            <center>
                <form action="ClienteSrv" method="POST">
                    <input type="hidden" name="acao" value="<%=acao %>" />
                    <label>
                        Nome: <input type="text" id="nome" name="nome" value="" />
                    </label>
                    <label>
                        Email: <input type="text" id="email" name="email" value="" />
                    </label>
                    <label>
                        Telefone: <input type="text" id="telefone" name="telefone" value="" />
                    </label>
                    <button type="submit">Enviar</button>
                    <button type="reset">Limpar</button>
                </form>
            </center>
        </div>
    </body>
</html>
