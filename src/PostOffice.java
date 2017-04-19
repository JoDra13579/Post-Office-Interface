//-CST183-Tim Klingler-
/**
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
        this.setLat( 0.0 );
        this.setLon( 0.0 );
        this.setZip( 40000 );
        this.setCity( "Empty" );
    }
    
    /**
     * Parameterized constructor accepting latitude, longitude, zip code, and
     * the city of the post office object
     * @param zip  ZIP code
     * @param lat  Latitude in decimal degrees
     * @param lon  Longitude in decimal degrees
     * @param city City name
     * @throws IllegalArgumentException If any arguments are outisde acceptable
     *                                  ranges
     */
    public PostOffice( int zip, double lat, double lon, String city ) throws
            IllegalArgumentException
    {
        this.setLat( lat );
        this.setLon( lon );
        this.setZip( zip );
        this.setCity( city );
    }
    
    /**
     * Copy constructor for <code>PostOffice</code> objects
     * @param p The <code>PostOffice</code> object to be copied
     */
    public PostOffice( PostOffice p )
    {
        this.setLat( p.lat );
        this.setLon( p.lon );
        this.setZip( p.zip );
        this.setCity( p.city );
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
     * @throws IllegalArgumentException If <code>lat</code> is not between -180
     *                                  and 180
     */
    public void setLat( double lat ) throws IllegalArgumentException
    {
        if ( lat >= -90.0 && lat <= 90.0 )
            this.lat = lat;
        else
        {
            this.lat = 0.0;
            throw new IllegalArgumentException( "Latitude " + lat + " is not a"
                    + " decimal value between -180 and 180" );
        }
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
     * @throws IllegalArgumentException If <code>lon</code> is not between -90
     *                                  and 90
     */
    public void setLon( double lon ) throws IllegalArgumentException
    {
        if ( lon >= -180.0 && lon <= 180.0 )
            this.lon = lon;
        else
        {
            this.lon = 0.0;
            throw new IllegalArgumentException( "Longitude " + lon  + " is not"
                    + " a decimal value between -90 and 90" );
        }
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
     * @throws IllegalArgumentException If <code>zip</code> is not between 40000
     *                                  and 49999
     */
    public void setZip(int zip) throws IllegalArgumentException
    {
        if ( zip >= 40000 && zip <= 49999 )
            this.zip = zip;
        else
        {
            this.zip = zip;
            throw new IllegalArgumentException( "ZIP code " + zip + " is not a "
                    + "valid Michigan ZIP code" );
        }
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
        if ( !city.trim().equals( "" ) )
            this.city = city.trim();
        else
        {
            this.city = "Empty";
            throw new IllegalArgumentException( "City name cannot be empty");
        }
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
    
    /**
     * 
     * @return 
     */
    public String toString()
    {
        String outStr = "";
        outStr += String.format( "City:      %-10s\n", city );
        outStr += String.format( "ZIP:       %10d\n", zip);
        outStr += String.format( "Latitude:  %10.5f\n", lat);
        outStr += String.format( "Longitude: %10.5f\n", lon);
        return outStr;
    }
}
