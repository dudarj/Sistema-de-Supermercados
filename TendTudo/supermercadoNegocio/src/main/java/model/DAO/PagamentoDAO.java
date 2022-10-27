package model.DAO;

import java.util.List;
import model.DTO.Pagamento;


public interface PagamentoDAO {
    void insert(Pagamento obj); 
    void update(Pagamento obj);
    void deleteById(Pagamento id);
    Pagamento findById(Long id);
    List<Pagamento> ListarPagamentos();
}
