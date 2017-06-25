package utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import org.pushingpixels.substance.api.skin.RavenSkin;
import org.pushingpixels.substance.api.skin.SubstanceRavenLookAndFeel;

public class SteroidsPk_Cache_Remover {

private static final String USER_HOME = System.getProperty("user.home");
private static final String CACHE_DIRECTORY = USER_HOME + File.separator + "SteroidsPk Files";
private static JTextArea outputArea;
private static JButton okButton;

public static void main(String[] args) {
    JDialog.setDefaultLookAndFeelDecorated(true);
    JPopupMenu.setDefaultLightWeightPopupEnabled(true);
    //SubstanceBusinessBlackSteelLookAndFeel.setSkin(new AutumnSkin());
    SubstanceRavenLookAndFeel.setSkin(new RavenSkin());
{

	File directory = new File(CACHE_DIRECTORY);
	int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to REMOVE SteroidsPk's Cache?", "Confirm", JOptionPane.YES_NO_OPTION);

	if (option == 0) {
	   System.out.print("yes");
	} else {
	   System.out.print("no");
	   System.exit(0);
	}
	//make sure directory exists
	if(!directory.exists()){

       System.out.println("Directory does not exist.");
       
       JOptionPane.showMessageDialog(null, "SteroidsPk Cache Directory does not exist!");
       System.exit(0);


    }else{

       try{
           delete(directory);

       }catch(IOException e){
           e.printStackTrace();
           System.exit(0);
       }
    }

	System.out.println("Done");
}
}

public static void delete(File file)
	throws IOException{

	if(file.isDirectory()){

		//directory is empty, then delete it
		if(file.list().length==0){

		   file.delete();
		  System.out.println("Directory is deleted : "
                                             + file.getAbsolutePath());
 		   JOptionPane.showMessageDialog(null, "SteroidsPk's Cache is Deleted : ", "Finished", 0);
		  
		  //JOptionPane.showMessageDialog(null, "Directory is deleted : "
                  //+ file.getAbsolutePath());
		}else{

		   //list all the directory contents
    	   String files[] = file.list();

    	   for (String temp : files) {
    	      //construct the file structure
    	      File fileDelete = new File(file, temp);

    	      //recursive delete
    	     delete(fileDelete);
    	   }

    	   //check the directory again, if empty then delete it
    	   if(file.list().length==0){
       	     file.delete();
    	     System.out.println("Directory is deleted : "
                                             + file.getAbsolutePath());
    	     
   		  //JOptionPane.showMessageDialog(null, "Directory is deleted : "
                 // + file.getAbsolutePath());
    	   }
		}

	}else{
		//if file, then delete it
		file.delete();
		System.out.println("File is deleted : " + file.getAbsolutePath());
		
		   //JOptionPane.showMessageDialog(null, "SteroidsPk's Cache is Deleted : ", "Finished", 0);
                  //+ file.getAbsolutePath());
	}
}
}