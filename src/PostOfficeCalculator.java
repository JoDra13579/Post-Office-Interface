//-CST183-Tim Klingler-
/**
 * This class extends the <code>JFrame</code> class and controls a window for
 * interfacing with an object of the <code>POList</code> class
 * @author Jordan Drake
 */

import java.awt.*;
import javax.swing.*;

public class PostOfficeCalculator extends JFrame
{
    private ButtonsPanel keypad;
    private ZipField zipBox;
    
    private PostOfficeCalculator()
    {
        this.setLayout( new GridLayout( 2, 1, 10, 0 ) );
        zipBox = new ZipField();
        zipBox.setEditable( false );
        this.add( zipBox );
        
        // Create new keypad associated with the zip code box
        keypad = new ButtonsPanel( zipBox );
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
        new PostOfficeCalculator();
    }
}
