package negitaveDetector;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, NullPointerException
	{
		GuiControl  GuiControl = new GuiControl();      
	    GuiControl.showFileChooser(negitaveDetector.GuiControl.fileurl);
	    
		FileScanner r = new FileScanner();
		
		//GuiControl g = new GuiControl();
		
		r.ScanDocument();
		
		FileExaminer fe = new FileExaminer();
		
		fe.Replacer();
		
	
		
		
	}

}
