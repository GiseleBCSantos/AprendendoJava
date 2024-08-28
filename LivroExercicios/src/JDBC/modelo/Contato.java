package JDBC.modelo;

import JDBC.dao.ContatoDao;

import java.sql.Date;
import java.util.Calendar;

public class Contato {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
    private Calendar dataNascimento;
    
    public Contato(Long id, String nome, String email, String endereco, Calendar dataNascimento){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return  "\nid=" + this.id +
                ", nome='" + this.nome + '\n' +
                ", email='" + this.email + '\n' +
                ", endereco='" + this.endereco + '\n'
//                ", dataNascimento=" + dataNascimento +
//                '\n'
                ;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
