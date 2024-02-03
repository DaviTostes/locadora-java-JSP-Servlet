/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import model.dao.DaoFactory;
import model.dao.InterfaceDao;

/**
 *
 * @author davitostes
 */
public class ClienteSrv extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            String acao = request.getParameter("acao");
            
            InterfaceDao dao = DaoFactory.novoClienteDao();
            RequestDispatcher rd;
            
            switch(acao) {
                case "inclusao":
                    String nome = request.getParameter("nome");
                    String email = request.getParameter("email");
                    String telefone = request.getParameter("telefone");
                    
                    dao.incluir(new Cliente(nome, email, telefone));
                    rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                    break;
                case "pre-edicao":
                    
                    break;
                case "edicao":
                    
                    break;
                case "exclusao":
                    
                    break;
                case "listagem":
                    rd = request.getRequestDispatcher("ListagemCliente.jsp?lista="+listagem());
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(JogoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String listagem() {
        InterfaceDao dao;
        List<Cliente> lista = null;
        try {
            dao = DaoFactory.novoClienteDao();
            lista = dao.listar();
        } catch (Exception ex) {
            Logger.getLogger(JogoSrv.class.getName()).log(Level.SEVERE, null, ex);
        }
        String listaHTML = "";
        for(Cliente cliente : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + cliente.getNome() + "</td>"
                    + "<td>" + cliente.getEmail() + "</td>"
                    + "<td>" + cliente.getTelefone() + "</td>"
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
