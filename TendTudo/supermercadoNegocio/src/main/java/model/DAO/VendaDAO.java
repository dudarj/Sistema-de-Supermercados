package model.DAO;

import java.util.List;
import model.DTO.Venda;

public interface VendaDAO {
    void insert(Venda obj, Long codigoCliente, Long codigoPagamento, Long codigoTipoPagamento); 
    void update(Venda obj);
    void deleteById(Long id);
    Venda findById(Long id);
    List<Venda> ListarVendas();
    
    void salvar(Venda obj, Long id_cliente);
}
