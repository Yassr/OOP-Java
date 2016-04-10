package negitaveDetector;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileExaminer 
{
	void Replacer() throws FileNotFoundException
	{
	
	// You can also create a new list out of the existing list.
    // That way, you won't need to modify the existing one.
    List<String> newComments = new ArrayList<String>();
    List<String> Comments = new ArrayList<String>();
    //if (GuiControl.fileurl != null){
    	System.out.println(GuiControl.fileurl+" HAPPY");
		Scanner CScanner = new Scanner(new File(GuiControl.fileurl.getPath()));
    
    
    
    
   
    while(CScanner.hasNextLine()) 
	{
		Comments.add(CScanner.nextLine());
	}
    
    for(int i = 0; i > FileScanner.badwords.size(); i++)
    {
       
            newComments.add(Comments.get(i).replaceAll(FileScanner.badwords.get(i), "****"));
           //someList.set(i, someList.get(i).replace(someString, otherString));
        

     }
     System.out.println(Comments);  // Original
     System.out.println(newComments);   // New List
     CScanner.close();

	}
	
}