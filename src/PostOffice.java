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
     * Copy constructor for PostOffice objects
     * @param p The PostOffice object to be copied
     */
    public PostOffice( PostOffice p )
    {
        this.lat  = p.lat;
        this.lon  = p.lon;
        this.zip  = p.zip;
        this.city = p.city;
    }

    /**
     * Accessor method for the lat field
     * @return The latitude
     */
    public double getLat()
    {
        return lat;
    }

    /**
     * Mutator method for the lat field
     * @param lat The latitude to set
     */
    public void setLat( double lat )
    {
        this.lat = lat;
    }

    /**
     * Accessor method for the lon field
     * @return The longitude
     */
    public double getLon()
    {
        return lon;
    }

    /**
     * Mutator method for the lon field
     * @param lon The longitude to set
     */
    public void setLon( double lon )
    {
        this.lon = lon;
    }

    /**
     * Accessor method for the zip field
     * @return The ZIP code
     */
    public int getZip()
    {
        return zip;
    }

    /**
     * Mutator method for the zip field
     * @param zip The ZIP code to set
     */
    public void setZip(int zip)
    {
        this.zip = zip;
    }

    /**
     * Accessor method for the city field
     * @return The city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Mutator method for the city field
     * @param city The city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    
}
