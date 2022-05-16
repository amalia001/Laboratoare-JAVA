import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CityDAO {
    // countryName,CapitalName,CapitalLatitude,CapitalLongitude,
    public void create(String countryName, String capitalName,
                       double capitalLatitude, double capitalLongitude,
                       String countryCode,String continentName) throws SQLException {
        String sql = "INSERT INTO cities (country_id, name, capital, latitude, longitude) VALUES (?, ?, ?, ?, ?) ON CONFLICT DO NOTHING";

        Connection con = Database.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            var countryId = CountryDAO.findByName(countryName);
            stmt.setInt(1, countryId);
            stmt.setString(2, capitalName);
            stmt.setBoolean(3, true);
            stmt.setDouble(4, capitalLatitude);
            stmt.setDouble(5, capitalLongitude);
            stmt.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

    public City findRandom() throws SQLException {
        String sql = "SELECT * FROM cities ORDER BY RANDOM() LIMIT 1";
        Connection con = Database.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new City(rs.getInt("id"), rs.getInt("country_id"), rs.getString("name"), rs.getBoolean("capital"), rs.getDouble("latitude"), rs.getDouble("longitude"));
            }
            return null;
        }
    }

    public ArrayList<City> findAll() throws SQLException {
        String sql = "SELECT * FROM cities";
        Connection con = Database.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            ArrayList<City> cities = new ArrayList<>();
            while (rs.next()) {
                cities.add(new City(rs.getInt("id"), rs.getInt("country_id"), rs.getString("name"), rs.getBoolean("capital"), rs.getDouble("latitude"), rs.getDouble("longitude")));
            }
            return cities;
        }
    }
}
