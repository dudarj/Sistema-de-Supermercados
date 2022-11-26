package model.servicos;

import java.util.List;
import model.DAO.DAOFactory;
import model.DAO.VendaDAO;
import model.DTO.Venda;


public class VendaServico {
    
    private VendaDAO dao = DAOFactory.createVendaDao();

    public List<Venda> ListarVendas() {
        return dao.ListarVendas();
    }
    
}
