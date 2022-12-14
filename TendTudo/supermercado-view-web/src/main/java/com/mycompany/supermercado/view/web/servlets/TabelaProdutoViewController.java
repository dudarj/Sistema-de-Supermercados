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

@WebServlet(name = "TabelaProdutoViewController", urlPatterns = {"/TabelaProdutoViewController"})
public class TabelaProdutoViewController extends HttpServlet {

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
            RequestDispatcher rd = request.getRequestDispatcher("produtosSistema.jsp");
            String produto = request.getParameter("buscar");
            request.setAttribute("produtoBuscado", produto);
            int a = list.size();

            String[] v = new String[3];
            v[0] = "";
            v[1] = "";
            v[2] = "";
            for (int i = 0; i < a; i++) {
                request.setAttribute("codigo", list.get(i).getCodigo());
                request.setAttribute("descriçao" + i, list.get(i).getDescricao());
                request.setAttribute("preco" + i, list.get(i).getPreco());
                request.setAttribute("quantidade" + i, list.get(i).getQuantidade());
                request.setAttribute("tabelaProduto" + i, "<tr>\n"
                        + "                        <th>" + (i + 1) + "</th>\n"
                        + "                        <td>" + list.get(i).getDescricao() + "</td>\n"
                        + "                        <td> R$ " + list.get(i).getPreco() + "</td>\n"
                        + "                        <td >" + list.get(i).getQuantidade() + "</td>\n"
                        + "                        <td class=\"col-xs-3\"> <img src=" + "'" + list.get(i).getImg() + "'" + " style=width:60px; height:30px/></td>"
                        + "                        <td><form action=\"DeletarProdutoViewController\" method=\"post\" id=\"deletar\">\n"
                        + "                            \n"
                        + "                            <input class=\"apagar\" type=\"submit\" value=\"Deletar " + (i + 1) + "\" name=\"deletar\"></form></td>\n"
                        +  " <td><form action=\"EditarProdutoViewController\" method=\"post\" id=\"editar\">\n"
                        + "                            \n <h4>Editar Produto</h4>"
                        + "                        Descrição <input class=\"form-edit\" type=\"text\" name=\"descricao\" id=\"descricaoM\" value="+ list.get(i).getDescricao() +"><br><br>\n"
                        + "                        Preço <input class=\"form-edit\" type=\"text\" name=\"preco\" id=\"precoM\" value="+ list.get(i).getPreco()+"><br><br>\n"
                        + "                        Unidades <input class=\"form-edit\" type=\"number\" name=\"unidades\" id=\"unidadesM\" value="+ list.get(i).getQuantidade()+"><br><br>\n"
                        + "                        URL Da Imagem <input class=\"form-edit\" type=\"url\"  name=\"imgUrl\" id=\"imagemM\" value="+ list.get(i).getImg()+"><br><br>\n" +
                                "<input type=\"submit\" value=\"Editar Produto " + i + "\" name=\"editar\" class=\"editar\"></form></td>\n"
                        + "                    </tr>"
                );
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
