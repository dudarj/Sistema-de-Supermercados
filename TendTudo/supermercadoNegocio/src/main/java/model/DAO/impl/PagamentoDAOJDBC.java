package model.DAO.impl;

import java.sql.Connection;
import java.util.List;
import model.DAO.PagamentoDAO;
import model.DTO.Pagamento;


public class PagamentoDAOJDBC implements PagamentoDAO {
    
    private Connection conn;

	public  PagamentoDAOJDBC(Connection conn) {
		this.conn = conn;
	}

    @Override
    public void insert(Pagamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pagamento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Pagamento id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pagamento findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pagamento> ListarPagamentos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
