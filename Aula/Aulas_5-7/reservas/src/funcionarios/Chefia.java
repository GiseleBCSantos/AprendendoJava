package funcionarios;

import espacos.Espaco;
import interfaces.Autenticacao;

public class Chefia extends Funcionario implements Autenticacao {
    String cargo;
    String setor;
    int senha;

    public Chefia(String nome, String email, String cargo, String setor, int senha){
        super(nome, email);
        this.cargo = cargo;
        this.setor = setor;
        this.senha = senha;
    }

    public boolean autenticar(int senha){
        return this.senha == senha;
    }
}
