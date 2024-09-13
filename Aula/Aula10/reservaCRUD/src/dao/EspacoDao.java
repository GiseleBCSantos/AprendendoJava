package dao;

import connection.ConnectionFactory;
import classes.espaco.Espaco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspacoDao {
    Connection conn;

    public EspacoDao() throws SQLException{
        this.conn = new ConnectionFactory().get_connection();
    }

    public void add(Espaco espaco) throws SQLException {
        String sql = "insert into espacos (descricao, status) values (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, espaco.getDescricao());
        stmt.setBoolean(2, espaco.isStatus());

        stmt.execute();
        stmt.close();
    }

    public List get_list() throws SQLException{
        List<Espaco> lista_espacos = new ArrayList<Espaco>();

        String sql = "select * from espacos";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Espaco espaco = new Espaco(rs.getString("descricao"), rs.getBoolean("status"));
            espaco.setId(rs.getInt("id"));
            lista_espacos.add(espaco);

        }

        rs.close();
        stmt.close();

        return lista_espacos;

    }

    public Espaco get_item_byDescricao(String decricao) throws SQLException{
        String sql = "select * from espacos where descricao=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        Espaco espaco = null;

        stmt.setString(1, decricao);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            espaco = new Espaco(rs.getString("descricao"), rs.getBoolean("status"));
            espaco.setId(rs.getInt("id"));
        }

        rs.close();
        stmt.close();

        return espaco;
    }

    public Espaco get_item_byId(int id) throws SQLException{
        String sql = "select * from espacos where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        Espaco espaco = null;

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            espaco = new Espaco(rs.getString("descricao"), rs.getBoolean("status"));
            espaco.setId(rs.getInt("id"));
        }

        rs.close();
        stmt.close();

        return espaco;
    }

    public void update(int id, Espaco espaco) throws SQLException{
        String sql = "update espacos set descricao=?, status=? where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, espaco.getDescricao());
        stmt.setBoolean(2, espaco.isStatus());
        stmt.setInt(3, id);

        stmt.execute();
        stmt.close();
    }

    public void remove(int id) throws SQLException{
        String sql = "delete from espacos where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
