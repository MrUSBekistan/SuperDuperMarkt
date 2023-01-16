package me.wittlage;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class Pickfile {

	File selectedFile;
	String path;
	
    public void auswahl(Boolean save) {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue;
        
        if (save) {
        	returnValue = jfc.showDialog(null,"Speichern");
        }
        else {
	        returnValue = jfc.showDialog(null,"Öffnen");
        
        }
       		if (returnValue == JFileChooser.APPROVE_OPTION) {
       		selectedFile = jfc.getSelectedFile();
       		this.path = selectedFile.getAbsolutePath();
        	}
    }
    
    public String getPath() {
        return this.path;
      }
}

