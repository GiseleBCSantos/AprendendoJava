package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("chefia")
public class Chefia extends Funcionario{
    @Column(length = 30)
    private String cargo;

    @Column(length = 30)
    private String setor;

    @Column
    private int senha;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chefia chefia = (Chefia) o;
        return senha == chefia.senha && Objects.equals(cargo, chefia.cargo) && Objects.equals(setor, chefia.setor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cargo, setor, senha);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ncargo= " + cargo +
                "\nsetor= " + setor +
                "\nsenha= " + senha +
                '\n';
    }
}
