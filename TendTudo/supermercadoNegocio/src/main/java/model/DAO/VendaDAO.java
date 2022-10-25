package model.DAO;

import model.DTO.Venda;

public interface VendaDAO {
    void insert(Venda obj); 
    void update(Venda obj);
    void deleteById(Long id);
    Venda findById(Long id);
    
    
}
