/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.List;
import model.DAO.ItemDAO;
import model.DTO.Item;

/**
 *
 * @author Aluno
 */
public class ItemDAOJDBC implements ItemDAO {
    Item i = new Item();
    private Connection conn;

	public  ItemDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(Item obj) {
        String sqlInsert = "INSERT INTO item(quantidade, valortotal, codigo_produto, codigo_venda) VALUES (?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setInt(1, i.getQuantidade());
            st.setDouble(2, i.getValorTotal());
            st.setLong(3, i.getCodigo());
            st.setInt(4, i.getCodigoVenda());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Item obj) {
        String sqlUpdate = "UPDATE item SET quantidade=?, valortotal=?, codigo_produto=?, codigo_venda=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setInt(1, i.getQuantidade());
            st.setDouble(2, i.getValorTotal());
            st.setLong(3, i.getCodigo());
            st.setInt(4, i.getCodigoVenda());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM item WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Item findById(Long id) {
        String sqlFindById = "SELECT FROM item WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlFindById);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public void listar(Item obj) {
        String sqlListar = "SELECT * FROM item";
        try{
            PreparedStatement st = conn.prepareStatement(sqlListar);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Item> ListarItens() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
