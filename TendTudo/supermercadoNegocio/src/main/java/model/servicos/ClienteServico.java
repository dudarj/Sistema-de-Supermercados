package model.servicos;

import model.DAO.ClienteDAO;
import model.DAO.DAOFactory;
import model.DTO.Cliente;


public class ClienteServico {
    
    private ClienteDAO dao = DAOFactory.createClienteDao();
    
    public Cliente validaUsuario(Cliente obj) {
        return dao.validaUsuario(obj);
    }
    
    public Cliente findByLogin(String login) {
        return dao.findByLogin(login);
    }
}
