package reservas;

import equipamentos.Equipamento;
import espacos.Espaco;
import funcionarios.Funcionario;

import java.util.ArrayList;

public class ControleReservas {
    ArrayList<Reserva> list_reservas = new ArrayList<Reserva>();

    public ArrayList<Reserva> getList_reservas() {
        return list_reservas;
    }

    public void add_reserva_equipamento(String data, Funcionario funcionario, Equipamento equipamento){
        if (equipamento.getQuantidade_disponivel() > 0){
            list_reservas.add(new Reserva(data, funcionario, equipamento));
            equipamento.setQuantidade_disponivel(equipamento.getQuantidade_disponivel() - 1);
            System.out.println("Reserva de equipamento realizada com sucesso!\n Nome solicitante: "+funcionario.getNome()+"\n Nome do equipamento: "+equipamento.getDescricao()+"\n Data: "+data);
            funcionario.enviar_email(data);

        }
        else{
            System.out.println("Equipamento "+equipamento.getDescricao()+" nao disponivel para reserva.");
        }
    }

    public void add_reserva_espaco(String data, Funcionario funcionario, Espaco espaco){
        if (espaco.isStatus()){
            list_reservas.add(new Reserva(data, funcionario, espaco));
            espaco.setStatus(false);
            System.out.println("Reserva de espaco realizada com sucesso!\n Nome solicitante: "+funcionario.getNome()+"\n Nome do equipamento: "+espaco.getDescricao()+"\n Data: "+data);

            funcionario.enviar_email(data);
        }
        else{
            System.out.println("Espaco "+espaco.getDescricao()+" nao disponivel para reserva.");
        }
    }
}
