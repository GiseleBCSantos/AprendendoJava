package dao;

import connection.ConnectionFactory;
import classes.equipamento.Equipamento;
import classes.espaco.Espaco;
import classes.funcionario.Chefia;
import classes.funcionario.Funcionario;
import classes.reserva.Reserva;

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

        equipamento.setQuantidade_disponivel(equipamento.getQuantidade_disponivel() - 1);
    }

    public void reservar_espaco(Espaco espaco) throws SQLException{
        String sql = "update espacos set status=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setBoolean(1, false);
        stmt.setInt(2, espaco.getId());

        stmt.execute();
        stmt.close();

        espaco.setStatus(false);

    }


    public List list_all() throws SQLException{
        List<Reserva> lista_reservas = new ArrayList<Reserva>();
        String sql = "select * from reservas";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = funcionarioDao.get_item_byNome(rs.getString("solicitante"));

            if (rs.getString("espaco") != null){
                EspacoDao espacoDao = new EspacoDao();
                Espaco espaco = espacoDao.get_item_byDescricao(rs.getString("espaco"));

                Reserva reserva = new Reserva(rs.getString("data_reserva"), funcionario, espaco);
                reserva.setId(rs.getInt("id"));
                lista_reservas.add(reserva);
            }

            if (rs.getString("equipamento") != null){
                EquipamentoDao equipamentoDao = new EquipamentoDao();
                Equipamento equipamento = equipamentoDao.get_item_byDescricao(rs.getString("equipamento"));

                Reserva reserva = new Reserva(rs.getString("data_reserva"), funcionario, equipamento);
                reserva.setId(rs.getInt("id"));
                lista_reservas.add(reserva);
            }
        }

        return lista_reservas;
    }

    public Reserva list_item(String nome, String data) throws SQLException{
        String sql = "select * from reservas where solicitante=? and data_reserva=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, nome);
        stmt.setString(2, data);

        ResultSet rs = stmt.executeQuery();

        Reserva reserva = null;

        while (rs.next()){
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = funcionarioDao.get_item_byNome(rs.getString("solicitante"));

            if (rs.getString("espaco") != null){
                EspacoDao espacoDao = new EspacoDao();
                Espaco espaco = espacoDao.get_item_byDescricao(rs.getString("espaco"));

                reserva = new Reserva(rs.getString("data_reserva"), funcionario, espaco);
            }

            if (rs.getString("equipamento") != null){
                EquipamentoDao equipamentoDao = new EquipamentoDao();
                Equipamento equipamento = equipamentoDao.get_item_byDescricao(rs.getString("equipamento"));

                reserva = new Reserva(rs.getString("data_reserva"), funcionario, equipamento);
            }
        }

    return reserva;
    }

    public Reserva list_byId(int id) throws SQLException{
        String sql = "select * from reservas where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Reserva reserva = null;

        while (rs.next()){
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = funcionarioDao.get_item_byNome(rs.getString("solicitante"));

            if (rs.getString("espaco") != null){
                EspacoDao espacoDao = new EspacoDao();
                Espaco espaco = espacoDao.get_item_byDescricao(rs.getString("espaco"));

                reserva = new Reserva(rs.getString("data_reserva"), funcionario, espaco);
            }

            if (rs.getString("equipamento") != null){
                EquipamentoDao equipamentoDao = new EquipamentoDao();
                Equipamento equipamento = equipamentoDao.get_item_byDescricao(rs.getString("equipamento"));

                reserva = new Reserva(rs.getString("data_reserva"), funcionario, equipamento);
            }
        }
        return reserva;
    }

    public void delete(int id) throws SQLException{
        String sql = "delete from reservas where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        stmt.execute();
        stmt.close();

    }



}
