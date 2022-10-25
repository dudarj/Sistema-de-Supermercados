package model.DTO;

import java.io.Serializable;
import java.util.Objects;

public class Pagamento implements Serializable {
    
    private Long codigo;
    private String descricao;
    private int parcelas;

    public Pagamento() {
    }

    public Pagamento(Long codigo, String descricao, int parcelas) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.parcelas = parcelas;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.descricao);
        hash = 53 * hash + this.parcelas;
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
        final Pagamento other = (Pagamento) obj;
        if (this.parcelas != other.parcelas) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "codigo=" + codigo + ", descricao=" + descricao + ", parcelas=" + parcelas + '}';
    }
}
