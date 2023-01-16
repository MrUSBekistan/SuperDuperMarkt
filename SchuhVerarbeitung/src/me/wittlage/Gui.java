package me.wittlage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui{

		private JFrame myFrame;
		private JPanel panel;
		private JButton button, auspfad, prufen;
		private static JTextField userText, pwText;
		private JLabel userLabel, pwLabel, erfolg;
		Pickfile explorerChoose;
		
		public static void infoBox(String infoMessage, String titleBar){
		    JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar,
		    		JOptionPane.INFORMATION_MESSAGE);
			}
		
		public void openGUI(){
		
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
		
		userText = new JTextField();
		userText.setBounds(103,20,165,25);
		userText.setText("/Users/user/Downloads/shoes.csv");
		panel.add(userText);
		
		pwLabel = new JLabel("Ausgabe:");
		pwLabel.setBounds(20, 50, 80, 25);
		panel.add(pwLabel);
		
		pwText = new JTextField();
		pwText.setBounds(103, 50, 165, 25);
		pwText.setText("/Users/user/Desktop/test.csv");
		panel.add(pwText);
		
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
					userText.setText(explorerChoose.selectedFile.getPath());
				} catch (Exception e) {
					// TODO: handle exception
				}
					
			}
		});
		panel.add(button);
		
		auspfad = new JButton("Speichern");//Erstellt Button Speichern für Explorer
		auspfad.setBounds(270, 50, 85, 25);
		//button.setBounds(x, y, width, height);
		auspfad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				explorerChoose = new Pickfile();
				explorerChoose.auswahl(true);
				try {
					pwText.setText(explorerChoose.selectedFile.getPath());	
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		panel.add(auspfad);

		
		prufen = new JButton("Ausführen");
		prufen.setBounds(40, 100, 100, 25);
		//button.setBounds(x, y, width, height);
		prufen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Readfile.readIn(userText.getText());
					Readfile.writeOut(pwText.getText());
					infoBox(Countcolor.zaehle(Readfile.getFarben()), "Anzahl der Farben");
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




