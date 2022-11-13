package com.mycompany.supermercado.view.web.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DTO.Cliente;
import model.servicos.ClienteServico;

@WebServlet(name = "MainViewController", urlPatterns = {"/MainViewController"})
public class MainViewController extends HttpServlet {

    private ClienteServico servico = new ClienteServico();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("usuario");
        String senha = request.getParameter("senhaL");
        String tipo = "c";
        if (login != null && !login.isEmpty()) {
            if (senha != null && !senha.isEmpty()) {
                Cliente c = servico.findByLogin(login);
                
                if (login.equals(c.getLogin()) && (senha.equals(c.getSenha())) && (c.getTipo().equals("g"))) {
                    RequestDispatcher rd = request.getRequestDispatcher("mainGerencia.jsp");
                    rd.forward(request, response);
                } 
                else if (login.equals("maduda") && (senha.equals("756")) && (tipo.equals("c"))) {
                    RequestDispatcher rd = request.getRequestDispatcher("mainCliente.jsp");
                    rd.forward(request, response);
                }
                
                

            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("Mensagem", "Usuário e Senha inválidos.");
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


/*//private ClienteServico servico = new ClienteServico();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String login = request.getParameter("usuario");
        String senha = request.getParameter("senhaL");
        String tipo = "c";
        if (login != null && !login.isEmpty()) {
            if (senha != null && !senha.isEmpty()) {
                //Cliente c = servico.findByLogin(login);
                
                if (login.equals("admin") && (senha.equals("123")) && (tipo.equals("g"))) {
                    RequestDispatcher rd = request.getRequestDispatcher("mainGerencia.jsp");
                    rd.forward(request, response);
                } 
                else if (login.equals("maduda") && (senha.equals("756")) && (tipo.equals("c"))) {
                    RequestDispatcher rd = request.getRequestDispatcher("mainCliente.jsp");
                    rd.forward(request, response);
                }
                
                

            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("Mensagem", "Usuário e Senha inválidos.");
            rd.forward(request, response);

        }
    }*/