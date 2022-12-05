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
import java.util.List;
import model.DTO.Produto;
import model.servicos.ProdutoServico;

/**
 *
 * @author Samuel
 */
@WebServlet(name = "PesquisarProdutoController", urlPatterns = {"/PesquisarProdutoController"})
public class PesquisarProdutoController extends HttpServlet {

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
            ProdutoServico servico = new ProdutoServico();
            List<Produto> list = servico.ListarProdutos();
            int a = list.size();
            String produto = request.getParameter("buscar");
            request.setAttribute("produtoBuscado", produto);
            for (int i = 0; i < a; i++) {
                request.setAttribute("codigo", list.get(i).getCodigo());
                request.setAttribute("descriçao" + i, list.get(i).getDescricao());
                request.setAttribute("preco" + i, list.get(i).getPreco());
                request.setAttribute("quantidade" + i, list.get(i).getQuantidade());
                request.setAttribute("produtos" + i, "<div class=\"col-sm-6 col-md-6 col-lg-4 col-xl-4\">\n" +
"                                                    <div class=\"products-single fix\">\n" +
"                                                        <div class=\"box-img-hover\">\n" +
"                                                            <div class=\"type-lb\">\n" +
"                                                                <p class=\"aVENDA\">A VENDA</p>\n" +
"                                                            </div>\n" +
"                                                            <img src=\""+ list.get(i).getImg() + "\" class=\"img-fluid\" alt=\"Image\">\n" +
"                                                            <div class=\"mask-icon\">    \n" +
"                                                                <a class=\"cart\" href=\"#\">Add ao Carrinho</a>\n" +
"                                                            </div>\n" +
"                                                        </div>\n" +
"                                                        <div class=\"why-text\">\n" +
"                                                            <h4>" + list.get(i).getDescricao()+  "</h4>\n" +
"                                                            <h5>R$" + list.get(i).getPreco() + "</h5>\n" +
"                                                        </div>\n" +
"                                                    </div>\n" +
"                                                </div>");
                
            }
            RequestDispatcher rd = request.getRequestDispatcher("shopBuscar.jsp");
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
