package equipamentos;

public class Equipamento {
        private int id;
        private String descricao;
        private int quantidade_total;
        private int quantidade_disponivel;

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade_total() {
        return quantidade_total;
    }

    public void setQuantidade_total(int quantidade_total) {
        this.quantidade_total = quantidade_total;
    }

    public int getQuantidade_disponivel() {
        return quantidade_disponivel;
    }

    public void setQuantidade_disponivel(int quantidade_disponivel) {
        this.quantidade_disponivel = quantidade_disponivel;
    }

    public Equipamento(int id, String descricao, int quantidade_total, int quantidade_disponivel){
        this.id = id;
        this.descricao = descricao;
        this.quantidade_total = quantidade_total;
        this.quantidade_disponivel = quantidade_disponivel;
    }


    @Override
    public String toString() {
        return
"\nid_equipamento= " + id +
"\ndescricao= " + descricao +
"\nquantidade_total= " + quantidade_total +
"\nquantidade_disponivel= " + quantidade_disponivel +
'\n';
    }
}
