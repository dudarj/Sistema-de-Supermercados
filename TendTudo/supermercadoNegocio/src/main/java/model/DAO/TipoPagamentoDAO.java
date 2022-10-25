package model.DAO;

import model.DTO.TipoPagamento;


public interface TipoPagamentoDAO {
    void insert(TipoPagamento obj); 
    void update(TipoPagamento obj);
    void deleteById(TipoPagamento id);
    TipoPagamento findById(Long id);
    
}
