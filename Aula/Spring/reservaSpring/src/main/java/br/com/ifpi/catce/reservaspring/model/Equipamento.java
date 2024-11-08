package br.com.ifpi.catce.reservaspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Table(name = "equipamento")
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;

    @NotNull(message = "A quantidade disponivel é obrigatória")
    @Column(name = "quantidade_disponivel")
    private int quantidadeDisponivel;

    @NotNull(message = "A quantidade total é obrigatória")
    @Column(name = "quantidade_total")
    private int quantidadeTotal;

}
