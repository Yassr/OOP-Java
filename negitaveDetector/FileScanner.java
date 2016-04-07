package negitaveDetector;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileScanner 
{
	
	String[] ScanDocument() throws FileNotFoundException
	{
		List<String> badwords = new ArrayList<String>();
		Scanner DicScanner = new Scanner(new File("src/negitaveDetector/badwords.txt"));
		Scanner ComScanner = new Scanner(new File("src/negitaveDetector/RandomComments.txt"));
		
		while(DicScanner.hasNextLine()) 
		{
			badwords.add(DicScanner.nextLine());
		}
		System.out.println(Arrays.toString(badwords.toArray()));
		DicScanner.close();
		String[] words = new String[badwords.size()];
		words = badwords.toArray(words);
		return words;
	}
	
	//private Scanner DicScanner; //Dictionary Scanner for the Bad words file
	//private Scanner ComScanner; //Comments Scanner for the RandomComments file
	
	/*public void openFile()
	{
		try{
			//File fd = new File("/OOP-Java/NegitaveDetector/src/negitaveDetector/badwords.txt");
			//File fc = new File("/OOP-Java/NegitaveDetector/src/negitaveDetector/RandomComments.txt");
			
			Scanner DicScanner = new Scanner("src/negitaveDetector/badwords.txt");
			Scanner ComScanner = new Scanner("src/negitaveDetector/RandomComments.txt");
		}
		catch(Exception e){
			System.out.println("Could not find files meow");
		}
		
		
	}
	
	public void readFile()
	{
		ArrayList<String> badwords = new ArrayList<String>();
			while(DicScanner.hasNextLine()) 
			{
				badwords.add(DicScanner.nextLine());
			}
			Collections.sort(badwords);
			System.out.println(Arrays.toString(badwords.toArray()));
	}
	
	public void closeFile()
	{
		DicScanner.close();
		ComScanner.close();
	}
	
	/*File fdictionary = new File("badwords.txt");
	Scanner DicScanner = new Scanner(fdictionary);
	
	File ftext = new File("RandomComments.txt");
	Scanner ComScanner = new Scanner(ftext);
	
	
	for (String line : Files.readAllLines(Paths.get("badwords.txt"))) 
	{
		
	}*/
	
}
