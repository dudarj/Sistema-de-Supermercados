package model.servicos;

import java.util.List;
import java.util.Set;

import model.DAO.DAOFactory;
import model.DAO.ItemDAO;
import model.DTO.Item;
import model.DTO.Produto;
import model.DTO.Venda;


public class ItemServico implements ItemDAO {

    private ItemDAO dao = DAOFactory.createItemDao();

    @Override
    public void insert(Set<Item> obj) {
        dao.insert(obj);
    }

    @Override
    public void update(Item obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Item findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Item> ListarItens() {
        // TODO Auto-generated method stub
        return null;
    }

    public void salvar(Item obj, Venda venda, Produto produto) {
        dao.salvar(obj, venda.getCodigo(), produto.getCodigo());
    }

    @Override
    public void salvar(Item obj, Long id_venda, Long id_produto) {
        // TODO Auto-generated method stub	
    }
}
