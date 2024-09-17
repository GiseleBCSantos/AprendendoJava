package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="equipamentos")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String descricao;

    @Column(name="quantidade_total", nullable = false)
    private int quantidadeTotal;

    @Column(name="quantidade_disponivel", nullable = false)
    private int quantidadeDisponivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipamento that = (Equipamento) o;
        return id == that.id && quantidadeTotal == that.quantidadeTotal && quantidadeDisponivel == that.quantidadeDisponivel && Objects.equals(descricao, that.descricao);
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", quantidadeTotal=" + quantidadeTotal +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, quantidadeTotal, quantidadeDisponivel);
    }
}
