//-CST183-Tim Klingler-
/**
 * This class extends the <code>JFrame</code> class and controls a window for
 * interfacing with an object of the <code>POList</code> class
 * @author Jordan Drake
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class PostOfficeCalculator extends JFrame
{
    // ***CONSTANTS***
    private static final int         WIDTH = 220,
                                    HEIGHT = 250;
    private static final File     LISTFILE = new File( "zipMIcity.txt" );
    private static final PostOffice CENTER = new PostOffice( 48640, 43.55660, 
            -83.99430, "University Center" );
    
    // **GUI Components**
    private ButtonsPanel keypad;
    private ZipField zipBox;
    private JPanel exitPanel;
    private JButton exit;
    
    // Instance variables
    private POList list;
    private PostOffice result;
    
    private PostOfficeCalculator()
    {
        // Set title
        this.setTitle( "Post Office Search" );
        
        // Set window size
        this.setSize( WIDTH, HEIGHT );
        
        // Set window layout
        this.setLayout( new BorderLayout( 0, 10 ) );
        
        // Create textfield and add it to layout
        zipBox = new ZipField();
        zipBox.setEditable( false );
        this.add( zipBox, BorderLayout.NORTH );
        
        // Create new keypad associated with the zip code box and add to layout
        keypad = new ButtonsPanel( zipBox, this );
        this.add( keypad, BorderLayout.CENTER );
        
        // Create exitPanel, add Exit button, and add panel to layout
        exitPanel = new JPanel();
        exit = new JButton( "Exit" );
        exit.addActionListener( new ExitListener() );
        exitPanel.add( exit );
        this.add( exitPanel, BorderLayout.SOUTH );
        
        // Make window Visible
        this.setVisible( true );
        
        // Show informational dialog
        JOptionPane.showMessageDialog( this, "Search for a post office by ZIP "
                + "code using your keypad or the on-screen keypad" );
        
        // Set program to close on window exit
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
<<<<<<< HEAD
        // Try-catch to catch and IOExceptions from reading list file during
		// POList construction
=======
        // Try-catch block to catch any exceptions thrown in the POList
        // constructor
>>>>>>> branch 'master' of https://github.com/JoDra13579/Post-Office-Interface.git
        try
        {
            list = new POList( LISTFILE, CENTER );
        }
        catch ( IOException | IllegalArgumentException e )
        {
			// Show error message and exit
            JOptionPane.showMessageDialog( this, "Error: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit( 0 );
        }
    }
    
    /**
     * Method to search for <code>zip</code> in <code>list</code>
     * @param zip The zip code to search for in the array
     */
    public void search( int zip )
    {
<<<<<<< HEAD
		// Search for the desired zip code in the post office list
=======
        // Run search method on the list object and assign it to result
>>>>>>> branch 'master' of https://github.com/JoDra13579/Post-Office-Interface.git
        result = list.searchZip( zip );
        if ( result != null )
        {
            String outStr = "";
            outStr += result;
            outStr += String.format( "%.2f miles from %d in %s", 
                    result.distanceTo(CENTER), result.getZip(),
                    result.getCity() );
            JOptionPane.showMessageDialog( this, outStr);
        }
        else
        {
            JOptionPane.showMessageDialog( this, "ZIP code " + zip + " not "
                    + "found in list of post offices.", "ZIP Not Found",
                    JOptionPane.PLAIN_MESSAGE );
        }
    }
    
    /**
     * Inner class for event listener for the exit button
     */
    private class ExitListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
<<<<<<< HEAD
			// Exit the program when clicked
=======
            // Exit the application
>>>>>>> branch 'master' of https://github.com/JoDra13579/Post-Office-Interface.git
            System.exit( 0 );
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
<<<<<<< HEAD
        new PostOfficeCalculator(); // Instantiate the application window
=======
        new PostOfficeCalculator(); // Instantiating the application window
>>>>>>> branch 'master' of https://github.com/JoDra13579/Post-Office-Interface.git
    }
}
