/** -Jordan Drake-CST183-Tim Klingler-
 * This class contains information about a Post Office including the 
 * location (using latitude and longitude), the corresponding city,
 * and its ZIP code. It also contains an instance method to calculate
 * the distance to another PostOffice object.
 * @author Jordan Drake
 */

public class PostOffice
{
    private double lat,
                   lon;
    private int    zip;
    private String city;
    
    /**
     * No-arg constructor
     */
    public PostOffice()
    {
        lat  = 43.55660;
        lon  = -83.99430;
        zip  = 48640;
        city = "University Center";
    }
    
    /**
     * Parameterized constructor accepting latitude, longitude, zip code, and
     * the city of the post office object
     * @param zip  ZIP code
     * @param lat  Latitude in decimal degrees
     * @param lon  Longitude in decimal degrees
     * @param city City name
     */
    public PostOffice( int zip, double lat, double lon, String city )
    {
        this.lat  = lat;
        this.lon  = lon;
        this.zip  = zip;
        this.city = city;
    }
    
    /**
     * Copy constructor for <code>PostOffice</code> objects
     * @param p The <code>PostOffice</code> object to be copied
     */
    public PostOffice( PostOffice p )
    {
        this.lat  = p.lat;
        this.lon  = p.lon;
        this.zip  = p.zip;
        this.city = p.city;
    }

    /**
     * Accessor method for the <code>lat</code> field
     * @return The latitude
     */
    public double getLat()
    {
        return lat;
    }

    /**
     * Mutator method for the <code>lat</code> field
     * @param lat The latitude to set
     */
    public void setLat( double lat )
    {
        this.lat = lat;
    }

    /**
     * Accessor method for the <code>lon</code> field
     * @return The longitude
     */
    public double getLon()
    {
        return lon;
    }

    /**
     * Mutator method for the <code>lon</code> field
     * @param lon The longitude to set
     */
    public void setLon( double lon )
    {
        this.lon = lon;
    }

    /**
     * Accessor method for the <code>zip</code> field
     * @return The ZIP code
     */
    public int getZip()
    {
        return zip;
    }

    /**
     * Mutator method for the <code>zip</code> field
     * @param zip The ZIP code to set
     */
    public void setZip(int zip)
    {
        this.zip = zip;
    }

    /**
     * Accessor method for the <code>city</code> field
     * @return The city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Mutator method for the <code>city</code> field
     * @param city The city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * Method to calculate the surface distance from one <code>PostOffice</code>
     * to another
     * @param p The <code>PostOffice</code> object to calculate the distance for
     * @return The geodesic distance from <code>p</code> to <code>this</code>
     */
    public double distanceTo( PostOffice p )
    {
        double dSigma; // Angular distance between PostOffices
        // Formula: dSigma =
        // arccos( sin(lat1) sin(lat2) + cos(lat1) cos(lat2) cos(lon1-lon2) )
        dSigma = Math.acos( Math.sin( Math.toRadians( this.lat ) ) *
                Math.sin( Math.toRadians( p.lat ) ) +
                Math.cos( Math.toRadians( this.lat ) ) *
                Math.cos( Math.toRadians( p.lat ) ) *
                Math.cos( Math.toRadians( this.lon - p.lon ) ) );
        return 3963.190592 * dSigma; // Arclength = r theta
    }
}
