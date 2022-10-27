package model.DAO.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.List;
import model.DAO.VendaDAO;
import model.DTO.Cliente;
import model.DTO.Pagamento;
import model.DTO.Venda;
import model.DTO.Vendedor;


public class VendaDAOJDBC implements VendaDAO {
    
    private Connection conn;
        Venda v = new Venda();
        Cliente c = new Cliente();
        Vendedor ve = new Vendedor();
        Pagamento p = new Pagamento();
	public  VendaDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(Venda obj) {
        String sqlInsert = "INSERT INTO venda(datavenda, valortotal, codigo_vendedor, codigo_cliente, codigo_pagamento) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setDate(1, (Date) v.getDataVenda());
            st.setDouble(2, v.getValorTotal());
            st.setLong(3, ve.getCodigo());
            st.setLong(4, c.getCodigo());
            st.setLong(5, p.getCodigo());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void update(Venda obj) {
        String sqlUpdate = "UPDATE venda SET datavenda=?, valortotal=?, codigo_vendedor=?, codigo_cliente=?, codigo_pagamento=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setDate(1, (Date) v.getDataVenda());
            st.setDouble(2, v.getValorTotal());
            st.setLong(3, ve.getCodigo());
            st.setLong(4, c.getCodigo());
            st.setLong(5, p.getCodigo());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM venda WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Venda findById(Long id) {
         String sqlFindById = "SELECT FROM venda WHERE id=?";
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
    public void listar(Venda obj) {
        String sqlListar = "SELECT * FROM venda";
        try{
            PreparedStatement st = conn.prepareStatement(sqlListar);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Venda> ListarVendas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
