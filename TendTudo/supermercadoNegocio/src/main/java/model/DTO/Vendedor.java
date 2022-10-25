package model.DTO;

import java.io.Serializable;
import java.util.Objects;


public class Vendedor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long codigo;
    private String nome;
    private double comissao;

    public Vendedor() {
    }

    public Vendedor(Long codigo, String nome, double comissao) {
        this.codigo = codigo;
        this.nome = nome;
        this.comissao = comissao;
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

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.codigo);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.comissao) ^ (Double.doubleToLongBits(this.comissao) >>> 32));
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
        final Vendedor other = (Vendedor) obj;
        if (Double.doubleToLongBits(this.comissao) != Double.doubleToLongBits(other.comissao)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "codigo=" + codigo + ", nome=" + nome + ", comissao=" + comissao + '}';
    }  
}
