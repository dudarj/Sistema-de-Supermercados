package model.servicos;

import java.util.List;
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

    public void cadastrar(Cliente obj) {
        if (obj.getCodigo() == null) {
            dao.insert(obj);
        }
    }

    public List<Cliente> ListarClientes() {
        return dao.ListarClientes();
    }

}
