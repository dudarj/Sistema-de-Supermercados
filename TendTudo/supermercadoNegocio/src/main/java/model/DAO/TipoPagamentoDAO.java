package model.DAO;

import java.util.List;
import model.DTO.TipoPagamento;


public interface TipoPagamentoDAO {
    void insert(TipoPagamento obj); 
    void update(TipoPagamento obj);
    void deleteById(Long id);
    TipoPagamento findById(Long id);
    void listar (Long id);
    List<TipoPagamento> ListarTiposPagamentos();
}
