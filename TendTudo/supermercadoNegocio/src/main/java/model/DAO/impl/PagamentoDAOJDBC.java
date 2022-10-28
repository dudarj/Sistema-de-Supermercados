package model.DAO.impl;

import conexao.ConexaoJdbc;
import conexao.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.List;
import model.DAO.PagamentoDAO;
import model.DTO.Pagamento;

public class PagamentoDAOJDBC implements PagamentoDAO {

    private Connection conn;

    public PagamentoDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Pagamento obj) {
        String sqlInsert = "INSERT INTO pagamento(parcelas) VALUES (?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert);
            st.setInt(1, obj.getParcelas());
            
            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    obj.setCodigo(id);
                }
                ConexaoJdbc.closeResultSet(rs);
            } else {
                throw new DbException("Erro inesperado, nehuma linha foi afetada!");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Pagamento obj) {
        String sqlUpdate = "UPDATE pagamento" + "SET parcelas = ? WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setInt(1, obj.getParcelas());
            st.setLong(2, obj.getCodigo());

            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM pagamento WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pagamento findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM pagamento "
                    + "WHERE codigo = ?");

            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Pagamento obj = new Pagamento();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setParcelas(rs.getInt("parcelas"));
                return obj;
            }

            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
            ConexaoJdbc.closeResultSet(rs);
        }
    }

    @Override
    public List<Pagamento> ListarPagamentos() {
        List<Pagamento> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM pagamento " + "ORDER BY parcelas");
            rs = st.executeQuery();

            while (rs.next()) {
                Pagamento obj = new Pagamento();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setParcelas(rs.getInt("parcelas"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
            ConexaoJdbc.closeResultSet(rs);
        }
    }
}
