package model.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long codigo;
    private Date dataVenda;
    private double valorTotal;

    private Cliente cliente = new Cliente();

    private List<Item> itens = new ArrayList<>();
    

    private Pagamento p = new Pagamento();
    private TipoPagamento ti = new TipoPagamento();

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
        this.valorTotal = SomarTotalVenda(itens);
    }

    public Double SomarTotalVenda(List<Item> itens) {

        Double total = 0.0;

        for (Item x : itens) {
            total = x.getValorTotal();
        }

        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
