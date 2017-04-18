//-CST183-Tim Klingler-
/**
 * This class extends the <code>JFrame</code> class and controls a window for
 * interfacing with an object of the <code>POList</code> class
 * @author Jordan Drake
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PostOfficeCalculator extends JFrame
{
    // ***CONSTANTS***
    private final int WIDTH = 200,
                     HEIGHT = 250;
    
    // **GUI Components**
    private ButtonsPanel keypad;
    private ZipField zipBox;
    private JPanel exitPanel;
    private JButton exit;
    
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
        keypad = new ButtonsPanel( zipBox );
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
        JOptionPane.showMessageDialog(this, "Search for a post office by ZIP "
                + "code using your keypad or the on-screen keypad");
        
        // Set program to close on window exit
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    private class ExitListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            System.exit( 0 );
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args )
    {
        new PostOfficeCalculator();
    }
}
