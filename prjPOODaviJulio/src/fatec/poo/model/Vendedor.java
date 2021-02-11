package fatec.poo.model;

/**
 *
 * @author Davi
 */
public class Vendedor extends Pessoa{

    private double salarioBase;
    private double taxaComissao;

    public Vendedor(String cpf, String nome, double salarioBase) {
        super(cpf, nome);
        this.salarioBase = salarioBase;
    }


    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }
    
    @Override
    public void addPedido(Pedido p){
        p.setVendedor(this);
        super.addPedido(p);
    }
    
    public double calcComissao() {
        double totalVendas = 0;
        for (int i=0; i<getPedidos().size(); i++) {
            totalVendas += getPedidos().get(i).calcValorTotal();
        }
        return totalVendas * (taxaComissao / 100);
    }
    
}
