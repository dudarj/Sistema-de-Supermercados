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
import model.DAO.VendaDAO;
import model.DTO.Cliente;
import model.DTO.Pagamento;
import model.DTO.TipoPagamento;
import model.DTO.Venda;

public class VendaDAOJDBC implements VendaDAO {

    private Connection conn;

    public VendaDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Venda obj) {
        String sqlVenda = "INSERT INTO venda(datavenda, valortotal) VALUES (?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS);
            st.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
            st.setDouble(2, obj.getValorTotal());

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
    public void update(Venda obj) {
        String sqlUpdate = "UPDATE venda " + "SET datavenda=?, valortotal=? WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setDate(1, new java.sql.Date(obj.getDataVenda().getTime()));
            st.setDouble(2, obj.getValorTotal());
            st.setLong(5, obj.getCodigo());
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DDELETE FROM venda WHERE codigo = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Venda findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM venda "
                    + "WHERE codigo = ?");

            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Venda obj = new Venda();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDataVenda(new java.util.Date(rs.getTimestamp("datavenda").getTime()));
                obj.setValorTotal(rs.getDouble("valortotal"));
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
    public List<Venda> ListarVendas() {
        List<Venda> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT c.nome, p.parcelas, ti.descricao FROM venda v "
                    + "inner join cliente c on v.codigo_cliente = c.codigo "
                    + "inner join pagamento p on v.codigo_pagamento = v.codigo "
                    + "inner join tipopagamento ti on v.codigo_tipopagamento = ti.codigo "
                    + "ORDER BY datavenda");

            rs = st.executeQuery();

            while (rs.next()) {
                Venda obj = new Venda();
                Cliente c = new Cliente();
                Pagamento p = new Pagamento();
                TipoPagamento ti = new TipoPagamento();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDataVenda(new java.util.Date(rs.getTimestamp("datavenda").getTime()));
                obj.setValorTotal(rs.getDouble("valortotal"));
                
                c.setCodigo(rs.getLong("codigo_cliente"));
                c.setNome(rs.getString("nome"));
                p.setCodigo(rs.getLong("codigo_pagamento"));
                p.setParcelas(rs.getInt("parcelas"));
                ti.setCodigo(rs.getLong("codigo_tipopagamento"));
                ti.setDescricao(rs.getString("descricao"));
                
                
                
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

/*    @Override
    public List<Venda> ListarVendas() {
        List<Venda> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM venda " + "ORDER BY datavenda");
            rs = st.executeQuery();

            while (rs.next()) {
                Venda obj = new Venda();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setDataVenda(new java.util.Date(rs.getTimestamp("datavenda").getTime()));
                obj.setValorTotal(rs.getDouble("valortotal"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            ConexaoJdbc.closeStatement(st);
            ConexaoJdbc.closeResultSet(rs);
        }
    }*/
