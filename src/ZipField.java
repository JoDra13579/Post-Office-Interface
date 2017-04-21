//-CST183-Tim Klingler-
/**
 * This class extends the JTextField class and adds methods to type integers in
 * the field, and clear the field
 * @author Jordan Drake
 */

import javax.swing.*;
import java.io.*;

public class ZipField extends JTextField
{
    /**
	 * Constructor to make the field uneditable
	 */
    public ZipField()
	{
	    this.setEditable( false );
	}
	
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
}
