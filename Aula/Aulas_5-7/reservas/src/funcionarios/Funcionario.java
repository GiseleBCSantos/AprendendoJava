package funcionarios;

import equipamentos.Equipamento;
import interfaces.EnviarEmail;

public abstract class Funcionario implements EnviarEmail {
    static int id;
    String nome;
    String email;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Funcionario.id = id;
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
        Funcionario.id++;
        this.nome = nome;
        this.email = email;

    }

    public void enviar_email(String data){
        System.out.println("\n*** Email enviado***\nVoce fez uma reserva na data "+data+" .\n*********************\n");
    }

}
