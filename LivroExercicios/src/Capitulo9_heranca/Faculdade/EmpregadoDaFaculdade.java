package Capitulo9_heranca.Faculdade;

public class EmpregadoDaFaculdade {
    private String nome;
    private double salario;

    public double getGastos(){
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getInfo(){
        return "nome: " + this.nome + "\nsalario: " + this.getGastos();
    }
}
