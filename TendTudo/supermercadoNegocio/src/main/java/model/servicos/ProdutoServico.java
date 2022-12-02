package model.servicos;

import java.util.List;
import model.DAO.DAOFactory;
import model.DAO.ProdutoDAO;
import model.DTO.Produto;

public class ProdutoServico {

    private ProdutoDAO dao = DAOFactory.createProdutoDao();

    public void salvar(Produto obj) {
        if (obj.getCodigo() == null) {
            dao.insert(obj);
        } else {
            dao.update(obj);
        }
    }

    public List<Produto> ListarProdutos() {
        return dao.ListarProdutos();
    }

    public void remove(Produto obj) {
        dao.deleteById(obj.getCodigo());
    }

    public List<Produto> findAll() {
        return dao.findAll();
    }

    public List<Produto> findByNome(String nome) {
        return dao.findByNome(nome);
    }
    
    public void updateSupermercado(Produto obj) {
    	dao.updateSupermercado();
    }
}
