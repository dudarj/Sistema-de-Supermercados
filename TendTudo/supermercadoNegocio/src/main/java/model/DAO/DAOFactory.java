package model.DAO;

import conexao.ConexaoJdbc;
import model.DAO.impl.ClienteDAOJDBC;
import model.DAO.impl.ItemDAOJDBC;
import model.DAO.impl.PagamentoDAOJDBC;
import model.DAO.impl.ProdutoDAOJDBC;
import model.DAO.impl.TipoPagamentoDAOJDBC;
import model.DAO.impl.VendaDAOJDBC;
import model.DAO.impl.VendedorDAOJDBC;


public class DAOFactory {

    public static ClienteDAOJDBC createClienteDao() {
        return new ClienteDAOJDBC(ConexaoJdbc.getConnection());
    }

    public static ProdutoDAOJDBC createProdutoDao() {
        return new ProdutoDAOJDBC(ConexaoJdbc.getConnection());
    }

    public static VendaDAOJDBC createVendaDao() {
        return new VendaDAOJDBC(ConexaoJdbc.getConnection());
    }

    public static PagamentoDAOJDBC createPagamentoDao() {
        return new PagamentoDAOJDBC(ConexaoJdbc.getConnection());
    }

    public static VendedorDAOJDBC createVendedorDao() {
        return new VendedorDAOJDBC(ConexaoJdbc.getConnection());
    }

    public static ItemDAOJDBC createItemDao() {
        return new ItemDAOJDBC(ConexaoJdbc.getConnection());
    }

    public static TipoPagamentoDAOJDBC createTipoPagamentoDao() {
        return new TipoPagamentoDAOJDBC(ConexaoJdbc.getConnection());
    }
}
