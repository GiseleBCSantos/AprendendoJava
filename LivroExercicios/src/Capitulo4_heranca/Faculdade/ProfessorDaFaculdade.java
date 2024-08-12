package Capitulo4_heranca.Faculdade;

import Capitulo4_heranca.Funcionario.Funcionario;

public class ProfessorDaFaculdade extends EmpregadoDaFaculdade {
    private int horasDeAula;

    public double getGastos(){
        return this.getSalario() + this.horasDeAula * 10;
    }

    public int getHorasDeAula() {
        return horasDeAula;
    }

    public void setHorasDeAula(int horasDeAula) {
        this.horasDeAula = horasDeAula;
    }

    public String getInfo(){
        String informacaoBasica = super.getInfo();
        String informacao = informacaoBasica + " horas de aula: " + horasDeAula;

        return informacao;
    }
}
