import equipamentos.EquipamentoDao;
import espacos.EspacoDao;
import funcionarios.FuncionarioDao;
import reservas.ReservaDao;
import equipamentos.Equipamento;
import espacos.Espaco;
import funcionarios.Chefia;
import funcionarios.Funcionario;
import reservas.Reserva;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        EspacoDao espacoDao = new EspacoDao();
        EquipamentoDao equipamentoDao = new EquipamentoDao();
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        ReservaDao reservaDao = new ReservaDao();

//        espacoDao.add(new Espaco(1, "B3-10", true));
//        espacoDao.add(new Espaco(2, "B3-11", true));
//        espacoDao.add(new Espaco(3, "B3-12", true));
//        espacoDao.add(new Espaco(4, "B3-18", true));

//        equipamentoDao.add(new Equipamento(1, "Impressora", 20, 10));
//        equipamentoDao.add(new Equipamento(2, "Grampeador", 5, 1));
//        equipamentoDao.add(new Equipamento(3, "Monitor", 5, 3));

//        funcionarioDao.add(new Chefia("Maria", "maria@gmail.com", "Gerente", "Financeiro", 1234));
//        funcionarioDao.add(new Vigia("Joao", "joao@gmail.com"));

        List<Funcionario> lista_funcionarios = funcionarioDao.list_funcionarios();
        List<Equipamento> lista_equipamentos = equipamentoDao.get_list();
        List<Espaco> lista_espacos = espacoDao.get_list();

        boolean app_on = true;

        while (app_on){

            exibir_lista_nomes(lista_funcionarios, "FUNCIONARIOS");

            System.out.println("Insira seu codigo (0 para sair): ");

            int resposta_funcionario = get_number_in_range(0, lista_funcionarios.size(), sc);

            if (resposta_funcionario == 0){
                app_on = false;
            }
            else{
                Funcionario funcionario_atual = lista_funcionarios.get(resposta_funcionario-1);

                System.out.println(
                        "\nO que deseja?" +
                        "\n1) Reservar equipamento" +
                        "\n2) Reservar espaco");

                int opcao_reserva = get_number_in_range(1, 2, sc);



                if (opcao_reserva == 1){

                    exibir_lista_nomes(lista_equipamentos, "EQUIPAMENTOS");
                    int resposta_equipamento = get_number_in_range(0, lista_equipamentos.size(), sc);

                    Equipamento equipamento_atual = lista_equipamentos.get(resposta_equipamento - 1);

                    String data = obter_data(sc);

                    reservaDao.add(new Reserva(data, funcionario_atual, equipamento_atual));
                }

                if (opcao_reserva == 2){
                    if ((funcionario_atual instanceof  Chefia)){
                        exibir_lista_nomes(lista_espacos, "ESPACOS");
                        int resposta_espaco = get_number_in_range(0, lista_espacos.size(), sc);
                        Espaco espaco_atual = lista_espacos.get(resposta_espaco - 1);

                        String data = obter_data(sc);

                        reservaDao.add(new Reserva(data, funcionario_atual, espaco_atual));

                    }
                    else{
                        System.out.println("Nao autorizado!");
                    }

                }

            }



        }
    }




    public static void exibir_lista_nomes(List lista, String tipo) throws SQLException{
//        List<String> lista_nomes = new ArrayList<String>();
        System.out.println("**** " + tipo + " ****");

        for (int i=0;i<lista.size();i++){
//            lista_nomes.add(lista_funcionarios.get(i).getNome());
            if (lista.get(i) instanceof Funcionario) {
                System.out.println(i+1 + " - " + ((Funcionario) lista.get(i)).getNome());
            }
            if (lista.get(i) instanceof Espaco) {
                System.out.println(i+1 + " - " + ((Espaco) lista.get(i)).getDescricao());
            }
            if (lista.get(i) instanceof Equipamento){
                System.out.println(i+1 + " - " + ((Equipamento) lista.get(i)).getDescricao());
            }
        }

    }

    public static int get_number_in_range(int min, int max, Scanner sc){
        int number = sc.nextInt();
        return number <= max || number >= min ? number : get_number_in_range(min, max, sc);
    }

    public static String obter_data(Scanner sc){
        System.out.println("Para qual data deseja reservar? ");
        return sc.next();
    }
}