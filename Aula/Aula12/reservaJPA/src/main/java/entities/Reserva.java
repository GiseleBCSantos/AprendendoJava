package entities;

import javax.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 9)
    private String data;

    @Column
    @ManyToOne
    private Funcionario solicitante;

    @Column
    @ManyToOne
    private Espaco espaco;

    @Column
    @ManyToOne
    private Equipamento equipamento;
}
