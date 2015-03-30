package fr.sedara.Pusher.Display.JButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fr.sedara.Pusher.Champs;
import fr.sedara.Pusher.LevelFileManager;
import fr.sedara.Pusher.Pusher;
import fr.sedara.Pusher.Display.JPanelGame;
import fr.sedara.Pusher.Display.TaskDisplay;

public class JButtonPlayLevel extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;
	private String fileName;

	public JButtonPlayLevel() {
		super("Jouer");
		fileName = "";
	}

	public void actionPerformed(ActionEvent e) {
		if(!fileName.equalsIgnoreCase("")){
			Champs c = null;
			try {
				c = LevelFileManager.load(fileName);
			} catch (ClassNotFoundException e1) {} catch (IOException e1) {}
			Pusher.setChamps(c);
			JPanelGame j = new JPanelGame(c);
			TaskDisplay.frame.setContentPane(j);
			TaskDisplay.frame.setSize(j.getChamps().getX()*50,j.getChamps().getY()*50);
			TaskDisplay.frame.revalidate();
		}
		
	}
	
	public void setFileName(String name){
		fileName = name;
	}
	
	
}
