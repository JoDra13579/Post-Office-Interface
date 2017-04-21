//-CST183-Tim Klingler-
/**
 * This class contains a panel and an array of buttons for controlling the
 * <code>PostOfficeCalculator</code> application.
 * @author Jordan Drake
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonsPanel extends JPanel
{
    JButton[] nums = new JButton[ 12 ];
    ZipField searchBox;                // The ZipField to read searches from
    PostOfficeCalculator parent;       // The parent application
    
    public ButtonsPanel( ZipField searchBox, PostOfficeCalculator parent )
    {
        // Assign searchBox and parent fields for the class
        this.searchBox = searchBox;
        this.parent    = parent;
        
        // Create grid layout for button panel
        this.setLayout( new GridLayout( 4, 3, 5, 5 ) );
        
        // Populate first 9 entries of the button array with numerical buttons
        // and add them to the layout
        int i;
        for ( i = 0; i < 9; i++ )
        {
            nums[ i ] = new JButton( i + 1 + "" );
            this.add( nums[ i ] );
        }
        
        // Create last row of buttons and add them to the layout
        nums[ i ] = new JButton( "CLR" );
        this.add( nums[ i++ ] );
        nums[ i ] = new JButton( 0 + "" );
        this.add( nums[ i++ ] );
        nums[ i ] = new JButton( "FIND" );
        this.add( nums[ i++ ] );
        
        // Associate ButtonListener with all buttons in array
        for ( JButton b : nums )
            b.addActionListener( new ButtonListener() );
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            // Check for first 9 numeric buttons
            int i;
            for ( i = 0; i < 9; i++ )
                if ( e.getSource() == nums[ i ] )
                    searchBox.type( i + 1 );
            
            // Check for CLR button
            if ( e.getSource() == nums[ i++ ] )
                searchBox.clear();
            
            // Check for 0 button
            if ( e.getSource() == nums[ i++ ] )
                searchBox.type( 0 );
            
            // Check for SEARCH button
            if ( e.getSource() == nums[ i++ ] )
                parent.search( Integer.parseInt( searchBox.getText() ) );
        }
    }
}
