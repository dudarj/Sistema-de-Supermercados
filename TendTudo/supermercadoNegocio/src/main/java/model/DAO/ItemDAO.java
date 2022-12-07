package model.DAO;

import java.util.List;
import java.util.Set;
import model.DTO.Item;



public interface ItemDAO {
    
    void insert(Set<Item> obj);  
    void update(Item obj);
    void deleteById(Long id);
    Item findById(Long id);
    List<Item> ListarItens();
    
    void salvar(Item obj, Long id_venda, Long id_produto);
    
}
