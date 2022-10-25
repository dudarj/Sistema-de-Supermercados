package model.DAO;

import model.DTO.Cliente;

public interface ClienteDAO {
    void insert(Cliente obj); 
    void update(Cliente obj);
    void deleteById(Long id);
    Cliente findById(Long id);
}
