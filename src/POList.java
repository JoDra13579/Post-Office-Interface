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
        Scanner listCounter = new Scanner( listFile );

        int lines = 0;
        while ( listCounter.hasNext() )
        {
            lines++;
            listCounter.nextLine();
        }
        
        poList = new PostOffice[ lines ];
        
        listCounter = null;
        Scanner listIn = new Scanner( listFile )
        
        int i = 0;
        while ( listIn.hasNext() )
        {
            poList[ i++ ] = new PostOffice( listIn.nextInt(),
                    listIn.nextDouble(), listIn.nextDouble(),
                    listIn.nextLine().replace( '_', ' ' ) );
            System.out.println( poList[ i - 1 ] );
        }
        
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
