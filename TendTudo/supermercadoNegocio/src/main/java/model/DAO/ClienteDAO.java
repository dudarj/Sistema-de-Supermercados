package model.DAO;

import java.util.List;
import model.DTO.Cliente;

public interface ClienteDAO {
    void insert(Cliente obj); 
    void update(Cliente obj);
    void deleteById(Long id);
    Cliente findById(Long id);
    List<Cliente> ListarClientes();
    Cliente validaUsuario(Cliente obj);
    Cliente findByLogin(String login);
}
