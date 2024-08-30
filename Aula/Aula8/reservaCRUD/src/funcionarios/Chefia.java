package funcionarios;

import espacos.Espaco;
import interfaces.Autenticacao;

public class Chefia extends Funcionario implements Autenticacao {
    private String cargo;
    private String setor;
    private int senha;

    public String getCargo() {
        return cargo;
    }

    public String getSetor() {
        return setor;
    }

    public int getSenha() {
        return senha;
    }


    public Chefia(String nome, String email, String cargo, String setor, int senha){
        super(nome, email);
        this.cargo = cargo;
        this.setor = setor;
        this.senha = senha;
    }

    public boolean autenticar(int senha){
        return this.senha == senha;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nCargo: " + getCargo() +
                "\nSetor: " + getSetor() +
                "\n";
    }
}
