package model.DAO;

import java.util.List;
import model.DTO.Cliente;

public interface ClienteDAO {
    void insert(Cliente obj); 
    void update(Cliente obj);
    void updateByCpf(Cliente obj);
    void deleteById(Long id);
    void deleteByCpf(String cpf);
    Cliente findById(Long id);
    List<Cliente> ListarClientes();
    Cliente validaUsuario(Cliente obj);
    Cliente findByLogin(String login);
    List<Cliente> findByNome(String nome);
    List<Cliente> findAll();
}
