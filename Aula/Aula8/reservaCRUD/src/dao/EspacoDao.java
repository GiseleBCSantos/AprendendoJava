package dao;

import connection.ConnectionFactory;
import espacos.Espaco;

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
        String sql = "insert into espacos (id, descricao, status) values (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, espaco.getId());
        stmt.setString(2, espaco.getDescricao());
        stmt.setBoolean(3, espaco.isStatus());

        stmt.execute();
        stmt.close();
    }

    public List get_list() throws SQLException{
        List<Espaco> lista_espacos = new ArrayList<Espaco>();

        String sql = "select * from espacos";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            lista_espacos.add(new Espaco(rs.getString("descricao"), rs.getBoolean("status")));
        }

        rs.close();
        stmt.close();

        return lista_espacos;

    }
}
