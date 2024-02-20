<%-- 
    Document   : Emprestimo
    Created on : 4 Feb 2024, 12:08:07
    Author     : davitostes
--%>

<%@page import="model.Jogo"%>
<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="model.dao.DaoFactory"%>
<%@page import="model.dao.InterfaceDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String acao = request.getParameter("acao");
        
        InterfaceDao dao_cliente = DaoFactory.novoClienteDao();
        InterfaceDao dao_jogo = DaoFactory.novoJogoDao();
        
        List<Cliente> clientes = dao_cliente.listar();
        List<Jogo> jogos = dao_jogo.listar();
        
        String jogos_html = "";
        for(Jogo jogo : jogos) {
            jogos_html += "<option value="+jogo.getId()+">"+jogo.getNome()+"</option>";
        }
        
        String clientes_html = "";
        for(Cliente cliente : clientes) {
            clientes_html += "<option value="+cliente.getId()+">"+cliente.getNome()+"</option>";
        }
     %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de emprestimos</title>
        <link rel="stylesheet" type="text/css" href="./styles/formulario.css">
        <link rel="icon" type="image/x-icon" href="./assets/icon.png">
    </head>
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
            <h2>Fazer emprestimo</h2>
            <form action="EmprestimoSrv" method="POST">
                <input type="hidden" name="acao" value="<%=acao %>" />
                <div class="input_container">
                    <label>Cliente:</label>
                    <select name="cliente_id">
                        <%=clientes_html%>
                    </select>
                </div>
                <div class="input_container">
                    <label>Jogo:</label>
                    <select name="jogo_id">
                        <%=jogos_html%>
                    </select>
                </div>
                
                <div id="button_container">
                    <button type="submit">Enviar</button>
                    <button type="reset">Limpar</button>
                </div>
            </form>
        </div>
    </body>
</html>
