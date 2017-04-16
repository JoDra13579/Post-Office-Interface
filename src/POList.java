import java.util.Scanner;
import java.io.*;

/** -Jordan Drake-CST183-Tim Klingler-
 * This class contains an array of PostOffice objects and a single separate
 * PostOffice object that is considered the center for the other PostOffice
 * objects. It also contains a method to calculate and return an array (parallel
 * to the PostOffice array) of discances to the "center."
 * @author Jordan Drake
 */
public class POList
{
    private PostOffice[] poList;
	private PostOffice   center;
	
    /**
     * Parameterized constructor 
     * @param listFile     The file object to read the post office information
	 *                     from
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
     * Copy constructor for POList objects
     * @param list The POList object to copy
     */
    public POList( POList list )
    {
        this.poList = new PostOffice[ list.poList.length ];
        
        for ( int i = 0; i < list.poList.length; i++ )
            this.poList[ i ] = new PostOffice( list.poList[ i ] );
    }
}
