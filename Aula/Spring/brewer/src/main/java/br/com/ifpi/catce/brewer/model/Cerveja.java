package br.com.ifpi.catce.brewer.model;

import br.com.ifpi.catce.brewer.validation.SKU;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.thymeleaf.util.StringUtils;

import java.math.BigDecimal;

@ToString
@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "cerveja")
public class Cerveja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;


    @SKU
    @NotBlank(message = "SKU é obrigatório")
    private String sku;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor nao deve ser menor do que R$ 0,01")
    @DecimalMax(value = "9999999.99", message = "O valor não deve ser maior do que R$ 9999999.99")
    private BigDecimal valor;

    @NotNull(message = "O teor alcoólico é obrigatório")
    @DecimalMax(value = "100.0", message = "O teor alcoólico deve ser menor do que 100")
    @Column(name = "teor_alcoolico")
    private BigDecimal teorAlcoolico;

    @NotNull(message = "A comissão é obrigatória")
    @DecimalMax(value = "100.0", message = "A comissão deve ser menor do que 100")
    private BigDecimal comissao;

    @Max(value = 9999, message = "A quantidade em estoque deve ser menor do que 9.999")
    @NotNull(message = "A quantidade em estoque é obrigatória")
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;

    @NotNull(message = "A origem é obrigatória")
    @Enumerated(EnumType.STRING)
    private Origem origem;

    @NotNull(message = "O sabor é obrigatório")
    @Enumerated(EnumType.STRING)
    private Sabor sabor;

    @NotNull(message = "O estilo é obrigatório")
    @ManyToOne
    @JoinColumn(name = "codigo_estilo")
    private Estilo estilo;

    private String foto;

    @Column(name = "content_type")
    private String contentType;

    @PrePersist @PreUpdate
    private void prePersistUpdate(){
        sku = sku.toUpperCase();
    }

    public String getFotoOrMock() {
        return !StringUtils.isEmpty(foto) ? foto : "cerveja-mock.png";
    }
}
