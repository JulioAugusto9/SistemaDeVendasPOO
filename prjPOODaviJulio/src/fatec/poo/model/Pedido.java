package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author JULIOAUGUSTORIBEIROD
 */
public class Pedido {
    private String numero;
    private String dataEmissao;
    private String dataPagto;
    private boolean formaPagto;
    private boolean situacao;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itensPedido;

    public Pedido(String numero, String dataEmissao) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        itensPedido = new ArrayList<ItemPedido>();
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setFormaPagto(boolean formaPagto) {
        this.formaPagto = formaPagto;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public String getNumero() {
        return numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public boolean isFormaPagto() {
        return formaPagto;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        itensPedido.add(itemPedido);
        itemPedido.setPedido(this);
        cliente.setLimiteDisp(cliente.getLimiteDisp() - itemPedido.calcValor());
    }
    
    public void removeItemPedido(int i) {
        cliente.setLimiteDisp(
                cliente.getLimiteDisp() + itensPedido.get(i).calcValor());
        itensPedido.get(i).setQtdeVendida(0);
        itensPedido.remove(i);
    }
    
    public double calcValorTotal() {
        double soma = 0;
        for (int i=0; i<itensPedido.size(); i++) {
            soma += itensPedido.get(i).calcValor();
        }
        return soma;
    }

    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedido;
    }
    
    
}
