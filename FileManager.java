package negitaveDetector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager 
{

	String fileName;
	File fBadwords;
	Scanner myScanner;
    //PrintWriter pwInput;
	
	// Constructor
	FileManager (String fileName)
	{
		
		this.fileName = fileName;
		
	}
	
	// get a connection to the file
	void connectToFile()
	{
		fBadwords = new File("src/negitaveDetector/badwords.txt");
	}

	// Read the file, returning a string of lines
    String[] readFile()
    {
    
    	String[] values = new String[6];
	    try
		{
	    	int i = 0;
	    	myScanner = new Scanner(fBadwords); 
			 while (myScanner.hasNextLine())
			    {
			      
				 values[i] = myScanner.nextLine();
			      i++;
			    }
		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
	    finally
	    {
	        return values;
	    }
    }
	
	
    void closeReadFile()
    {
		 myScanner.close();
    }
	

}
