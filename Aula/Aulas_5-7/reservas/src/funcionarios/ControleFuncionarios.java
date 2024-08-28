package funcionarios;

import java.util.ArrayList;

public class ControleFuncionarios {
    ArrayList<Funcionario> lista_funcionarios = new ArrayList<Funcionario>();

    public ArrayList<Funcionario> getLista_funcionarios() {
        return lista_funcionarios;
    }

    public void cadastrar_funcionarios(Funcionario funcionario){
        lista_funcionarios.add(funcionario);
    }
}
