package negitaveDetector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class GuiController extends JFrame implements ActionListener
{

	public JLabel statusLabel;
	private JPanel contentPane;
	private JTextField Header;
	private JTextField BadwordsField;
	private JTextField UsercheckField;
	private JButton userChecker;
	private JButton PrintCensored;
	private JButton infobutt;
	public static JFileChooser fileDialog;
	private JButton addBad;
	JButton OpenText;
	protected static int intcounter;
	static JTextArea textArea;
	public static String file;
	
	public GuiController() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//*** Header ***
		Header = new JTextField();
		Header.setBounds(97, 32, 210, 35);
		Header.setEditable(false);
		Header.setFont(new Font("Arial", Font.PLAIN, 18));
		Header.setText("Negative Words Detector");
		contentPane.add(Header);
		Header.setColumns(10);
		
		
	}
	
	
		public void showFileChooser(String fileurl,GuiController guiControl)
		{
			// Here are all my buttons or text fields
			infobutt = new JButton("info");
			infobutt.setBounds(310, 296, 66, 23);
			infobutt.addActionListener(this);
			contentPane.add(infobutt);
			
			OpenText = new JButton("Open Text File");
			OpenText.setBounds(20, 82, 165, 43);
			OpenText.setFont(new Font("Tahoma", Font.PLAIN, 12));
			OpenText.addActionListener(this);
			contentPane.add(OpenText);
			
			BadwordsField = new JTextField();
			BadwordsField.setBounds(20, 169, 165, 27);
			contentPane.add(BadwordsField);
			BadwordsField.setColumns(10);
			
			UsercheckField = new JTextField();
			UsercheckField.setBounds(20, 252, 165, 27);
			contentPane.add(UsercheckField);
			UsercheckField.setColumns(10);
			
			userChecker = new JButton("Check Username");
			userChecker.setBounds(240, 251, 137, 27);
			userChecker.addActionListener(this);
			userChecker.setFont(new Font("Tahoma", Font.PLAIN, 12));
			contentPane.add(userChecker);
			
			PrintCensored = new JButton("Print Censored File");
			PrintCensored.setBounds(240, 82, 137, 43);
			PrintCensored.setFont(new Font("Tahoma", Font.PLAIN, 12));
			PrintCensored.setBackground(UIManager.getColor("Button.background"));
			PrintCensored.addActionListener(this);
			contentPane.add(PrintCensored);
			
			
			addBad = new JButton("Add Bad word");
			addBad.setBounds(240, 168, 137, 27);
			addBad.setFont(new Font("Tahoma", Font.PLAIN, 13));
			addBad.addActionListener(this);
			contentPane.add(addBad);
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 350, 380, 212);
			contentPane.add(scrollPane);
			
			textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
			fileDialog = new JFileChooser();
			FileNameExtensionFilter filter1 = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
			fileDialog.setFileFilter(filter1);
	}
		//Here all the buttons and textfields are used
		public void actionPerformed(ActionEvent e) 
		{
			//*** Open Text File Button****
			if (e.getSource() == OpenText) 
			{
	            int returnVal = fileDialog.showOpenDialog(GuiController.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) 
	            {
	            	//This is where the gui opens the file
	                File file = fileDialog.getSelectedFile();
	                
	                textArea.append("Opening: " + file.getName() + "." + "\n");
	            }
	            //I created an intcounter as a way to error check, the intcounter is initalised as 0 but when the file is selected it becomes 1
	            intcounter = 1;
				if (intcounter > 0)
				{
					//running the FileExaminer Replacer method
           			FileExaminer fe = new FileExaminer();
   					try 
   					{
						fe.Replacer();
					} 
   					catch (FileNotFoundException e1) 
   					{
						
						e1.printStackTrace();
					}
           		}
	            
	            
			}
			
			//*** Print Censored Comments Button***
			if (intcounter > 0){
				if(e.getSource() == PrintCensored)
				{
				
					for(int i = 0; i < FileExaminer.Comments.size(); i++)
					{
			    	
						textArea.append(FileExaminer.Comments.get(i)+ " ");
					}
				
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No File Choosen, Please Choose a file");
			}
			
			
			
			//*** User name Checker
			if(e.getSource() == userChecker)
			{
				String username;
				if (intcounter == 0)
				{
					JOptionPane.showMessageDialog(this, "You must select a File before testing username!!");
				}
				
				username = UsercheckField.getText();
				
				if (FileExaminer.badwords.contains(username))
				{
					textArea.append("The username "+username+ " contains foul language\n");
				}
				else
				{
					textArea.append("The username "+username+ " is safe to use\n");
				}
				
				
			}
			//*** Add Bad word into List of Bad words
			if(e.getSource() == addBad)
			{
				
				String badText;
				badText = BadwordsField.getText();
				FileExaminer.badwords.add(badText);
				textArea.append("badword '"+badText+ "' has been added\n");
				
			}
			if(e.getSource() == infobutt)
			{
				JOptionPane.showMessageDialog(this, "To Add a badword :\n\t\tWrite the badword into the field and press add badword button\n \t\tSelect the file again through open File\n \t\tPress the print button and watch the changes! ");
            }     
 }

}