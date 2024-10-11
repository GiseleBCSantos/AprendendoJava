package JPA_Algaworks.utils;

public class TotalCarroPorAno {
    private Integer anoFabricacao;
    private double mediaPreco;
    private Long quantidadeCarros;

    public TotalCarroPorAno(Integer anoFabricacao, double mediaPreco, Long quantidadeCarros) {
        super();
        this.anoFabricacao = anoFabricacao;
        this.mediaPreco = mediaPreco;
        this.quantidadeCarros = quantidadeCarros;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public double getMediaPreco() {
        return mediaPreco;
    }

    public Long getQuantidadeCarros() {
        return quantidadeCarros;
    }
}
