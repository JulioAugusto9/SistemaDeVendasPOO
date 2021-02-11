package fatec.poo.model;

/**
 *
 * @author Davi e Julio
 */
public class Cliente extends Pessoa {
    private double limiteCred;
    private double limiteDisp;
    private char sexo;

    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteCred=limiteCred;
        limiteDisp=limiteCred;
    }

    public void setLimiteCred(double limiteCred) {
        limiteDisp+=(limiteCred-this.limiteCred);
        this.limiteCred = limiteCred;
    }

    public void setLimiteDisp(double limiteDisp) {
        if (limiteDisp > limiteCred)
            limiteDisp = limiteCred;
        this.limiteDisp = limiteDisp;
    }

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }
    
    @Override
    public void addPedido(Pedido p){
        p.setCliente(this);
        super.addPedido(p);
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    
}
