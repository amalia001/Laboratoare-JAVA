import java.sql.*;
import java.util.ArrayList;

public class CountryDAO {
    public static Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try(PreparedStatement pstmt = con.prepareStatement(
                "select id from countries where name=?")) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() ? rs.getInt(1) : null;
        }

    }

    public void create (String name, String countryCode, int continentId) throws SQLException {
        Connection con = Database.getConnection();
        String sql = "INSERT INTO countries (name, code, continent_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, countryCode);
        stmt.setInt(3, continentId);
        stmt.executeUpdate();
    }

    // find by id
    public ArrayList<Country> findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "select * from countries where continent_id = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Country> countries = new ArrayList<>();
            while (rs.next()) {
                countries.add(new Country(rs.getInt("id"), rs.getString("name"), rs.getString("code"), rs.getInt("continent_id")));
            }
            return countries;
        }
    }
}
