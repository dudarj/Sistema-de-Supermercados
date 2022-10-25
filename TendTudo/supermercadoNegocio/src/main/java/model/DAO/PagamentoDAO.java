package model.DAO;

import model.DTO.Pagamento;


public interface PagamentoDAO {
    void insert(Pagamento obj); 
    void update(Pagamento obj);
    void deleteById(Pagamento id);
    Pagamento findById(Long id);
    
}
