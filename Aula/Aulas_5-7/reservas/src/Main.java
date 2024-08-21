import obj_reserva.ControleEquipamentos;
import obj_reserva.ControleEspaco;
import obj_reserva.Equipamento;
import obj_reserva.Espaco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Equipamento impressora = new Equipamento( "Impressora", 10, 1);
        Equipamento grampeador = new Equipamento("Grampeadora", 15, 10);

        ControleEquipamentos controle_equipamentos = new ControleEquipamentos();
        controle_equipamentos.registrar_equipamento(impressora);
        controle_equipamentos.registrar_equipamento(grampeador);


        Espaco sala_b12 = new Espaco( "Sala B-12", true);
        Espaco sala_b10 = new Espaco( "Sala B-10", false);
        Espaco sala_b11 = new Espaco( "Sala B-11", true);

        ControleEspaco controle_espacos = new ControleEspaco();
        controle_espacos.registrar_espaco(sala_b10);
        controle_espacos.registrar_espaco(sala_b11);
        controle_espacos.registrar_espaco(sala_b12);


        Vigia funcionario_joao = new Vigia("Joao", "joao@gmail.com", 1234);
        Chefia chefia_maria = new Chefia("Maria", "maria@gmail.com", "Gerente", "Financeiro", 1234);

        ControleFuncionarios controle_funcionarios = new ControleFuncionarios();
        controle_funcionarios.cadastrar_funcionarios(funcionario_joao);
        controle_funcionarios.cadastrar_funcionarios(chefia_maria);

//         Criação manualmente
//        System.out.println("------------------------------------------");
//
//        funcionario_joao.reservar_equipamento("13/05/2024", impressora);
//        System.out.println("------------------------------------------");
//        funcionario_joao.reservar_equipamento("14/05/2024", impressora);
//        System.out.println("------------------------------------------");
//
//        chefia_maria.reservar_espaco("13/03/2024", sala_b10);
//        System.out.println("------------------------------------------");
//
//        chefia_maria.reservar_espaco("13/03/2024", sala_b11);
//
//        System.out.println("------------------------------------------");




        boolean programa_on = true;

        while (programa_on) {

            for (int i = 0; i < controle_funcionarios.getLista_funcionarios().size(); i++) {
                System.out.println(i + 1 + " - " + controle_funcionarios.lista_funcionarios.get(i).getNome());
            }
            System.out.println("Insira seu código (0 para sair): ");
            int resposta_codigo = sc.nextInt();

            if (resposta_codigo == 0){
                System.out.println("Programa finalizado!");
                break;
            }

            if (resposta_codigo <= controle_funcionarios.lista_funcionarios.size() + 1){
                Funcionario funcionario_atual = controle_funcionarios.lista_funcionarios.get(resposta_codigo -1);

                if (funcionario_atual instanceof Chefia){
                    System.out.println("""
                        O que deseja?
                        1 - Reservar equipamento
                        2 - Reservar espaço""");

                    int resposta_reserva = sc.nextInt();

                    if (resposta_reserva == 1){
                        System.out.println("Qual equipamento deseja reservar? ");

                        for (int i = 0; i < controle_equipamentos.getLista_equipamentos().size(); i++){
                            System.out.println(i+1 + " - " + controle_equipamentos.getLista_equipamentos().get(i).getDescricao());
                        }

                        int opcao_equipamento = sc.nextInt() - 1;

                        System.out.println("Em qual data você deseja reservar? (Digite padrão dd/mm/aaaa)");
                        String data2 = sc.nextLine();
                        String data = sc.nextLine();

                        System.out.println("Digite sua senha: ");
                        int senha = sc.nextInt();

                        if (((Chefia) funcionario_atual).autenticar(senha)){
                            funcionario_atual.reservar_equipamento(data, controle_equipamentos.getLista_equipamentos().get(opcao_equipamento));

                        }

                        else{
                            System.out.println("Senha incorreta, não foi possivel reservar!");
                        }


                    }

                    if (resposta_reserva == 2){
                        System.out.println("Qual espaço deseja reservar? ");

                        for (int i = 0; i < controle_espacos.getLista_espacos().size(); i++){
                            System.out.println(i+1 + " - " + controle_espacos.getLista_espacos().get(i).getDescricao());
                        }

                        int opcao_espaco = sc.nextInt() - 1;

                        System.out.println("Em qual data voce deseja reservar? (Digite padrão dd/mm/aaaa)");
                        String data2 = sc.nextLine();
                        String data = sc.nextLine();

                        System.out.println("Digite sua senha: ");
                        int senha = sc.nextInt();

                        if (((Chefia) funcionario_atual).autenticar(senha)){
                            ((Chefia) funcionario_atual).reservar_espaco(data, controle_espacos.getLista_espacos().get(opcao_espaco));

                        }

                        else{
                            System.out.println("Senha incorreta, não foi possivel reservar!");
                        }


                    }
                }

                else{
                    System.out.println("Qual equipamento deseja reservar? ");

                    for (int i = 0; i < controle_equipamentos.getLista_equipamentos().size(); i++){
                        System.out.println(i+1 + " - " + controle_equipamentos.getLista_equipamentos().get(i).getDescricao());
                    }

                    int opcao_equipamento = sc.nextInt() - 1;

                    System.out.println("Em qual data você deseja reservar? (Digite padrão dd/mm/aaaa)");
                    String data2 = sc.nextLine();
                    String data = sc.nextLine();


                    funcionario_atual.reservar_equipamento(data, controle_equipamentos.getLista_equipamentos().get(opcao_equipamento));
                }
            }


        }


    }
}