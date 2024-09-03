package dao;

import connection.ConnectionFactory;
import equipamentos.Equipamento;
import espacos.Espaco;
import funcionarios.Chefia;
import funcionarios.Funcionario;
import reservas.Reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaDao {
    Connection conn;

    public ReservaDao () throws SQLException{
        conn = new ConnectionFactory().get_connection();
    }

    public void add(Reserva reserva) throws SQLException{
        String sql = "";

        if (reserva.getEspaco_reservado() instanceof Espaco){
            if (reserva.getSolicitante() instanceof Chefia) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Insira sua senha: ");
                int senha = sc.nextInt();
                if (((Chefia) reserva.getSolicitante()).autenticar(senha)){
                    System.out.println(reserva.getEspaco_reservado().isStatus());
                    if (reserva.getEspaco_reservado().isStatus()) {
                        sql = "insert into reservas (data_reserva, solicitante, espaco) values (?, ?, ?)";

                        PreparedStatement stmt = conn.prepareStatement(sql);

                        stmt.setString(1, reserva.getData_reserva());
                        stmt.setString(2, reserva.getSolicitante().getNome());
                        stmt.setString(3, reserva.getEspaco_reservado().getDescricao());

                        stmt.execute();
                        stmt.close();

                        reservar_espaco(reserva.getEspaco_reservado());
                        reserva.getSolicitante().enviar_email(reserva.getData_reserva());

                        System.out.println("Espaco reservado com sucesso!");
                    } else {
                        System.out.println("Indisponivel para reserva.");
                    }
            }
                else {
                    System.out.println("Senha incorreta.");
                }
            }
            else{
                System.out.println("Nao autorizado.");
            }

        }

        if (reserva.getEquipamento_reservado() instanceof Equipamento){
            if (reserva.getEquipamento_reservado().getQuantidade_disponivel() > 0){
                sql = "insert into reservas (data_reserva, solicitante, equipamento) values (?, ?, ?)";

                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, reserva.getData_reserva());
                stmt.setString(2, reserva.getSolicitante().getNome());
                stmt.setString(3, reserva.getEquipamento_reservado().getDescricao());

                stmt.execute();
                stmt.close();

                reservar_equipamento(reserva.getEquipamento_reservado());
                reserva.getSolicitante().enviar_email(reserva.getData_reserva());

                System.out.println("Equipamento reservado com sucesso!");
            }
            else{
                System.out.println("Indisponivel para reserva.");
            }
        }

}
    public void reservar_equipamento(Equipamento equipamento) throws SQLException {
        String sql = "update equipamentos set quantidade_disponivel=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, equipamento.getQuantidade_disponivel() - 1);
        stmt.setInt(2, equipamento.getId());

        stmt.execute();
        stmt.close();
    }

    public void reservar_espaco(Espaco espaco) throws SQLException{
        String sql = "update espacos set status=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setBoolean(1, false);
        stmt.setInt(2, espaco.getId());

        stmt.execute();
        stmt.close();
    }


    public List list() throws SQLException{
        List<Reserva> lista_reservas = new ArrayList<Reserva>();
        String sql = "select * from reservas";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = funcionarioDao.buscar(rs.getString("solicitante"));

            if (rs.getString("espaco") != null){
                EspacoDao espacoDao = new EspacoDao();
                Espaco espaco = espacoDao.get_item(rs.getString("espaco"));

                lista_reservas.add(new Reserva(rs.getString("data_reserva"), funcionario, espaco));
            }

            if (rs.getString("equipamento") != null){
                EquipamentoDao equipamentoDao = new EquipamentoDao();
                Equipamento equipamento = equipamentoDao.get_item(rs.getString("equipamento"));

                lista_reservas.add(new Reserva(rs.getString("data_reserva"), funcionario, equipamento));
            }
        }

        return lista_reservas;
    }

    public Reserva buscar(String nome, String data) throws SQLException{
        String sql = "select * from reservas where solicitante=? and data_reserva=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, nome);
        stmt.setString(2, data);

        ResultSet rs = stmt.executeQuery();

        Reserva reserva = null;

        while (rs.next()){
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = funcionarioDao.buscar(rs.getString("solicitante"));

            if (rs.getString("espaco") != null){
                EspacoDao espacoDao = new EspacoDao();
                Espaco espaco = espacoDao.get_item(rs.getString("espaco"));

                reserva = new Reserva(rs.getString("data_reserva"), funcionario, espaco);
            }

            if (rs.getString("equipamento") != null){
                EquipamentoDao equipamentoDao = new EquipamentoDao();
                Equipamento equipamento = equipamentoDao.get_item(rs.getString("equipamento"));

                reserva = new Reserva(rs.getString("data_reserva"), funcionario, equipamento);
            }
        }

    return reserva;
    }

    public void deletar(int id) throws SQLException{
        String sql = "delete from reservas where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

    }



}
