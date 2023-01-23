package me.wittlage;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.NumberFormatter;

public class Gui{

		private JFrame myFrame;
		private JPanel panel;
		private JButton button, uebernehmen, ausfueren;
		private static JTextField inField;
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		JFormattedTextField daysField = new JFormattedTextField(numberFormatter);
		
		private JLabel userLabel, pwLabel;
		Pickfile explorerChoose;
		
		public static void infoBox(String infoMessage, String titleBar){   
		      JTextArea textArea = new JTextArea(5, 25);
		      textArea.setText(infoMessage);
		      textArea.setEditable(false);
		      JScrollPane scrollPane = new JScrollPane(textArea);
		      UIManager.put("OptionPane.minimumSize",new Dimension(840,420)); 
		      JOptionPane.showMessageDialog(null, scrollPane, "InfoBox: " + titleBar,
		  		    		JOptionPane.INFORMATION_MESSAGE);
		    
			}
		
		public void openGUI(){
		
		numberFormatter.setAllowsInvalid(false);
		myFrame = new JFrame();
		panel = new JPanel();
		myFrame.setTitle("Schuhe sortieren");
		myFrame.setSize(520,230);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(panel);
		
		panel.setLayout(null);
		
		
		userLabel = new JLabel("<html><body>1. Wählen Sie über den Öffnen-Button einen Sortimentsdatensatz<br>aus und übernehmen diesen durch drücken des entsprechnden Knopfes</body></html>");
		userLabel.setBounds(20, 20, 500, 30);
		panel.add(userLabel);
		
		inField = new JTextField();
		inField.setBounds(20,60,250,25);
		inField.setText("/Users/user/git/repository/SuperDuperMarkt/bin/me/wittlage/product_range.csv");
		panel.add(inField);
		
		
		pwLabel = new JLabel("<html><body>2. Geben Sie die Anzahl der Tagen an, für welche die Sortimentsplaung <br> ausgeführt werden soll und drüchen Sie anschließend auf Ausführen:</body></html>");
		pwLabel.setBounds(20, 100, 500, 30);
		panel.add(pwLabel);
		
		
		daysField = new JFormattedTextField(0);
		daysField.setBounds(20, 140, 65, 25);
		panel.add(daysField);

		
		button = new JButton("Öffnen");//Erstellt Button "Öffnen" für Explorer 
		button.setBounds(270, 60, 100, 25);
		//button.setBounds(x, y, width, height);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				explorerChoose = new Pickfile();
				explorerChoose.auswahl(false);
				try {
					inField.setText(explorerChoose.selectedFile.getPath());
				} catch (Exception e) {
					// TODO: handle exception
				}
					
			}
		});
		panel.add(button);

		uebernehmen = new JButton("Übernehmen");//Erstellt Button "Öffnen" für Explorer 
		uebernehmen.setBounds(370, 60, 120, 25);
		//button.setBounds(x, y, width, height);
		uebernehmen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Readfile.readIn(inField.getText());
					infoBox("\n Sortiment wurde erfolgreich eingelesen.", "Einlesen erfolgreich!");
				} catch (Exception e) {
					infoBox("\n Sortiment konnte nich eingelesen werden", "Einlesen fehlgeschlagen!");
				}
			}
		});
		panel.add(uebernehmen);
		
		ausfueren = new JButton("Ausführen");
		ausfueren.setBounds(120, 140, 100, 25);
		//button.setBounds(x, y, width, height);
		ausfueren.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					BusinessPractice practice = new BusinessPractice();
					String pass= daysField.getText();
					if(DemoData.getDemo().isEmpty()) {
						DemoData.makeData();
					}
					practice.ageByDays(0);
					for (int i = 0; i < Integer.parseInt(pass); i++) {
						practice.ageByDays(Long.valueOf(i+1));
					}
					infoBox(BusinessPractice.formatetInfo(), "Sortimentsausgabe für "+pass+" Tage");
					BusinessPractice.clearInfobox();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		panel.add(ausfueren);
		
		myFrame.setVisible(true);
		}
		
}




