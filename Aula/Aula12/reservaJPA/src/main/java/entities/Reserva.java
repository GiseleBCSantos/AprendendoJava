package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 11)
    private String data;

    @ManyToOne
    private Funcionario solicitante;

    @ManyToOne
    private Espaco espaco;

    @ManyToOne
    private Equipamento equipamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Funcionario solicitante) {
        this.solicitante = solicitante;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id == reserva.id && Objects.equals(data, reserva.data) && Objects.equals(solicitante, reserva.solicitante) && Objects.equals(espaco, reserva.espaco) && Objects.equals(equipamento, reserva.equipamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, solicitante, espaco, equipamento);
    }

    @Override
    public String toString() {
        String txt = "\nid= " + id +
                "\ndata= " + data +
                "\nsolicitante= " + solicitante.getNome();

        if (espaco != null){
            txt += "\nespaco= " + espaco.getDescricao() + "\n";
        }
        if (equipamento != null){
            txt += "\nequipamento= " + equipamento.getDescricao() + "\n";
        }

        return txt;
    }
}
