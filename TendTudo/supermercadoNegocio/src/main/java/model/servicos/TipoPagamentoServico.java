package model.servicos;

import java.util.List;
import model.DAO.DAOFactory;
import model.DAO.TipoPagamentoDAO;
import model.DTO.TipoPagamento;


public class TipoPagamentoServico {
    
    private TipoPagamentoDAO dao = DAOFactory.createTipoPagamentoDao();

    public void salvar(TipoPagamento obj) {
        if (obj.getCodigo() == null) {
            dao.insert(obj);
        } else {
            dao.update(obj);
        }
    }

    public List<TipoPagamento> ListarTiposPagamentos() {
        return dao.ListarTiposPagamentos();
    }

    public void remove(TipoPagamento obj) {
        dao.deleteById(obj.getCodigo());
    }

    public List<TipoPagamento> findAll() {
        return dao.findAll();
    }

    public List<TipoPagamento> findByNome(String nome) {
        return dao.findByNome(nome);
    }
    
}
