package negitaveDetector;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, NullPointerException
	{
		//This GuiController Section is to open and run the GuiController
		GuiController  guiControl =  new GuiController();    
	    guiControl.showFileChooser(GuiController.file,guiControl);
	    
	    guiControl.setVisible(true);

	}

}
