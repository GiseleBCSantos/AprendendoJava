package JDBC;

import JDBC.dao.ContatoDao;
import JDBC.modelo.Contato;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrincipalJDBC {
    public static void main(String[] args) throws SQLException{
        Scanner sc = new Scanner(System.in);

//        Contato contato = new Contato(1L, "Caelum2", "contato@caelum.com.br", "Rua 20", Calendar.getInstance());
//
//
        ContatoDao dao = new ContatoDao();
//        dao.adiciona(contato);
//
        List lista_contatos = dao.getLista();
        System.out.println(lista_contatos);
////
////
//        dao.altera(contato);
////
//        lista_contatos = dao.getLista();
//        System.out.println(lista_contatos);
////        List lista_contatos = dao.getLista();
////        Contato contato = (Contato) lista_contatos.get(0);
////        contato.setId(2L);
//
//        String enter = sc.next();
//
//        dao.remove(contato);
//
//        lista_contatos = dao.getLista();
//        System.out.println(lista_contatos);

    }


}
