package model.DAO;

import java.util.List;
import model.DTO.Cliente;

public interface ClienteDAO {
    void insert(Cliente obj); 
    void update(Cliente obj);
    void deleteById(Long id);
    Cliente findById(Long id);
    void listar(Cliente obj);
    List<Cliente> ListarClientes();
}
