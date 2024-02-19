/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Jogo;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;

/**
 *
 * @author davitostes
 */
public class JogoSrv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String acao = request.getParameter("acao");
            
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String preco = request.getParameter("preco");
            
            InterfaceDao dao = DaoFactory.novoJogoDao();
            RequestDispatcher rd;
            
            switch(acao) {
                case "inclusao":
                    dao.incluir(new Jogo(nome, descricao, Double.parseDouble(preco)));
                    rd = request.getRequestDispatcher("index.jsp?mensagem='Sucesso ao cadastrar jogo'");
                    rd.forward(request, response);
                    break;
                case "pre-edicao":
                    Jogo jogo_pre_edicao = (Jogo) dao.pesquisarPorId(Integer.parseInt(id));
                    rd = request.getRequestDispatcher("FormularioJogo.jsp?acao=edicao"
                        + "&id="+jogo_pre_edicao.getId()
                        + "&nome="+jogo_pre_edicao.getNome()
                        + "&descricao="+jogo_pre_edicao.getDescricao()
                        + "&preco="+jogo_pre_edicao.getPreco());
                    rd.forward(request, response);
                    break;
                case "edicao":
                    Jogo jogo_edicao = new Jogo(nome, descricao, Double.parseDouble(preco));
                    jogo_edicao.setId(Integer.parseInt(id));
                    dao.editar(jogo_edicao);
                    rd = request.getRequestDispatcher("JogoSrv?acao=listagem");
                    rd.forward(request, response);
                    break;
                case "exclusao":
                    Jogo jogo_exclusao = (Jogo) dao.pesquisarPorId(Integer.parseInt(id));
                    dao.excluir(jogo_exclusao);
                    rd = request.getRequestDispatcher("JogoSrv?acao=listagem");
                    rd.forward(request, response);
                    break;
                case "listagem":
                    String listagem = listagem();
                    if(listagem == "") {
                        rd = request.getRequestDispatcher("index.jsp?mensagem='Nenhum jogo encontrado'");
                        rd.forward(request, response);
                    }
                    rd = request.getRequestDispatcher("ListagemJogo.jsp?lista="+listagem);
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(JogoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String listagem() {
        InterfaceDao dao;
        List<Jogo> lista = null;
        try {
            dao = DaoFactory.novoJogoDao();
            lista = dao.listar();
        } catch (Exception ex) {
            Logger.getLogger(JogoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista.size() == 0) {
            return "";
        }
        String listaHTML = "";
        for(Jogo jogo : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + jogo.getId() + "aaaaaaa" + "</td>"
                    + "<td>" + jogo.getNome() + "</td>"
                    + "<td>" + jogo.getDescricao() + "</td>"
                    + "<td>" + jogo.getPreco() + "</td>"
                    + "<td><form action=JogoSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + jogo.getId() + "><button type='submit'><img src=./assets/editar.png></button>"
                    + "</form></td>"
                    + "<td><form action=JogoSrv?acao=exclusao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + jogo.getId() + "><button type='submit'><img src=./assets/excluir.png></button></td>"
                    + "</form>"
                    + "</tr>";
        }
        
        return listaHTML;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
