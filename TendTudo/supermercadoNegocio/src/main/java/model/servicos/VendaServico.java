package model.servicos;

import java.util.List;
import model.DAO.DAOFactory;
import model.DAO.VendaDAO;
import model.DTO.Cliente;
import model.DTO.Venda;


public class VendaServico {
    
    private VendaDAO dao = DAOFactory.createVendaDao();

    public List<Venda> ListarVendas() {
        return dao.ListarVendas();
    }
    
    public void salvar(Venda obj, Cliente cliente) {
        dao.salvar(obj, cliente.getCodigo());
    }

    public void salvar(Venda obj, Long id_cliente) {
        // TODO Auto-generated method stub

    }
    
}
