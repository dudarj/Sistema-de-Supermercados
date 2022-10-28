package model.DTO;

import java.io.Serializable;
import java.util.Objects;

public class Pagamento implements Serializable {
    
    private Long codigo;
    private int parcelas;

    public Pagamento() {
    }

    public Pagamento(Long codigo, int parcelas) {
        this.codigo = codigo;
        this.parcelas = parcelas;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + this.parcelas;
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
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Pagamento{" + "codigo=" + codigo + ", parcelas=" + parcelas + '}';
    }
}