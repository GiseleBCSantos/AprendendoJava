package dao;


import connection.ConnectionFactory;
import classes.equipamento.Equipamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipamentoDao {
    private Connection conn;
    Scanner sc = new Scanner(System.in);

    public EquipamentoDao() throws SQLException{
        this.conn = new ConnectionFactory().get_connection();
    }

    public void add(Equipamento equipamento){
        String sql = "insert into equipamentos (descricao, quantidade_total, quantidade_disponivel) values (?, ?, ?)";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);

//            stmt.setInt(1, equipamento.getId());
            stmt.setString(1, equipamento.getDescricao());
            stmt.setInt(2, equipamento.getQuantidade_total());
            stmt.setInt(3, equipamento.getQuantidade_disponivel());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List get_list() throws SQLException{
        String sql = "select * from equipamentos";
        PreparedStatement stmt = conn.prepareStatement(sql);

        List<Equipamento> lista_equipamentos = new ArrayList<Equipamento>();

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Equipamento equipamento = new Equipamento(rs.getString("descricao"), rs.getInt("quantidade_total"), rs.getInt("quantidade_disponivel"));
            equipamento.setId(rs.getInt("id"));
            lista_equipamentos.add(equipamento);
        }

        rs.close();
        stmt.close();

        return lista_equipamentos;
    }

    public Equipamento get_item_byDescricao(String descricao) throws SQLException{
        String sql = "select * from equipamentos where descricao=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        Equipamento equipamento = null;

        stmt.setString(1, descricao);

        ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            equipamento = new Equipamento(rs.getString("descricao"), rs.getInt("quantidade_total"), rs.getInt("quantidade_disponivel"));
            equipamento.setId(rs.getInt("id"));
        }
        
        rs.close();
        stmt.close();
        
        return equipamento;
    }

    public Equipamento get_item_byId(int id) throws SQLException{
        String sql = "select * from equipamentos where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Equipamento equipamento = null;
        while (rs.next()){
            equipamento = new Equipamento(rs.getString("descricao"), rs.getInt("quantidade_total"), rs.getInt("quantidade_disponivel"));
            equipamento.setId(rs.getInt("id"));
        }

        rs.close();
        stmt.close();
        return equipamento;
    }

    public void update(int id, Equipamento equipamento) throws SQLException{
        String sql = "update equipamentos set descricao=?, quantidade_total=?, quantidade_disponivel=? where id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        try{
            stmt.setString(1, equipamento.getDescricao());
            stmt.setInt(2, equipamento.getQuantidade_total());
            stmt.setInt(3, equipamento.getQuantidade_disponivel());
            stmt.setInt(4, id);

            stmt.execute();
            stmt.close();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) throws SQLException{
        String sql = "delete from  equipamentos where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        try {
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



}
