package model.DAO;

import java.util.List;
import model.DTO.Vendedor;

public interface VendedorDAO {
    void insert(Vendedor obj); 
    void update(Vendedor obj);
    void deleteById(Vendedor id);
    Vendedor findById(Long id);
    List<Vendedor> ListarVendedores();
}
