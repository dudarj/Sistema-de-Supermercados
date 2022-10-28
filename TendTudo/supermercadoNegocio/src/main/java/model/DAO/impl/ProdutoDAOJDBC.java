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

    @Override
    public void insert(Produto obj) {
        String sqlInsert = "INSERT INTO produto(descricao, preco, quantidade) VALUES (?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQuantidade());
            
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
        String sqlUpdate = "UPDATE produto SET descricao=?, preco=?, quantidade=? WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, obj.getDescricao());
            st.setDouble(2, obj.getPreco());
            st.setInt(3, obj.getQuantidade());
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
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
}
