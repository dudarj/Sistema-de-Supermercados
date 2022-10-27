package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.List;
import model.DAO.PagamentoDAO;
import model.DTO.Pagamento;


public class PagamentoDAOJDBC implements PagamentoDAO {
    Pagamento p = new Pagamento();
    private Connection conn;

	public  PagamentoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(Pagamento obj) {
        String sqlInsert = "INSERT INTO pagamento(parcelas, codigo_tipopagamento) VALUES (?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setInt(1, p.getParcelas());
            st.setLong(2, p.getCodigo());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Pagamento obj) {
        String sqlUpdate = "UPDATE pagamento SET parcelas=?, codigo_tipopagamento=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setInt(1, p.getParcelas());
            st.setLong(2, p.getCodigo());
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void deleteById(Long id) {//Samuel mudou para Long
        String sqlDelete = "DELETE FROM pagamento WHERE id=?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public Pagamento findById(Long id) {
        String sqlFindById = "SELECT FROM pagamento WHERE id=?";
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
    public void listar(Pagamento obj) {
        String sqlListar = "SELECT * FROM pagamento";
        try{
            PreparedStatement st = conn.prepareStatement(sqlListar);
            st.execute();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pagamento> ListarPagamentos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
