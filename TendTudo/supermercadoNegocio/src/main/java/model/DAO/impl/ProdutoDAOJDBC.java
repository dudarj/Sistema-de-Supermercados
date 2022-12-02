/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.impl;

import conexao.ConexaoJdbc;
import conexao.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.List;
import model.DAO.ProdutoDAO;
import model.DTO.Produto;

public class ProdutoDAOJDBC implements ProdutoDAO {

    private Connection conn;

    public ProdutoDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    public ProdutoDAOJDBC() {
    }

    @Override
    public void insert(Produto obj) {
        String sqlInsert = "INSERT INTO produto(descricao, preco, quantidade, url_img) VALUES (?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQuantidade());
            st.setString(4, obj.getImg());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    obj.setCodigo(id);
                }
                ConexaoJdbc.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado, nehuma linha foi afetada!");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Produto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE produto " + "SET descricao = ?, preco = ?, quantidade = ?, url_img = ? WHERE codigo = ? ");

            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQuantidade());
            st.setString(4, obj.getImg());
            st.setLong(5, obj.getCodigo());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM produto WHERE codigo = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Produto findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM produto "
                    + "WHERE codigo = ?");

            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Produto obj = new Produto();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setImg(rs.getString("url_img"));

                return obj;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
            ConexaoJdbc.closeResultSet(rs);
        }
    }

    @Override
    public List<Produto> ListarProdutos() {
        List<Produto> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM produto " + "ORDER BY descricao");
            rs = st.executeQuery();

            while (rs.next()) {
                Produto obj = new Produto();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setImg(rs.getString("url_img"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
            ConexaoJdbc.closeResultSet(rs);
        }
    }

    @Override
    public List<Produto> findByNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * "
                    + " from produto p "
                    + " where p.descricao LIKE '%" + nome + "%' ";
            st = conn.prepareStatement(sql);
            List<Produto> list = new ArrayList<>();

            //st.setString(1, nome);
            rs = st.executeQuery();
            while (rs.next()) {
                Produto obj = new Produto();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setImg(rs.getString("url_img"));

                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
            ConexaoJdbc.closeResultSet(rs);
        }
    }

    @Override
    public List<Produto> findAll() {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return null;
    }

    @Override
    public void updateSupermercado() {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE produto " + "SET qtdeItem = 0 WHERE codigo in(2,3,4,5,6 ) ");

            /*st.setInt(1, obj.getQtdeItem());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQuantidade());
            st.setLong(4, obj.getCodigo());*/
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
        }
    }
}
