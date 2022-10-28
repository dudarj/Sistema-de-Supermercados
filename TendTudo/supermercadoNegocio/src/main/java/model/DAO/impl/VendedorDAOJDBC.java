/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.DAO.VendedorDAO;
import model.DTO.Vendedor;

public class VendedorDAOJDBC implements VendedorDAO {

    private Connection conn;
    Vendedor ve = new Vendedor();

    public VendedorDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Vendedor obj) {
        String sqlInsert = "INSERT INTO vendedor(nome, comissao) VALUES (?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setDouble(2, obj.getComissao());

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
    public void update(Vendedor obj) {
        String sqlUpdate = "UPDATE vendedor " + "SET nome=?, comissao=? WHERE codigo = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, obj.getNome());
            st.setDouble(2, obj.getComissao());
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM vendedor WHERE codigo = ? ";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Vendedor findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn
                    .prepareStatement("SELECT * FROM vendedor "
                            + "WHERE codigo = ?");

            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Vendedor obj = new Vendedor();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setComissao(rs.getDouble("comissao"));
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

    public List<Vendedor> ListarVendedores() {
        List<Vendedor> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM vendedor " + "ORDER BY nome");
            rs = st.executeQuery();

            while (rs.next()) {
                Vendedor obj = new Vendedor();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setComissao(rs.getDouble("comissao"));
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
