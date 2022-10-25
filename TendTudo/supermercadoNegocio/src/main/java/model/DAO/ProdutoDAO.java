package model.DAO;

import model.DTO.Produto;

public interface ProdutoDAO {
    
    void insert(Produto obj); 
    void update(Produto obj);
    void deleteById(Produto id);
    Produto findById(Long id);
    
}
