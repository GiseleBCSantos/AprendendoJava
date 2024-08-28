package Capitulo10_abstracao.Funcionarios;

public class Gerente extends Funcionario{


    @Override
    public double getBonificacao() {
        return this.salario * 1.4 + 1000;
    }
}
