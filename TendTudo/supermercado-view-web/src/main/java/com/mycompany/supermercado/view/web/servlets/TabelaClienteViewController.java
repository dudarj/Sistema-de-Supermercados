package com.mycompany.supermercado.view.web.servlets;

import jakarta.jms.Connection;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.DAO.impl.ClienteDAOJDBC;
import model.DTO.Cliente;
import model.servicos.ClienteServico;

@WebServlet(name = "TabelaClienteViewController", urlPatterns = {"/TabelaClienteViewController"})
public class TabelaClienteViewController extends HttpServlet {

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
            Cliente cliente = new Cliente();
            ClienteDAOJDBC c = new ClienteDAOJDBC();
            ClienteServico servico = new ClienteServico();
            List<Cliente> list = servico.ListarClientes();

            RequestDispatcher rd = request.getRequestDispatcher("clientesSistema.jsp");

            int a = list.size();
            for (int i = 1; i < a; i++) {
               /* request.setAttribute("Nome" + i, list.get(i).getNome());
                request.setAttribute("cpf" + i, list.get(i).getCpf());
                request.setAttribute("telefone" + i, list.get(i).getTelefone());
                request.setAttribute("endereco" + i, list.get(i).getEndereco());*/

                request.setAttribute("tabela" + i, "<tr>\n"
                        + "                        <th>" + i + "</th>\n"
                        + "                        <td>" + list.get(i).getNome() + "</td>\n"
                        + "                        <td>" + list.get(i).getCpf() + "</td>\n"
                        + "                        <td >" + list.get(i).getTelefone() + "</td>\n"
                        + "                        <td>" + list.get(i).getEndereco() + "</td>\n"
                        + "                        <td>" + list.get(i).getEmail() + "</td>\n"
                        + "                        <td>" + list.get(i).getStatus() + "</td>\n"
                        + "                        <td>" + list.get(i).getTipo() + "</td>\n"
                        + "                    </tr>");


            }

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
