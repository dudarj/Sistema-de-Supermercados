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
                        + "                            <input type=\"submit\" value=\"Deletar " + (i + 1) + "\" name=\"deletar\" class=\"apagar\"></form></td>\n"
                        + "                        <td><input type=\"submit\" value=\"Editar\" class=\"editar\" name=\"editar\" onclick=\"modal2()\"></td>\n"
                        + "                    </tr>"
                + "        <div id=\"modal_2\" class=\"modal\">\n" +
"            <div class=\"modal__content\">\n" +
"                <h2 class=\"modal__title\" style=\"margin-left: 15px; margin-top: 20px;\">Editar Produto</h2>\n" +
"                <p class=\"modal__description\">\n" +
"                <form action=\"EditarProdutoViewController\" method=\"post\">\n" +
"                    <div style=\"margin-left: 20px;\">\n" +
"                        <br>\n" +
"                        Descrição <input type=\"text\" name=\"descricao\"><br><br>\n" +
"                        Preço <input type=\"number\" name=\"preco\"><br><br>\n" +
"                        Unidades <input type=\"number\" name=\"unidades\"><br><br>\n" +
"                        URL Da Imagem <input type=\"url\"  name=\"imgUrl\"><br><br>\n" +
"                        <input type=\"submit\" value=\"Editar Produto " +i+ "\" class=\"modal__link\" name=\"editar\" style=\"cursor:pointer;\" ><br>\n" +
"\n" +
"                    </div>\n" +
"\n" +
"                </form>\n" +
"                <button class=\"modal__link\"onclick=\"document.getElementById('modal_2').classList.toggle('visivel')\" style=\"position: relative;left: 67%; cursor: pointer;\n" +
"                        margin-bottom: -20px;top: -68px;\">Cancelar</button>\n" +
"            </div>\n" +
"        </div>"
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
