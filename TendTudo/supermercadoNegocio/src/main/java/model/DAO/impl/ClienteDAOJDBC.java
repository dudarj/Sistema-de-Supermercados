/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.impl;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.List;
import model.DAO.ClienteDAO;
import model.DTO.Cliente;

/**
 *
 * @author Aluno
 */
public class ClienteDAOJDBC implements ClienteDAO {
    Cliente c = new Cliente();
    private Connection conn;

	public  ClienteDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(Cliente obj) {
        String sqlInsert = "INSERT INTO cliente(nome, cpf, telefone, endereco, status) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEndereco());
            String status = Integer.toString(c.getStatus());
            st.setString(5, status);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Cliente obj) {
       String sqlUpdate = "UPDATE cliente SET nome=?, cpf=?, telefone=?, endereco=?, status=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, c.getNome());
            st.setString(2, c.getCpf());
            st.setString(3, c.getTelefone());
            st.setString(4, c.getEndereco());
            String status = Integer.toString(c.getStatus());
            st.setString(5, status);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM cliente WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Cliente findById(Long id) {
         String sqlFindById = "SELECT FROM cliente WHERE id=?";
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
    public void listar(Cliente obj) {
        String sqlListar = "SELECT * FROM cliente";
        try{
            PreparedStatement st = conn.prepareStatement(sqlListar);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> ListarClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
