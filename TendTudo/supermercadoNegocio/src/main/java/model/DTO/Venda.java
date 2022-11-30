package model.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Venda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long codigo;
    private Date dataVenda = new Date();
    private double valorTotal;
    private Cliente c = new Cliente();
    private Pagamento p = new Pagamento();
    TipoPagamento ti = new TipoPagamento();
    
    public Venda() {
    }

    public Venda(Long codigo, Date dataVenda, double valorTotal) {
        this.codigo = codigo;
        this.dataVenda = dataVenda;
        this.valorTotal = valorTotal;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public Pagamento getP() {
        return p;
    }

    public void setP(Pagamento p) {
        this.p = p;
    }

    public TipoPagamento getTi() {
        return ti;
    }

    public void setTi(TipoPagamento ti) {
        this.ti = ti;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.dataVenda);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
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
        final Venda other = (Venda) obj;
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", dataVenda=" + dataVenda + ", valorTotal=" + valorTotal + '}';
    }   
}
