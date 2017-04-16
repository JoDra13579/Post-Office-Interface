/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Doctor
 */
public class POList
{
    
    PostOffice[] poList;

    /**
     * Parameterized constructor 
     * @param listFile
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
