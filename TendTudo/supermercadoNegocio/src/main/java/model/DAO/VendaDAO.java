package model.DAO;

import java.util.List;
import model.DTO.Venda;

public interface VendaDAO {
    void insert(Venda obj); 
    void update(Venda obj);
    void deleteById(Long id);
    Venda findById(Long id);
    List<Venda> ListarVendas();    
}
