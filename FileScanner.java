package negitaveDetector;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class FileScanner 
{
	static ArrayList<String> badwords = new ArrayList<String>();
	//static ArrayList<String> foundwords = new ArrayList<String>(); PROBABLY WONT USE THIS CODE
	
	
	void ScanDocument() throws FileNotFoundException, NullPointerException
	{
		Scanner DicScanner = new Scanner(new File("src/negitaveDetector/badwords.txt")); //Dictionary Scanner
		//File Commments = new File(GuiControl.fileurl.getAbsolutePath()); //Comment Scanner UN-NEEDED LINE
		
		while(DicScanner.hasNextLine()) 
		{
			badwords.add(DicScanner.nextLine());
		}
		
		/* for(String s : badwords)
		 { //Prints list to test if it was successfully populated
			System.out.println(s);
		 } */
		DicScanner.close();
		//Comments.close();
		
	}


}
