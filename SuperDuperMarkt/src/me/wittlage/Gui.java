package me.wittlage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class Gui{

		private JFrame myFrame;
		private JPanel panel;
		private JButton button, prufen;
		private static JTextField inField;
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();
		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		JFormattedTextField daysField = new JFormattedTextField(numberFormatter);
		
		private JLabel userLabel, pwLabel, erfolg;
		Pickfile explorerChoose;
		
		public static void infoBox(String infoMessage, String titleBar){
		    JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar,
		    		JOptionPane.INFORMATION_MESSAGE);
			}
		
		public void openGUI(){
		
		numberFormatter.setAllowsInvalid(false);
		myFrame = new JFrame();
		panel = new JPanel();
		myFrame.setTitle("Schuhe sortieren");
		myFrame.setSize(400,170);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Input-Datei:");
		userLabel.setBounds(20, 20, 80, 25);
		panel.add(userLabel);
		
		inField = new JTextField();
		inField.setBounds(103,20,165,25);
		inField.setText("/Users/user/Downloads/shoes.csv");
		panel.add(inField);
		
		pwLabel = new JLabel("Ausgabe:");
		pwLabel.setBounds(20, 50, 80, 25);
		panel.add(pwLabel);
		
		
		daysField = new JFormattedTextField(0);
		daysField.setBounds(103, 50, 165, 25);
		panel.add(daysField);
		
		erfolg = new JLabel();
		erfolg.setBounds(20, 115, 300, 25);
		
		button = new JButton("Öffnen");//Erstellt Button "Öffnen" für Explorer 
		button.setBounds(270, 20, 85, 25);
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

		
		prufen = new JButton("Ausführen");
		prufen.setBounds(40, 100, 100, 25);
		//button.setBounds(x, y, width, height);
		prufen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Readfile.readIn(inField.getText());
					//Readfile.writeOut(daysField.getText());
					BusinessPractice practice = new BusinessPractice();
					String pass= daysField.getText();
					practice.ageByDays(Long.parseLong(pass));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.add(prufen);
		
		myFrame.setVisible(true);
		}
		
}




