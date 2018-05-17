import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;



public class CeaserSgui extends JFrame{

	private JButton encryptC, encryptA;
	private JLabel message1;
	private JCheckBox saveF;
	//Offset for the Ceaser Cypher and multby for how much to multiply for AlphaNum
	private JTextField offset, messageS;
	
		
	public CeaserSgui() {
		//All frame code goes here
		createView();
		
		setTitle("SafeFile");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		pack();
	}
	
	private void createView() {
		
		GridLayout layout = new GridLayout(0,3);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		 layout.setHgap(10);
      layout.setVgap(10);
      
      panel.setLayout(layout); 
		
	    message1 = new JLabel();
		//message1.setPreferredSize(
			//new Dimension(350, 300));
	   message1.setText("Encrypted Message: ");
	   panel.add(message1);

		//Add in the Textfield to put in the message
		messageS = new JTextField();
		messageS.setPreferredSize(
			new Dimension(250, 200)
		);
		panel.add(messageS);
		
		// Add in Offset and Multby
		offset = new JTextField();
		panel.add(offset);
		
		messageS.setText("Number to Offset or Multiply");
		offset.setText("Message to Encrypt");
		
		encryptC = new JButton("Encrypt With Ceaser Cypher");
		encryptC.addActionListener(
			new ButtonCounterActionListener()
		);
		
		panel.add(encryptC);
		
		saveF = new JCheckBox("Save File to txtE.txt ?");
		panel.add(saveF);
		
		
		//Adding in button to encrypt with AlphaNum
		encryptA = new JButton("Encrypt With AlphaNum");
		encryptA.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
			    
				 //eNCRYPTING cODE FOR aLPHAnUM
				  
				  String message = offset.getText();
				  int num = Integer.parseInt(messageS.getText());
				  
				  String t = "";
					for (int i = 0; i < message.length(); ++i) {
					    char ch = message.charAt(i);
					    if (!t.isEmpty()) {
					        t += " ";
					    }
					    int n = (int)ch - (int)'a' + 1;
					    t += String.valueOf(n);
					}
					System.out.println(t);
					
					// The string you want to be an integer array.
					String[] integerStrings = t.split(" "); 
					// Splits each spaced integer into a String array.
					int[] integers = new int[integerStrings.length]; 
					// Creates the integer array.
					for (int i = 0; i < integers.length; i++){
					    integers[i] = Integer.parseInt(integerStrings[i]); 
					//Parses the integer for each string.
					}
					

					for (int i = 0; i < integers.length; i++)
					    integers[i] = integers[i] * num;  
					
					
					System.out.println("Encrypted Message: " + Arrays.toString(integers));
					message1.setText("Encrypted Message: " + Arrays.toString(integers));
					
					Boolean sel = saveF.isSelected();
					
					if (sel =true) {
						
						createfile c = new createfile();
	        			c.openFile();
	        			c.addRecords( Arrays.toString(integers));
	        			c.closeFile();
						
					}
			  } 
			  
						} );
		
		panel.add(encryptA);
		
	}
	
	
	public static void main(String[] args) {
		//Makes TryCLickme where Frame Code goes
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				new CeaserSgui().setVisible(true);
			}
		});
	}
	
	private class ButtonCounterActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int offset;
			String offsetS = messageS.getText();
			String enc = CeaserSgui.this.offset.getText();
			
			offset = Integer.parseInt(offsetS);
			
		     offset = offset % 26 + 26;
		        StringBuilder encoded = new StringBuilder();
		        for (char i : enc.toCharArray()) {
		            if (Character.isLetter(i)) {
		                if (Character.isUpperCase(i)) {
		                    encoded.append((char) ('A' + (i - 'A' + offset) % 26 ));
		                } else {
		                    encoded.append((char) ('a' + (i - 'a' + offset) % 26 ));
		                }
		            } else {
		                encoded.append(i);
		            }
		            
		        }
		        message1.setText("Encrypted Message: " + encoded.toString()); 
	}
	}	
}
