package JDBC.dao;

import JDBC.ConnectionFactory;
import JDBC.modelo.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ContatoDao {
    private Connection conn;


    public ContatoDao() throws SQLException {
        this.conn = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato){
        String sql = "insert into contatos " + "(id,nome,email,endereco,dataNascimento)" + " values (?,?,?,?,?)";



        try{
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, contato.getId());
            stmt.setString(2, contato.getNome());
            stmt.setString(3, contato.getEmail());
            stmt.setString(4, contato.getEndereco());
            stmt.setDate(5, new Date(contato.getDataNascimento().getTimeInMillis()));

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List getLista() throws SQLException {
        PreparedStatement stmt = this.conn.prepareStatement("select * from contatos");

        ResultSet rs = stmt.executeQuery();

        List<Contato> contatos = new ArrayList<Contato>();

        while (rs.next()){
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            Contato contato = new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("email"), rs.getString("endereco"), data);

            contatos.add(contato);
        }

        rs.close();
        stmt.close();

        return contatos;
    }


    public List getItem() throws SQLException{
        PreparedStatement stmt = this.conn.prepareStatement("select * from contatos where id=?");


        ResultSet rs = stmt.executeQuery();

        List<Contato> lista_contato = new ArrayList<Contato>();

        while (rs.next()){
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            Contato contato = new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("email"), rs.getString("endereco"), data);

            lista_contato.add(contato);
        }

        rs.close();
        stmt.close();

        return lista_contato;
    }


    public void remove(Contato contato){
        try{
            PreparedStatement stmt = conn.prepareStatement("delete " + "from contatos where id=?");
            stmt.setLong(1, 5);
            stmt.execute();
            stmt.close();

            System.out.println("Contato removido!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void altera(Contato contato){
        String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
        Scanner sc = new Scanner(System.in);

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println("Nome atual: " + contato.getNome()+ ". Insira o novo nome: ");
            String novoNome = sc.nextLine();
            stmt.setString(1, novoNome);
            System.out.println("Email atual: " + contato.getEmail()+ ". Insira o novo email: ");
            String novoEmail = sc.nextLine();
            stmt.setString(2, novoEmail);
            System.out.println("Endereco atual: " + contato.getEndereco()+ ". Insira o novo endereco: ");
            String novoEndereco = sc.nextLine();
            stmt.setString(3, novoEndereco);
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            stmt.setLong(5, 5);
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
