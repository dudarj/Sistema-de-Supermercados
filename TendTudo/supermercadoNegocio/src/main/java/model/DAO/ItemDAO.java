package model.DAO;

import java.util.List;
import model.DTO.Item;


public interface ItemDAO {
    
    void insert(Item obj); 
    void update(Item obj);
    void deleteById(Long id);
    Item findById(Long id);
    List<Item> ListarItens();
    
}
