package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "espacos")
public class Espaco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false)
    private String descricao;

    @Column(nullable = false)
    private boolean status = false;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Espaco espaco = (Espaco) o;
        return id == espaco.id && status == espaco.status && Objects.equals(descricao, espaco.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, status);
    }

    @Override
    public String toString() {
        return
                "\nid= " + id +
                "\ndescricao= " + descricao + '\'' +
                "\nstatus= " + status +
                "\n";
    }
}
