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
        
        dao.salvar(obj, id_cliente);

    }
    
    public Venda findById(Long id){
       return  dao.findById(id);
    }
    
    public List<Venda> findAll() {
        return dao.findAll();
    }
    
    public List<Venda> findByData(String data) {
        return dao.findByData(data);
    }
    
}
