import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CeaserSgui extends JFrame{

	private JButton encryptC;
	private JLabel message1;
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
		
		messageS.setText("Offset for Ceaser Cypher");
		offset.setText("Message to Encrypt");
		
		encryptC = new JButton("Encrypt With Ceaser Cypher");
		encryptC.addActionListener(
			new ButtonCounterActionListener()
		);
		panel.add(encryptC);
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
