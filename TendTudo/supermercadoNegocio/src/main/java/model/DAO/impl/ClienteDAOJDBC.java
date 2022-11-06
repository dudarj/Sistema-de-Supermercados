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
import model.DAO.ClienteDAO;
import model.DTO.Cliente;

public class ClienteDAOJDBC implements ClienteDAO {

    private Connection conn;

    public ClienteDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cliente obj) {
        String sqlInsert = "INSERT INTO cliente "
                + "(nome, cpf, telefone, endereco, status, login, senha) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getTelefone());
            st.setString(4, obj.getEndereco());
            st.setInt(5, obj.getStatus());
            st.setString(6, obj.getLogin());
            st.setString(7, obj.getSenha());

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
    public void update(Cliente obj) {
        String sqlUpdate = "UPDATE cliente "
                + "SET nome = ?, cpf = ?, telefone = ?, endereco = ?, status=? "
                + "WHERE codigo = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, obj.getNome());
            st.setString(2, obj.getCpf());
            st.setString(3, obj.getTelefone());
            st.setString(4, obj.getEndereco());
            st.setInt(5, obj.getStatus());
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        String sqlDelete = "DELETE FROM cliente WHERE codigo = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sqlDelete);
            st.setLong(1, id);
            st.executeUpdate();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ClienteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente findById(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM cliente "
                    + "WHERE codigo = ?");

            st.setLong(1, id);
            rs = st.executeQuery();

            if (rs.next()) {
                Cliente obj = new Cliente();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setStatus(rs.getInt("status"));
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
    public List<Cliente> ListarClientes() {
        List<Cliente> lista = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * " + "FROM cliente " + "ORDER BY nome");
            rs = st.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setStatus(rs.getInt("status"));
                obj.setTipo(rs.getString("tipo"));
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
    public Cliente validaUsuario(Cliente obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT login, senha, tipo FROM cliente "
                    + "WHERE login = ?, senha = ?, tipo = ? ");

            st.setString(1, obj.getLogin());
            st.setString(2, obj.getSenha());
            st.setString(3, obj.getTipo());

            rs = st.executeQuery();

            if (rs.next()) {
                Cliente c = new Cliente();
                c.setLogin(rs.getString("login"));
                c.setSenha(rs.getString("senha"));
                c.setTipo(rs.getString("tipo"));
                return c;
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
    public Cliente findByLogin(String login) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM cliente "
                    + "WHERE login = ?");

            st.setString(1, login);
            rs = st.executeQuery();

            if (rs.next()) {
                Cliente obj = new Cliente();
                obj.setCodigo(rs.getLong("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setStatus(rs.getInt("status"));
                obj.setLogin(rs.getString("login"));
                obj.setSenha(rs.getString("senha"));
                obj.setTipo(rs.getString("tipo"));
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
}
