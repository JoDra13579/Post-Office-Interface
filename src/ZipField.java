/**
 *
 * @author Jordan Drake
 */

import javax.swing.*;
public class ZipField extends JTextField
{
    public void type( int j )
    {
        this.setText( this.getText() + j );
    }
    
    public void clear()
    {
        this.setText( "" );
    }
    
    public void submit()
    {
        
    }
}
