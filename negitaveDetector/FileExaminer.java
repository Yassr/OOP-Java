/**
 * Negitave Words Detector by Yassr Shaar.
 * 
 *	Negative words detector scans through a text file and censors any words deemed to be of foul language.
 *	Negative words detector opens a text file of badwords puts the words into a list and checks if the text file that we later choose
 *	contains any badwords, if it does they are replaced with "****" indecating that those words were indeed bad.
 *	This program also allows the user to add bad words to the list and also to check if their user name is deemed to be foul or not.
 */
package negitaveDetector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//FileExaminer Creates 2 lists one for the comments that are passed from the GuiController
//And one for the list of badwords, it then scans through the comments replacing bad words with stars
public class FileExaminer 
{
	String temp, line;
	static String words;
	//The two lists are being created here
	static List<String> Comments = new ArrayList<String>();
	static ArrayList<String> badwords = new ArrayList<String>();
	void Replacer() throws FileNotFoundException
	{
	// The text file also know as "Comments" file is passed from the JFileChooser in GuiController
    File file = GuiController.fileDialog.getSelectedFile();
  
    //Scanner used to scan through the opened file
	Scanner CScanner = new Scanner(file);
	Scanner BadScanner = new Scanner(new File("badwords.txt")); //http://urbanoalvarez.es/blog/2008/04/04/bad-words-list/ Badwords list downloaded from here
    
	//This takes out any stars or brackets that were in the badwords text file
	while(BadScanner.hasNextLine()) 
	{
		words = BadScanner.nextLine();
		words = words.replace("*", "");
		words = words.replace("(", "");
		badwords.add(words);
	}
	
    //A temp scanner is used to scan word for word as the CScanner is used for line by line
    while(CScanner.hasNextLine())
    {
    	temp = CScanner.nextLine();
    	Scanner TempScanner = new Scanner(temp);
    	while(TempScanner.hasNext())
    	{
    		temp = TempScanner.next();
    		//bad words are being changed to stars
    		if (badwords.contains(temp))
            {
             temp = "****";
            }
    		Comments.add(temp);
    	}
    	Comments.add("\n");
    }
    

    //close both scanners here
    BadScanner.close();
    CScanner.close();

	}

}