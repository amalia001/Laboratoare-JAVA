import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class Util {

    // Write an SQL script that will create the following tables:
// countries: id, name, code, continent
// continents: id, name
// cities: id, country, name, capital(0/1), latitude, longitude
    public static void createTables() {
        String sql = "CREATE TABLE if not exists continents (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) UNIQUE" +
                ")";
        String sql2 = "CREATE TABLE if not exists countries (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) UNIQUE," +
                "code VARCHAR(255)," +
                "continent_id INTEGER REFERENCES continents(id)" +
                ")";
        String sql3 = "CREATE TABLE if not exists cities (" +
                "id SERIAL PRIMARY KEY," +
                "country_id INTEGER REFERENCES countries(id)," +
                "name VARCHAR(255)," +
                "capital BOOLEAN," +
                "latitude DOUBLE PRECISION," +
                "longitude DOUBLE PRECISION" +
                ")";

//Database.createConnection();
        try {
            Database.getConnection().createStatement().execute(sql);
            Database.getConnection().createStatement().execute(sql2);
            Database.getConnection().createStatement().execute(sql3);
            Database.getConnection().commit();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
        System.out.println("Tables created");
    }

    // Write an SQL script that will drop the following tables:
    public static void dropTables() {
        String sql = "DROP TABLE if exists continents CASCADE";
        String sql2 = "DROP TABLE if exists countries CASCADE";
        String sql3 = "DROP TABLE if exists cities CASCADE";

        try {
            Database.getConnection().createStatement().execute(sql3);
            Database.getConnection().createStatement().execute(sql);
            Database.getConnection().createStatement().execute(sql2);


            Database.getConnection().commit();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
        System.out.println("Tables dropped");
    }

    // Process csv file with the following format:
//   CountryName,CapitalName,CapitalLatitude,CapitalLongitude,CountryCode,ContinentName
// Somaliland,Hargeisa,9.55,44.050000,NULL,Africa
// South Georgia and South Sandwich Islands,King Edward Point,-54.283333,-36.500000,GS,Antarctica
    public static void processCsvFile() {
        // Read the csv file
        String csvFile = "C:\\Users\\Amalia\\Desktop\\Anul 2 Sem 2\\PA-JAVA\\concap.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                // Create a new continent
                ContinentDAO continentDAO = new ContinentDAO();
                continentDAO.create(country[5]);
                // Create a new country
                CountryDAO countryDAO = new CountryDAO();
                countryDAO.create(country[0], country[4], continentDAO.findByName(country[5]));
                // Create a new city
                CityDAO cityDAO = new CityDAO();
                cityDAO.create(country[0], country[1], Double.parseDouble(country[2]), Double.parseDouble(country[3]), country[4],country[5]);

                Database.getConnection().commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Display the distances between various two cities
    public static void displayDistances() throws SQLException {
        // Get random two cities from the database
        CityDAO cityDAO = new CityDAO();
        for (int i = 0; i < 10; i++) {
            City city1 = cityDAO.findRandom();
            City city2 = cityDAO.findRandom();
            // Calculate the distance between the two cities
            double distance = DistanceCalculator.calculateDistance(city1.getLatitude(), city1.getLongitude(), city2.getLatitude(), city2.getLongitude());
            // Print the distance
            System.out.println(city1.getName() + " - " + city2.getName() + ": " + distance);
        }

    }

    // Use java swing to display the map of the world "map.jpg"
    public static void displayMap() throws SQLException {
        JFrame frame = new JFrame("Map");
        ImageIcon icon = new ImageIcon("C:\\Users\\Amalia\\Desktop\\Anul 2 Sem 2\\PA-JAVA\\map.JPG");
        // 800x800 frame size
        frame.setSize(800, 800);
        // Resclae the image to fit the frame
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        frame.add(new JLabel(icon));
        frame.pack();
        frame.setVisible(true);

        // For each city in the database, display the city on the map
        CityDAO cityDAO = new CityDAO();
        for (City city : cityDAO.findAll()) {
            // Create a circle around the city
            // Convert the latitude and longitude to x and y coordinates base on scale of the frame marcator projection
            // Mercator projection of the world between 85°S and 85°N.
            double x = (city.getLongitude() + 180) * (frame.getWidth() / 360);
            double latRad = city.getLatitude() * Math.PI / 180;
            double mercN = Math.log(Math.tan(Math.PI / 4 + latRad / 2));
            double y = (frame.getHeight() / 2) - (frame.getWidth() * mercN / (2 * Math.PI));
            // Shift the circle to the correct position



            // Create a new circle
            Ellipse2D circle = new Ellipse2D.Double(x , y , 5, 5);
            // Add the circle to the map
            Graphics2D g2d = (Graphics2D) frame.getGraphics();
            g2d.setColor(Color.RED);
            g2d.fill(circle);


            // Set the label position
//      label.setBounds(city.getLongitude() - 10, city.getLatitude() - 10, 20, 20);
        }
    }


}
