package model.DTO;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private Integer qtdeItem;
    private String img;

    public Produto() {
    }

    public Produto(Long codigo, String descricao, double preco, int quantidade, Integer qtdeItem, String img) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.qtdeItem = qtdeItem;
        this.img = img;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQtdeItem() {
        return qtdeItem;
    }

    public void setQtdeItem(Integer qtdeItem) {
        this.qtdeItem = qtdeItem;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 97 * hash + this.quantidade;
        hash = 97 * hash + Objects.hashCode(this.qtdeItem);
        hash = 97 * hash + Objects.hashCode(this.img);
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
        final Produto other = (Produto) obj;
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return Objects.equals(this.qtdeItem, other.qtdeItem);
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + ", quantidade=" + quantidade + ", qtdeItem=" + qtdeItem + ", img=" + img + '}';
    }

}
