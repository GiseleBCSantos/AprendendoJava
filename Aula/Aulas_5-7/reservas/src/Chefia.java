import obj_reserva.Espaco;

public class Chefia extends Funcionario {
    String cargo;
    String setor;

    public Chefia(String nome, String email, String cargo, String setor, int senha){
        super(nome, email, senha);
        this.cargo = cargo;
        this.setor = setor;
    }

    public void reservar_espaco(String data, Espaco espaco){
        Reserva reserva = new Reserva(data, this.nome, espaco);
        boolean reserva_ok = reserva.reservar_espaco();
        if (reserva_ok){
            this.enviar_email();
        }
    }
}
