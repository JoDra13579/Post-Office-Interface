import java.util.Scanner;
import java.io.*;

/**-CST183-Tim Klingler-
 * This class contains an array of <code>PostOffice</code> objects and a single
 * separate <code>PostOffice</code> object that is considered the center for the
 * other <code>PostOffice</code> objects. It also contains a method to calculate
 * and return an array (parallel to the <code>PostOffice</code> array) of
 * distances to the <code>center</code>.
 * @author Jordan Drake
 */

public class POList
{
    private PostOffice[] poList;
    private PostOffice   center;
	
    /**
     * Parameterized constructor 
     * @param listFile     The <code>File</code> object to read the post office
     *                     information from
     * @throws IOException If the file cannot be found of there is an error
     *                     reading from the file
     */
    public POList( File listFile ) throws IOException
    {
        Scanner listIn = new Scanner( listFile );

        int lines = 0;
        while ( listIn.hasNext() )
        {
            lines++;
            listIn.nextLine();
        }
        listIn.reset();
        
        poList = new PostOffice[ lines ];
        
        int i = 0;
        while ( listIn.hasNext() )
            poList[ i++ ] = new PostOffice( listIn.nextInt(),
                    listIn.nextDouble(), listIn.nextDouble(),
                    listIn.nextLine().replace( '_', ' ' ) );
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
    }
}
