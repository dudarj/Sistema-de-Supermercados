/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DTO;

import java.util.Objects;

public class ProdutosDTO {
    
        private String nomeDoProduto;
        private String codigoDoProduto;
        private double valorDoProduto;

    public ProdutosDTO(String nomeDoProduto, String codigoDoProduto, double valorDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.codigoDoProduto = codigoDoProduto;
        this.valorDoProduto = valorDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public void setCodigoDoProduto(String codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public double getValorDoProduto() {
        return valorDoProduto;
    }

    public void setValorDoProduto(double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nomeDoProduto);
        hash = 53 * hash + Objects.hashCode(this.codigoDoProduto);
        hash = 53 * hash + Objects.hashCode(this.valorDoProduto);
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
        final ProdutosDTO other = (ProdutosDTO) obj;
        if (Double.doubleToLongBits(this.valorDoProduto) != Double.doubleToLongBits(other.valorDoProduto)) {
            return false;
        }
        if (!Objects.equals(this.nomeDoProduto, other.nomeDoProduto)) {
            return false;
        }
        return Objects.equals(this.codigoDoProduto, other.codigoDoProduto);
    }
    
}
