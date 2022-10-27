package model.DAO;

import java.util.List;
import model.DTO.Produto;

public interface ProdutoDAO {
    
    void insert(Produto obj); 
    void update(Produto obj);
    void deleteById(Long id);
    Produto findById(Long id);
    void listar (Produto obj);
    List<Produto> ListarProdutos();
    
}
