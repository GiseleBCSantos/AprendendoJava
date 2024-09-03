package funcionarios;

import interfaces.EnviarEmail;

public abstract class Funcionario implements EnviarEmail {
    static int id;
    private int id_funcionario;
    String nome;
    String email;

    public int getId() {
        return this.id_funcionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Funcionario(String nome, String email){
        this.id_funcionario = Funcionario.id;
        this.nome = nome;
        this.email = email;
        Funcionario.id++;

    }

    public void enviar_email(String data){
        System.out.println("\n*** Email enviado***\nVoce fez uma reserva na data "+data+" .\n*********************\n");
    }

    @Override
    public String toString() {
        return "\nNome: " + getNome() +
                "\nEmail: " + getEmail() ;
    }
}
