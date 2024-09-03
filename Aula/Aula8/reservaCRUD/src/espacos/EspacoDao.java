package espacos;

import connection.ConnectionFactory;

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
            lista_espacos.add(new Espaco(rs.getInt("id"), rs.getString("descricao"), rs.getBoolean("status")));
        }

        rs.close();
        stmt.close();

        return lista_espacos;

    }

    public Espaco get_item(String decricao) throws SQLException{
        String sql = "select * from espacos where descricao=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        Espaco espaco = null;

        stmt.setString(1, decricao);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            espaco = new Espaco(rs.getInt("id"),rs.getString("descricao"), rs.getBoolean("status"));
        }

        rs.close();
        stmt.close();

        return espaco;
    }

    public void remove(int id) throws SQLException{
        String sql = "delete from espaco where id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
    }
}
