
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
    //compulsory();
        homework();

    }

    public static void compulsory(){
        Database.createConnection();
        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania","RO", europeId);
            countries.create("Ukraine","UK", europeId);
            Database.getConnection().commit();
            //TODO: print all the countries in Europe
            var countriesInEurope = new CountryDAO();
            var europe = countriesInEurope.findById(europeId);
            for (var country : europe) {
                System.out.println(country);
            }
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

    public static void homework() throws SQLException {

        Database.createConnection();
        Util.dropTables();
        Util.createTables();

    Util.processCsvFile();
        Util.displayDistances();
        Util.displayMap();
        Database.closeConnection();
    }


}
