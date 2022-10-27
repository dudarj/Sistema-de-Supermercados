package model.DAO;

import java.util.List;
import model.DTO.Vendedor;

public interface VendedorDAO {
    void insert(Vendedor obj); 
    void update(Vendedor obj);
    void deleteById(Long id);
    Vendedor findById(Long id);
    void listar (Vendedor obj);
    List<Vendedor> ListarVendedores();
}
