public class DistanceCalculator{

    // Use the Haversine formula to calculate the distance between two cities.
    // The formula is:
    // d = 2 * r * asin(sqrt(h))
    // where:
    // d is the distance between the two cities
    // r is the radius of the Earth
    // h is the haversine formula

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double r = 6371; // Radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = r * c; // Distance in km
        return d;
    }

}