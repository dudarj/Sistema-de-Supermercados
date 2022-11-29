package com.mycompany.supermercado.view.web.servlets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.DTO.TipoPagamento;
import model.servicos.TipoPagamentoServico;


@WebServlet(name = "TabelaPagamentoViewController", urlPatterns = {"/TabelaPagamentoViewController"})
public class TabelaPagamentoViewController extends HttpServlet {

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
            TipoPagamento tipoPagamento = new TipoPagamento();
            TipoPagamentoServico servico = new TipoPagamentoServico();
            List<TipoPagamento> list = servico.ListarTiposPagamentos();
            RequestDispatcher rd = request.getRequestDispatcher("pagamentoSistema.jsp");
            int a = list.size();
            for (int i = 0; i < a; i++) {
                request.setAttribute("codigo" + i, list.get(i).getCodigo());
                request.setAttribute("descricao" + i, list.get(i).getDescricao());
                request.setAttribute("tabelaPagamento" + i, "<tr>\n"
                        + "                        <td>" + list.get(i).getCodigo() + "</td>\n"
                        + "                        <td>" + list.get(i).getDescricao() + "</td>\n"
                        + "                        <td><form action=\"DeletarPagamentoViewController\" method=\"post\" id=\"deletar\">\n" +
"                            \n" +
"                            <input type=\"submit\" value=\"Deletar "+ (i + 1)+"\" name=\"deletar\" class=\"apagar\"></form></td>\n"
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
