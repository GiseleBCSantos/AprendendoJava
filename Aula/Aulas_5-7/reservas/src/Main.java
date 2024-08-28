import equipamentos.ControleEquipamentos;
import espacos.ControleEspaco;
import equipamentos.Equipamento;
import espacos.Espaco;
import funcionarios.Chefia;
import funcionarios.ControleFuncionarios;
import funcionarios.Funcionario;
import funcionarios.Vigia;
import reservas.ControleReservas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ControleEquipamentos controle_equipamentos = new ControleEquipamentos();
        controle_equipamentos.registrar_equipamento(new Equipamento( "Impressora", 10, 1));
        controle_equipamentos.registrar_equipamento(new Equipamento("Grampeadora", 15, 10));


        ControleEspaco controle_espacos = new ControleEspaco();
        controle_espacos.registrar_espaco(new Espaco( "Sala B-10", false));
        controle_espacos.registrar_espaco(new Espaco( "Sala B-11", true));
        controle_espacos.registrar_espaco(new Espaco( "Sala B-12", true));


        ControleFuncionarios controle_funcionarios = new ControleFuncionarios();
        controle_funcionarios.cadastrar_funcionarios(new Vigia("Joao", "joao@gmail.com"));
        controle_funcionarios.cadastrar_funcionarios(new Chefia("Maria", "maria@gmail.com", "Gerente", "Financeiro", 1234));


        ControleReservas controleReservas = new ControleReservas();


        boolean programa_on = true;

        while (programa_on) {

            for (int i = 0; i < controle_funcionarios.getLista_funcionarios().size(); i++) {
                System.out.println(i + 1 + " - " + controle_funcionarios.getLista_funcionarios().get(i).getNome());
            }
            System.out.println("Insira seu código (0 para sair): ");
            int resposta_codigo = sc.nextInt();

            if (resposta_codigo == 0){
                System.out.println("Programa finalizado!");
                break;
            }

            if (resposta_codigo <= controle_funcionarios.getLista_funcionarios().size() + 1){
                Funcionario funcionario_atual = controle_funcionarios.getLista_funcionarios().get(resposta_codigo -1);

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
                        String data = sc.next();


                        if (funcionario_atual instanceof Chefia) {
                            System.out.println("Digite sua senha: ");
                            int senha = sc.nextInt();

                            if (((Chefia) funcionario_atual).autenticar(senha)){
                                Equipamento equipamento_escolhido = controle_equipamentos.getLista_equipamentos().get(opcao_equipamento);
                                controleReservas.add_reserva_equipamento(data, funcionario_atual, equipamento_escolhido);
                            }

                            else{
                                System.out.println("Senha incorreta, não foi possivel reservar!");
                            }

                        }
                        else{
                            Equipamento equipamento_escolhido = controle_equipamentos.getLista_equipamentos().get(opcao_equipamento);
                            controleReservas.add_reserva_equipamento(data, funcionario_atual, equipamento_escolhido);
                        }

                    }

                    if (resposta_reserva == 2){
                        if (! (funcionario_atual instanceof Chefia)){
                            System.out.println("Acao nao permitida!");
                        }
                        else{

                            System.out.println("Qual espaço deseja reservar? ");

                            for (int i = 0; i < controle_espacos.getLista_espacos().size(); i++){
                                System.out.println(i+1 + " - " + controle_espacos.getLista_espacos().get(i).getDescricao());
                            }

                            int opcao_espaco = sc.nextInt() - 1;

                            System.out.println("Em qual data voce deseja reservar? (Digite padrão dd/mm/aaaa)");
                            String data = sc.next();

                            System.out.println("Digite sua senha: ");
                            int senha = sc.nextInt();

                            if (((Chefia) funcionario_atual).autenticar(senha)){
                                Espaco espaco_escolhido = controle_espacos.getLista_espacos().get(opcao_espaco);
                                controleReservas.add_reserva_espaco(data, funcionario_atual, espaco_escolhido);

                            }

                            else{
                                System.out.println("Senha incorreta, não foi possivel reservar!");
                            }
                        }


                    }
                }
            else{
                System.out.println("Codigo invalido!");
            }

            System.out.println(controleReservas.getList_reservas());
        }


    }
}