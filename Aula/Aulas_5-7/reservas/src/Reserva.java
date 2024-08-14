import obj_reserva.Equipamento;
import obj_reserva.Espaco;

public class Reserva {
    private static int id;
    private String data_reserva;
    private String nome_solicitante;
    private Espaco espaco_reservado;
    private Equipamento equipamento_reservado;
    private Boolean status_reserva = true;


    public Reserva(String data_reserva, String nome_solicitante){
        Reserva.id++;
        this.data_reserva = data_reserva;
        this.nome_solicitante = nome_solicitante;

        System.out.println("Reserva criada no nome de " + nome_solicitante + " na data " +data_reserva + "");
    }

    public Reserva(String data_reserva, String nome_solicitante, Equipamento equipamento){
        Reserva.id++;
        if (equipamento.solicitar_reserva()){
            this.data_reserva = data_reserva;
            this.nome_solicitante = nome_solicitante;
            this.equipamento_reservado = equipamento;
            System.out.println("Reserva criada no nome de " + nome_solicitante + " na data " +data_reserva + "");
        }
        else {
            this.status_reserva = false;
            System.out.println("Falha ao criar reserva, equipamento não disponível.");
        }
    }

    public Reserva(String data_reserva, String nome_solicitante, Espaco espaco){
        Reserva.id++;
        if (espaco.solicitar_reserva()){
            this.data_reserva = data_reserva;
            this.nome_solicitante = nome_solicitante;
            this.espaco_reservado = espaco;
            System.out.println("Reserva criada no nome de " + nome_solicitante + " na data " +data_reserva + "");
        }
        else {
            this.status_reserva = false;
            System.out.println("Falha ao criar reserva, espaço não disponível.");
        }
    }

    public boolean reservar_espaco(){
        if (status_reserva){
            this.espaco_reservado.setStatus(false);
            System.out.println(nome_solicitante + " reservou o espaço " + this.espaco_reservado.getDescricao() + ".");
            return true;
        }
        else{
            System.out.println("Erro ao reservar!");
            return false;
        }


    }

    public boolean reservar_equipamento(){
        if (status_reserva){
            this.equipamento_reservado.setQuantidade_disponivel(this.equipamento_reservado.getQuantidade_disponivel() - 1);
            System.out.println(nome_solicitante + " reservou o equipamento "+ this.equipamento_reservado.getDescricao() + ".\nQuantidade ainda disponível para reserva: " + this.equipamento_reservado.getQuantidade_disponivel() + "/" + this.equipamento_reservado.getQuantidade_total() + "");
            return true;
        }
        else{
            System.out.println("Erro ao reservar!");
            return false;
        }
    }
}
