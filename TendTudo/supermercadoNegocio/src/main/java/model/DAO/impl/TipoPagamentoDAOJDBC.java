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
import model.DAO.TipoPagamentoDAO;
import model.DTO.TipoPagamento;

/**
 *
 * @author Aluno
 */
public class TipoPagamentoDAOJDBC implements TipoPagamentoDAO {
    TipoPagamento t = new TipoPagamento();
    private Connection conn;

	public  TipoPagamentoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(TipoPagamento obj) {
        String sqlInsert = "INSERT INTO tipopagamento(descricao) VALUES (?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setString(1, t.getDescricao());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(TipoPagamento obj) {
        String sqlUpdate = "UPDATE tipopagamento SET descricao=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, t.getDescricao());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM tipopagamento WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }     }

    @Override
    public TipoPagamento findById(Long id) {
        String sqlFindById = "SELECT FROM tipopagamento WHERE id=?";
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
    public void listar(Long id) {
        String sqlListar = "SELECT * FROM tipopagamento";
        try{
            PreparedStatement st = conn.prepareStatement(sqlListar);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TipoPagamento> ListarTiposPagamentos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
