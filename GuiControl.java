package negitaveDetector;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;
 
public class GuiControl {
    
   public JFrame mainFrame;
   public JLabel headerLabel;
   public JLabel statusLabel;
   public JPanel controlPanel;
   static File fileurl= new File("Start.txt");
 
   public GuiControl(){
      prepareGUI();
   }

  

   public void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void showFileChooser(File fileurl){
	  GuiControl.fileurl = fileurl;
      headerLabel.setText("Control in action: JFileChooser"); 

      final JFileChooser  fileDialog = new JFileChooser();
      JButton showFileDialogButton = new JButton("Open File");
      showFileDialogButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            int returnVal = fileDialog.showOpenDialog(mainFrame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               java.io.File fileurl = fileDialog.getSelectedFile();
               statusLabel.setText("File Selected :" 
               + fileurl.getName());
               System.out.println(fileurl + " Is Now Open!");
            }
            else{
               statusLabel.setText("Open command cancelled by user." );           
            }     
			
         }
      });
      
      controlPanel.add(showFileDialogButton);
      mainFrame.setVisible(true);  
      
      
   }
  // static String urlfile = fileurl.getPath();
}