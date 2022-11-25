package model.DAO.impl;

import conexao.ConexaoJdbc;
import conexao.DbException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.List;
import model.DAO.TipoPagamentoDAO;
import model.DTO.TipoPagamento;


public class TipoPagamentoDAOJDBC implements TipoPagamentoDAO {

    TipoPagamento t = new TipoPagamento();
    private Connection conn;

    public TipoPagamentoDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(TipoPagamento obj) {
        String sqlInsert = "INSERT INTO tipopagamento(descricao) VALUES (?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getDescricao());

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
    public void update(TipoPagamento obj) {     
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE tipopagamento " + "SET descricao = ? WHERE codigo = ? ");

            st.setString(1, obj.getDescricao());
            st.setLong(2, obj.getCodigo());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM tipopagamento WHERE codigo = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public TipoPagamento findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM tipopagamento "
                    + "WHERE codigo = ?");

            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                TipoPagamento obj = new TipoPagamento();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDescricao(rs.getString("descricao"));
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
    public List<TipoPagamento> ListarTiposPagamentos() {
        List<TipoPagamento> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM tipopagamento " + "ORDER BY descricao");
            rs = st.executeQuery();

            while (rs.next()) {
                TipoPagamento obj = new TipoPagamento();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDescricao(rs.getString("descricao"));
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

    @Override
    public List<TipoPagamento> findByNome(String nome) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String sql = "select * "
                    + " from tipopagamento p "
                    + " where p.descricao LIKE '%" + nome + "%' ";
            st = conn.prepareStatement(sql);
            List<TipoPagamento> list = new ArrayList<>();

            rs = st.executeQuery();
            while (rs.next()) {
                TipoPagamento obj = new TipoPagamento();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDescricao(rs.getString("descricao"));
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
            ConexaoJdbc.closeResultSet(rs);
        }
    }

    @Override
    public List<TipoPagamento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
