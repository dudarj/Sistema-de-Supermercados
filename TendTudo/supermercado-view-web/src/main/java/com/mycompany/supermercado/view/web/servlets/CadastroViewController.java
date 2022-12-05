package com.mycompany.supermercado.view.web.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DTO.Cliente;
import model.servicos.ClienteServico;


@WebServlet(name = "CadastroViewController", urlPatterns = {"/CadastroViewController"})
public class CadastroViewController extends HttpServlet {

    public Cliente insereValores() {
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String nome = request.getParameter("nome");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            String Cpf = request.getParameter("Cpf");
            String email = request.getParameter("email");
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            String confirmPassword = request.getParameter("confirm-password");
            Cliente cliente = new Cliente();
            ClienteServico servico = new ClienteServico();

            if (nome != null && !nome.isEmpty() && telefone != null && !telefone.isEmpty() && endereco != null && !endereco.isEmpty()
                    && Cpf != null && !Cpf.isEmpty() && login != null && !login.isEmpty() && senha != null && !senha.isEmpty() && confirmPassword.equals(senha)) {

                cliente.setNome(nome);
                cliente.setTelefone(telefone);
                cliente.setEndereco(endereco);
                cliente.setCpf(Cpf);
                cliente.setEmail(email);
                cliente.setStatus(0);
                cliente.setLogin(login);
                cliente.setSenha(senha);
                cliente.setTipo("c");
                servico.cadastrar(cliente);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("Mensagem", "Cadastro realizado com sucesso");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("MensagemC", "Obrigatório preencher os campos.");
                rd.forward(request, response);
            }
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
