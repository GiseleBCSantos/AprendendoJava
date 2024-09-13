package classes.funcionario;

import interfaces.EnviarEmail;

public abstract class Funcionario implements EnviarEmail {
    private int id;
    private String nome;
    private String email;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
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
        this.nome = nome;
        this.email = email;
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
