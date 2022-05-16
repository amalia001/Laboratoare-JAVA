public class City {
    // id, country, name, capital(0/1), latitude, longitude
    private int id;
    private int countryId;
    private String name;
    private boolean capital;
    private double latitude;
    private double longitude;

    public City(int id, int countryId, String name, boolean capital, double latitude, double longitude) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getName() {
        return name;
    }

    public boolean isCapital() {
        return capital;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", countryId=" + countryId +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
