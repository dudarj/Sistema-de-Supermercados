/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import conexao.ConexaoJdbc;
import conexao.DbException;
import model.DAO.ItemDAO;
import model.DTO.Item;

public class ItemDAOJDBC implements ItemDAO {

    private Connection conn;

    public ItemDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Set<Item> obj) {
        String sqlInsert = "INSERT INTO item(quantidade, valortotal, codigo_produto, codigo_venda) VALUES (?,?,?,?)";

        String sqlUpdateProduto = "UPDATE produto "
                + " SET quantidade = quantidade - ? "
                + " WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            PreparedStatement stProd = conn.prepareStatement(sqlUpdateProduto);

            for (Item i : obj) {

                st.setInt(1, i.getQuantidade());
                st.setDouble(2, i.getValorTotal());
                st.setLong(3, i.getProduto().getCodigo());
                st.setLong(4, i.getVenda().getCodigo());

                stProd.setInt(1, i.getQuantidade());
                stProd.setLong(2, i.getProduto().getCodigo());

                stProd.executeUpdate();

                st.executeUpdate();
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Item obj) {
        String sqlUpdate = "UPDATE item SET quantidade=?, valortotal=? WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setInt(1, obj.getQuantidade());
            st.setDouble(2, obj.getValorTotal());
            st.setLong(3, obj.getCodigo());
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM item WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Item findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM item "
                    + "WHERE codigo = ?");

            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Item obj = new Item();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setValorTotal(rs.getDouble("valortotal"));
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
    public List<Item> ListarItens() {
        List<Item> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM item " + "ORDER BY quantidade");
            rs = st.executeQuery();

            while (rs.next()) {
                Item obj = new Item();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setQuantidade(rs.getInt("quantidade"));
                obj.setValorTotal(rs.getDouble("valortotal"));
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
    public void salvar(Item obj, Long id_venda, Long id_produto) {
        // Generated from 
    }
}
