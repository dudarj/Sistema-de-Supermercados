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
import model.DAO.impl.ProdutoDAOJDBC;
import model.DTO.Produto;
import model.servicos.ProdutoServico;

/**
 *
 * @author Samuel
 */
@WebServlet(name = "EditarProdutoViewController", urlPatterns = {"/EditarProdutoViewController"})
public class EditarProdutoViewController extends HttpServlet {

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
            
            Produto p = new Produto();
            
            String a = request.getParameter("editar");
            String descricao = request.getParameter("descricao");
            int unidades = Integer.parseInt(request.getParameter("unidades"));
            String imagem = request.getParameter("imgUrl");
            String produtoStr = request.getParameter("preco");
            Double preco = Double.valueOf(produtoStr);
            int b = Integer.parseInt(a.replace("Editar Produto ", ""));

            p.setDescricao(descricao);

            p.setPreco(preco);
            p.setImg(imagem);
            p.setQuantidade(unidades);
            p.setCodigo(list.get(b).getCodigo());
            servico.salvar(p);

            RequestDispatcher rd = request.getRequestDispatcher("TabelaProdutoViewController");
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
