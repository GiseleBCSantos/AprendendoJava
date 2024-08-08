package obj_reserva;

public class Equipamento {
        int id;
        String descricao;
        int quantidade_total;
        int quantidade_disponivel;

    public Equipamento(int id, String descricao, int quantidade_total, int quantidade_disponivel){
        this.id = id;
        this.descricao = descricao;
        this.quantidade_total = quantidade_total;
        this.quantidade_disponivel = quantidade_disponivel;
    }

    public void reservar_equipamento(){
        if (quantidade_disponivel > 0){
            this.quantidade_disponivel -= 1;
            System.out.println("Equipamento reservado com sucesso !!! \nDisponíveis: " + quantidade_disponivel);
        }
        else{
            System.out.println("Todos esses equipamentos estão alugados.");
        }
    }

}
