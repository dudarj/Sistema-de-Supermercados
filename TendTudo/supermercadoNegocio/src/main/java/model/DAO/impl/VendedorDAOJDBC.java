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
import model.DAO.VendedorDAO;
import model.DTO.Vendedor;

/**
 *
 * @author Aluno
 */
public class VendedorDAOJDBC implements VendedorDAO{
    private Connection conn;
        Vendedor ve = new Vendedor();
	public  VendedorDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(Vendedor obj) {
                String sqlInsert = "INSERT INTO vendedor(nome, comissao) VALUES (?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setString(1, ve.getNome());
            st.setDouble(2, ve.getComissao());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Vendedor obj) {
        String sqlUpdate = "UPDATE vendedor SET nome=?, comissao=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, ve.getNome());
            st.setDouble(2, ve.getComissao());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM vendedor WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Vendedor findById(Long id) {
        String sqlFindById = "SELECT FROM vendedor WHERE id=?";
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
    public void listar(Vendedor obj) {
        String sqlListar = "SELECT * FROM vendedor";
        try{
            PreparedStatement st = conn.prepareStatement(sqlListar);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    public List<Vendedor> ListarVendedores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
