package JPA_Algaworks;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long codigo;

    @Column
    private String fabricante;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private BigDecimal valor;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Veiculo veiculo = (Veiculo) obj;
        return codigo != null ? codigo.equals(veiculo.codigo) : veiculo.codigo == null;
    }

    public int hashCode(){
        return codigo != null ? codigo.hashCode() : 0;
    }
}
