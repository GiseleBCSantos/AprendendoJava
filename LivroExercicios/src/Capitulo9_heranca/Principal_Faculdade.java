package Capitulo9_heranca;

import Capitulo9_heranca.Faculdade.EmpregadoDaFaculdade;
import Capitulo9_heranca.Faculdade.ProfessorDaFaculdade;

public class Principal_Faculdade {
    public static void main(String[] args) {

        EmpregadoDaFaculdade faxineira = new EmpregadoDaFaculdade();
        faxineira.setSalario(2000);

        ProfessorDaFaculdade professor = new ProfessorDaFaculdade();
        professor.setSalario(10000);
        professor.setHorasDeAula(40);

        System.out.println(faxineira.getInfo());
        System.out.println(professor.getInfo());
    }
}
