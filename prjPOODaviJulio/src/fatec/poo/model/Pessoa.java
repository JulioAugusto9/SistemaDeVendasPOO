package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Davi e Julio
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;
    private ArrayList <Pedido> pedidos;
    
    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        pedidos = new ArrayList <Pedido>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public String getDdd() {
        return ddd;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void addPedido(Pedido p){
        pedidos.add(p);
    }
    
    public static boolean validarCPF(String cpfComSimb) {
        int valor, i;
        ArrayList<Integer> cpf = new ArrayList<Integer>();
        
        for (i=0; i<cpfComSimb.length(); i++) {
            if (cpfComSimb.charAt(i) >= '0' && cpfComSimb.charAt(i) <= '9') {
                cpf.add(Integer.parseInt(cpfComSimb.substring(i, i+1)));
            }
        }
        
        if (cpf.size() != 11) {
            return false;
        }
        
        for (i=0; i<cpf.size()-1; i++) {
            if (cpf.get(i) != cpf.get(i+1))
                break;
        }
        if (i == cpf.size()-1)
            return false;
        
        valor=0;
        for (i=1; i<=9; i++) {
            valor += (cpf.get(i-1) * i);
        }
        valor = (valor % 11);
        if (valor == 10)
            valor = 0;
        if (valor != cpf.get(i-1)) {
            return false;
        }
        
        valor = 0;
        for (i=1; i<=10; i++) {
            valor += (cpf.get(i-1) * (12 - i));
        }
        valor = ((valor * 10) % 11);
        if (valor == 10)
            valor = 0;
        if (valor != cpf.get(i-1)) {
            return false;
        }
        
        return true;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    
}
