/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Aluno
 */
public class Venda implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long codigo;
    private Date dataVenda;
    private double valorTotal;

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
