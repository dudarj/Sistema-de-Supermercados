package model.DTO;

import java.io.Serializable;
import java.util.Objects;


public class Item implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long codigo;
    private int quantidade;
    private double valorTotal;
    Produto p = new Produto();
    Venda v = new Venda();

    public Item() {
    }

    public Item(Long codigo, int quantidade, double valorTotal) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public Venda getV() {
        return v;
    }

    public void setV(Venda v) {
        this.v = v;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + this.quantidade;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
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
        final Item other = (Item) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + '}';
    }
}
