package model.DAO;

import java.util.List;
import model.DTO.Pagamento;


public interface PagamentoDAO {
    void insert(Pagamento obj); 
    void update(Pagamento obj);
    void deleteById(Long id);
    Pagamento findById(Long id);
    void listar (Pagamento obj);
    List<Pagamento> ListarPagamentos();
}
