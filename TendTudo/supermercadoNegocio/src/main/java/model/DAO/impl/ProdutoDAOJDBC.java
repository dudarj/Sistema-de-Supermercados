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
import model.DAO.ProdutoDAO;
import model.DTO.Produto;


public class ProdutoDAOJDBC implements ProdutoDAO {
    Produto pr = new Produto ();
    private Connection conn;

	public  ProdutoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(Produto obj) {
        String sqlInsert = "INSERT INTO produto(descricao, preco, quantidade) VALUES (?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setString(1, pr.getDescricao());
            st.setDouble(2, pr.getPreco());
            st.setInt(3, pr.getQuantidade());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Produto obj) {
        String sqlUpdate = "UPDATE produto SET descricao=?, preco=?, quantidade=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, pr.getDescricao());
            st.setDouble(2, pr.getPreco());
            st.setInt(3, pr.getQuantidade());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM produto WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Produto findById(Long id) {
         String sqlFindById = "SELECT FROM produto WHERE id=?";
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
    public void listar(Produto obj) {
        String sqlListar = "SELECT * FROM produto";
        try{
            PreparedStatement st = conn.prepareStatement(sqlListar);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Produto> ListarProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
