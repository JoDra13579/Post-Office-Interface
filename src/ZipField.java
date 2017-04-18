/**
 *
 * @author Jordan Drake
 */

import javax.swing.*;
import java.io.*;

public class ZipField extends JTextField
{
    private POList list;
    
    /**
     * Constructor accepting a <code>listFile</code> to create the 
     * <code>POList</code> for searching
     * @param listFile
     * @throws IOException If the file cannot be found of there is an error
     *                     reading from the file
     */
    public ZipField( File listFile ) throws IOException
    {                                                    // Use default
        list = new POList( listFile, new PostOffice() ); // constructor to make
    }                                                    // center
    
    /**
     * Method to add numbers to the <code>ZipField</code> (only up to 5 numbers)
     * @param j The <code>int</code> to append to the contents of the 
     *          <code>ZipField</code>
     */
    public void type( int j )
    {
        if ( this.getText().length() < 5 )
            this.setText( this.getText() + j );
    }
    
    /**
     * Method to clear the contents of the <code>ZipField</code>
     */
    public void clear()
    {
        this.setText( "" );
    }
    
    public void submit()
    {
        list.searchZip( Integer.parseInt( this.getText() ) );
    }
}
