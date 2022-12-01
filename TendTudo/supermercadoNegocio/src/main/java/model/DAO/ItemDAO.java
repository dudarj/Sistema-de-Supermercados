package model.DAO;

import java.util.List;
import model.DTO.Item;
import model.DTO.Produto;
import model.DTO.Venda;


public interface ItemDAO {
    
    void insert(Item obj, Produto p, Venda v); 
    void update(Item obj);
    void deleteById(Long id);
    Item findById(Long id);
    List<Item> ListarItens();
    
    void salvar(Item obj, Long id_venda, Long id_produto);
    
}
