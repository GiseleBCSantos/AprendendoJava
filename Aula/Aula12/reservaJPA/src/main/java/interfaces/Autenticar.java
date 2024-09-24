package interfaces;

import entities.Chefia;
import entities.Funcionario;

public interface Autenticar {
    public boolean autenticarFuncionario(Chefia chefia, int senha);
}
