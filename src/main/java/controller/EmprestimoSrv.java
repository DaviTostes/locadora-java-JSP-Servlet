/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Emprestimo;
import model.Jogo;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;

/**
 *
 * @author davitostes
 */
public class EmprestimoSrv extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String acao = request.getParameter("acao");
            
            String id = request.getParameter("id");
            
            InterfaceDao dao = DaoFactory.novoEmprestimoDao();
            RequestDispatcher rd;
            
            switch(acao) {
                case "inclusao":                   
                    long cliente_id = Long.parseLong(request.getParameter("cliente_id"));
                    long jogo_id = Long.parseLong(request.getParameter("jogo_id"));
                    
                    InterfaceDao dao_cliente = DaoFactory.novoClienteDao();
                    InterfaceDao dao_jogo = DaoFactory.novoJogoDao();
                    
                    Cliente cliente_inclusao = (Cliente) dao_cliente.pesquisarPorId(cliente_id);
                    Jogo jogo_inclusao = (Jogo) dao_jogo.pesquisarPorId(jogo_id);
                    
                    if(jogo_inclusao == null) {
                        rd = request.getRequestDispatcher("index.jsp?mensagem='Jogo não encotrado'");
                    rd.forward(request, response);
                    }
                    
                    if(cliente_inclusao == null) {
                        rd = request.getRequestDispatcher("index.jsp?mensagem='Cliente não encotrado'");
                        rd.forward(request, response);
                    }
                    
                    LocalDate data_atual = LocalDate.now();
                    LocalDate data_devolucao = data_atual.plusDays(7);
                    
                    dao.incluir(new Emprestimo(data_atual, data_devolucao, cliente_inclusao, jogo_inclusao));
                    rd = request.getRequestDispatcher("index.jsp?mensagem='Sucesso ao realizar emprestimo'");
                    rd.forward(request, response);
                    break;
                case "devolucao":
                    Emprestimo emprestimo_devolucao = (Emprestimo) dao.pesquisarPorId(Integer.parseInt(id));
                    emprestimo_devolucao.setDevolvido(true);
                    dao.editar(emprestimo_devolucao);
                    rd = request.getRequestDispatcher("EmprestimoSrv?acao=listagem");
                    rd.forward(request, response);
                    break;
                case "listagem":
                    String listagem = listagem();
                    if(listagem == "") {
                        rd = request.getRequestDispatcher("index.jsp?mensagem='Nenhum emprestimo encontrado'");
                        rd.forward(request, response);
                    }
                    rd = request.getRequestDispatcher("ListagemEmprestimo.jsp?lista="+listagem);
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(EmprestimoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String listagem() {
        InterfaceDao dao;
        List<Emprestimo> lista = null;
        try {
            dao = DaoFactory.novoEmprestimoDao();
            lista = dao.listar();
        } catch (Exception ex) {
            Logger.getLogger(EmprestimoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(lista.size() == 0) {
            return "";
        }
        String listaHTML = "";
        for(Emprestimo emprestimo : lista) {
            String situacao = emprestimo.getDataDevolucao().compareTo(LocalDate.now()) < 0 ? "Atrasado" : "No prazo";
            situacao = emprestimo.isDevolvido() ? "Devolvido" : situacao;
            String botao_devolver = "</tr>";
            if(situacao != "Devolvido") {
                botao_devolver = "<td><form action=EmprestimoSrv?acao=devolucao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + emprestimo.getId() + "><button class='botao_devolver' type='submit'>Finalizar</button>"
                    + "</form></td>"
                    + "</tr>";
            }
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + emprestimo.getId() + "</td>"
                    + "<td>" + emprestimo.getCliente().getNome() + "</td>"
                    + "<td>" + emprestimo.getJogo().getNome() + "</td>"
                    + "<td>" + emprestimo.getDataEmprestimo() + "</td>"
                    + "<td>" + emprestimo.getDataDevolucao() + "</td>"
                    + "<td>" + situacao + "</td>"
                    + botao_devolver;
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
