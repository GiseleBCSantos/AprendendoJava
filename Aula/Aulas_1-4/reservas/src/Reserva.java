import obj_reserva.Equipamento;
import obj_reserva.Espaco;

public class Reserva {
    private int id;
    private String data_reserva;
    private String nome_solicitante;
    private Espaco espaco_reservado;
    private Equipamento equipamento_reservado;


    public Reserva(int id, String data_reserva, String nome_solicitante){
        this.id = id;
        this.data_reserva = data_reserva;
        this.nome_solicitante = nome_solicitante;

        System.out.println("Reserva criada no nome de " + nome_solicitante + " na data " +data_reserva + "\n");
    }

    public void reservar_espaco(Espaco espaco){
        this.espaco_reservado = espaco;
        boolean reserva = this.espaco_reservado.solicitar_reserva();

        if (reserva) {
            System.out.println(nome_solicitante + " reservou o espaço " + espaco.getDescricao() + ".\n");
        }
        else{
            System.out.println("Espaço " + this.espaco_reservado.getDescricao() + " não disponível para reserva.");
        }
    }

    public void reservar_equipamento(Equipamento equipamento){
        this.equipamento_reservado = equipamento;
        boolean reserva = this.equipamento_reservado.solicitar_reserva();

        if (reserva){
            System.out.println(nome_solicitante + " reservou o equipamento "+ equipamento.getDescricao() + ".\nQuantidade ainda disponível para reserva: " + this.equipamento_reservado.getQuantidade_disponivel() + "/" + this.equipamento_reservado.getQuantidade_total() + "\n");
        }
        else{
            System.out.println("Equipamento " + this.equipamento_reservado.getDescricao() + " não disponível para reserva.\n");
        }
    }
}
