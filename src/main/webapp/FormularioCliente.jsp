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
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        System.out.println(id);

        if (id == null) {
            nome = "";
            email = "";
            telefone = "";
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario cliente</title>
        <link rel="stylesheet" type="text/css" href="./styles/formulario.css">
    </head>
    <body>
        <div class="tab_bar_container">
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
                <a href="FormularioEmprestimo.jsp?acao=inclusao">Fazer emprestimo</a>
                <a href="EmprestimoSrv?acao=listagem">Listar emprestimos</a>                 
            </div>
        </div>
        <div class="container">
            <h2>Cadastrar cliente</h2>
            <form action="ClienteSrv" method="POST">
                <input type="hidden" name="acao" value="<%=acao%>" />
                <input type="hidden" name="id" value="<%=id%>" />
                <div class="input_container">
                    <label>Nome:</label>
                    <input type="text" id="nome" name="nome" value="<%=nome%>" />
                </div>
                <div class="input_container">
                    <label>Email:</label>
                    <input type="text" id="email" name="email" value="<%=email%>" />
                </div>
                <div class="input_container">
                    <label>Telefone:</label>
                    <input type="text" id="telefone" name="telefone" value="<%=telefone%>" />
                </div>
                <div id="button_container">
                    <button type="submit">Enviar</button>
                    <button type="reset">Limpar</button>
                </div>
            </form>
        </div>
    </body>
</html>
