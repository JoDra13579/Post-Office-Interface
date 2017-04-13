/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Doctor
 */
public class PostOffice
{
    double lat,
           lon;
    int    zip;
    String city;
    
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
     * Parametrized constructor accepting latitude, longitude, zip code, and
     * the city of the post office object
     * @param lat  Latitude in decimal degrees
     * @param lon  Longitude in decimal degrees
     * @param zip  ZIP code
     * @param city City name
     */
    public PostOffice( double lat, double lon, int zip, String city )
    {
        this.lat  = lat;
        this.lon  = lon;
        this.zip  = zip;
        this.city = city;
    }
}
