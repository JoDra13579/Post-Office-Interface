/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.Scanner;

/**
 *
 * @author Doctor
 */
public class POList
{
    
	PostOffice[] poList;
	
	public POList( File listFile )
	{
		Scanner listIn = new Scanner( listFile );
		
		int lines = 0;
		while ( listIn.hasNext() )
		{
			lines++;
			listIn.nextLine();
		}
		listIn.reset();
	}
}
