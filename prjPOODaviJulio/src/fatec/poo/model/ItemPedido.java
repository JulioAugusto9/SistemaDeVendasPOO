package fatec.poo.model;

/**
 *
 * @author JULIOAUGUSTORIBEIROD
 */
public class ItemPedido {
    private int sequencia;
    private double qtdeVendida;
    private Produto produto;
    private Pedido pedido;

    public ItemPedido(int sequencia, double qtdeVendida, Produto produto) {
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        this.produto = produto;
        produto.setQtdeEstoque(produto.getQtdeEstoque() - qtdeVendida);
    }
    
    public ItemPedido(ItemPedido outro) {
        this.sequencia = outro.getSequencia();
        this.qtdeVendida = outro.getQtdeVendida();
        this.produto = outro.getProduto();
    }

    public void setQtdeVendida(double qtdeVendida) {
        produto.setQtdeEstoque(produto.getQtdeEstoque() - (qtdeVendida - this.qtdeVendida));
        this.qtdeVendida = qtdeVendida;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getSequencia() {
        return sequencia;
    }

    public double getQtdeVendida() {
        return qtdeVendida;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }
    
    public double calcValor() {
        return produto.getPreco() * qtdeVendida;
    }
}
