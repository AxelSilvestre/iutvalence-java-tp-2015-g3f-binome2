package fr.sedara.Pusher.Display;

import fr.sedara.Pusher.Display.Menus.HomeMenu;
import fr.sedara.Pusher.Controller;

import javax.swing.JFrame;

public class TaskDisplay implements Runnable {

    public JFrame       frame;
    public JPanelGame   gamePanel;
    public JPanelEditor editorPanel;
    public HomeMenu     home;
    private final Controller controller;
    private KeyListener keyListener;

    public TaskDisplay(Controller controller) {
    	this.controller = controller;
	}
    

    public void run() {
        frame = new JFrame("Pusher");
        home = new HomeMenu(this);
        frame.setContentPane(home);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setEnabled(true);       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    public Controller getController() {
		return controller;
	}


	public void endGame(boolean win) {
		new JFrameEndGame(win, this);
		
	}
	
	public void setKeyListener(){
		frame.removeKeyListener(keyListener);
		keyListener = new KeyListener(controller.getGame(), this);
		frame.addKeyListener(keyListener);
		
	}


}
