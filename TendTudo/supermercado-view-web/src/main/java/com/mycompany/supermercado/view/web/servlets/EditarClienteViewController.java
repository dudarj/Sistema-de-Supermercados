/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.supermercado.view.web.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.DTO.Cliente;
import model.servicos.ClienteServico;

/**
 *
 * @author DUDA
 */
@WebServlet(name = "EditarClienteViewController", urlPatterns = {"/EditarClienteViewController"})
public class EditarClienteViewController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            ClienteServico servico = new ClienteServico();
            List<Cliente> list = servico.ListarClientes();
            
            Cliente c = new Cliente();
            
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            String email = request.getParameter("email");
                            
            c.setNome(nome);
            c.setCpf(cpf);
            c.setTelefone(telefone);
            c.setEndereco(endereco);
            c.setEmail(email);
            servico.update(c);
            
            session.setAttribute("nome", nome);
            session.setAttribute("cpf", cpf);
            session.setAttribute("telefone", telefone);
            session.setAttribute("endereco", endereco);
            session.setAttribute("email", email);            
            RequestDispatcher rd = request.getRequestDispatcher("minhaConta.jsp");
            rd.forward(request, response);
        }
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
