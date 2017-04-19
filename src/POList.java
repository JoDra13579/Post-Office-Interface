//-CST183-Tim Klingler-
/**
 * This class contains an array of <code>PostOffice</code> objects and a single
 * separate <code>PostOffice</code> object that is considered the center for the
 * other <code>PostOffice</code> objects.
 * @author Jordan Drake
 */

import java.util.Scanner;
import java.io.*;

public class POList
{
    private PostOffice[] poList;
    private PostOffice   center;
	
    /**
     * Parameterized constructor 
     * @param listFile     The <code>File</code> object to read the post office
     *                     information from
     * @param center       The <code>PostOffice</code> object to use as the <
     * @throws IOException If the file cannot be found of there is an error
     *                     reading from the file
     */
    public POList( File listFile, PostOffice center ) throws IOException
    {
        // Create scanner object to count lines in listFile
        Scanner listIn = new Scanner( listFile );
        
        // While loop to count the lines
        int lines = 0;
        while ( listIn.hasNext() )
        {
            lines++;
            listIn.nextLine();
        }
        
        // Initialize an array of the appropriate size for poList
        poList = new PostOffice[ lines ];
        
        // Create another scanner to read the file in
        listIn = new Scanner( listFile );
        
        // While loop to populate the poList array with PostOffice objects
        int i = 0;
        while ( listIn.hasNext() )
            poList[ i++ ] = new PostOffice( listIn.nextInt(),
                    listIn.nextDouble(), listIn.nextDouble(),
                    listIn.nextLine().replace( '_', ' ' ) );
        
        // Set center
        this.center = new PostOffice( center );
    }
    
    /**
     * Copy constructor for <code>POList</code> objects
     * @param list The <code>POList</code> object to copy
     */
    public POList( POList list )
    {
        this.poList = new PostOffice[ list.poList.length ];
        
        for ( int i = 0; i < list.poList.length; i++ )
            this.poList[ i ] = new PostOffice( list.poList[ i ] );
        
        this.center = new PostOffice( list.center );
    }
    
    /**
     * Searches <code>poList</code> for a <code>PostOffice</code> with the zip
     * code <code>zip</code> and if it finds one, returns it
     * @param zip The zip code to search for in <code>poList</code>
     * @return The <code>PostOffice</code> matching <code>zip</code>, unless 
     *         <code>zip</code> matches <code>center</code> or <code>zip</code>
     *         is not found, then <code>null</code> will be returned.
     */
    public PostOffice searchZip ( int zip )
    {
        // Return null if zip matches center
        if ( zip == center.getZip() )
            return null;
        
        // If zip is found in poList, return that PostOffice object
        for ( PostOffice p : poList )
            if ( zip == p.getZip() )
                return new PostOffice( p );
        
        // Otherwise return null
        return null;
    }
}
