package Capitulo10_abstracao.Funcionarios;

public class ControleDeBonificacoes {
    private double totalDeBonificacoes = 0;

    public void registra (Funcionario funcionario){
        System.out.println("Adicionando bonificação do funcionário: "+ funcionario);
        this.totalDeBonificacoes += funcionario.getBonificacao();
    }

    public double getTotalDeBonificacoes(){return this.totalDeBonificacoes;}
}
