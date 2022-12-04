package model.DTO;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codigo;
    private Integer quantidade;
    private double preco;
    private double valorTotal;

    private Produto produto;
    private Venda venda;

    public Item() {
    }

    public Item(Long codigo, Integer quantidade, double preco, double valorTotal, Produto produto, Venda venda) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.preco = preco;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.venda = venda;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.quantidade);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.produto);
        hash = 79 * hash + Objects.hashCode(this.venda);
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
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.quantidade, other.quantidade)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return Objects.equals(this.venda, other.venda);
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", quantidade=" + quantidade + ", preco=" + preco + ", valorTotal=" + valorTotal + ", produto=" + produto + ", venda=" + venda + '}';
    }

}