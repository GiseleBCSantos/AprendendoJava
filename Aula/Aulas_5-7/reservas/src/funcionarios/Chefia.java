package funcionarios;

public class Chefia extends Funcionario {
    String cargo;
    String setor;

    public Chefia(int id, String nome, String email, String cargo, String setor){
        super(id, nome, email);
        this.cargo = cargo;
        this.setor = setor;
    }
}
