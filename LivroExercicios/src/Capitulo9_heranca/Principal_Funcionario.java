package Capitulo9_heranca;

import Capitulo9_heranca.Funcionario.ControleDeBonificacoes;
import Capitulo9_heranca.Funcionario.Funcionario;
import Capitulo9_heranca.Funcionario.Gerente;

public class Principal_Funcionario {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        Funcionario funcionario = new Funcionario();

        funcionario.setSalario(5000.0);
        gerente.setNome("João");
        gerente.setSalario(5000);
        gerente.setSenha(4321);

        ControleDeBonificacoes controle = new ControleDeBonificacoes();

        controle.registra(gerente);
        controle.registra(funcionario);

        System.out.println(gerente.getBonificacao());
        System.out.println(funcionario.getBonificacao());

        System.out.println(controle.getTotalDeBonificacoes());
    }
}
