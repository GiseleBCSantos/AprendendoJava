import dao.EquipamentoDao;
import dao.EspacoDao;
import equipamentos.Equipamento;
import espacos.Espaco;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);


        EquipamentoDao equipamentoDao = new EquipamentoDao();
//        EspacoDao espacoDao = new EspacoDao();

//        espacoDao.add(new Espaco("Sala B3-11", false));
//        espacoDao.add(new Espaco("Sala B3-12", true));


        equipamentoDao.add(new Equipamento(1, "Impressora", 10, 1));
        equipamentoDao.add(new Equipamento(2, "Grampeador", 20, 10));
        equipamentoDao.add(new Equipamento(3, "Monitor", 5, 2));
        Equipamento cadeira = new Equipamento(5, "Cadeira", 15, 5);


        System.out.println(equipamentoDao.get_list());

        System.out.println(equipamentoDao.get_item());
//        System.out.println(espacoDao.get_list());



        equipamentoDao.add(cadeira);

        sc.next();

        equipamentoDao.update(cadeira);

        sc.next();

        equipamentoDao.delete(cadeira);

        sc.next();

    }
}