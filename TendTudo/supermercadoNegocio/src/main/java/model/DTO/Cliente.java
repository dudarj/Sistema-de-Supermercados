package model.DTO;

import java.io.Serializable;
import java.util.Objects;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private int status;
    private String login;
    private String senha;
    private String tipo;
    Venda v = new Venda();

    public Cliente() {
    }

    public Cliente(Long codigo, String nome, String cpf, String telefone, String endereco, int status) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = status;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Venda getV() {
        return v;
    }

    public void setV(Venda v) {
        this.v = v;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.telefone);
        hash = 97 * hash + Objects.hashCode(this.endereco);
        hash = 97 * hash + this.status;
        hash = 97 * hash + Objects.hashCode(this.login);
        hash = 97 * hash + Objects.hashCode(this.senha);
        hash = 97 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco=" + endereco + ", status=" + status + ", login=" + login + ", senha=" + senha + ", tipo=" + tipo + '}';
    }

}
