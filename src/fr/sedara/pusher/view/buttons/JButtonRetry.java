package fr.sedara.pusher.view.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.sedara.pusher.controller.LevelFileManager;
import fr.sedara.pusher.model.Board;
import fr.sedara.pusher.view.JPanelGame;
import fr.sedara.pusher.view.TaskDisplay;

public class JButtonRetry extends JButton implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private final TaskDisplay taskDisplay;
	
	private JFrame frame;

	public JButtonRetry(JFrame frameToClose, TaskDisplay taskDisplay) {
		super(taskDisplay.getController().getString("retry"));
		frame = frameToClose;
		this.taskDisplay = taskDisplay;
		addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
        Board c = null;
        try {
            c = LevelFileManager.load(taskDisplay.getController().getGame().getCurrentLevel());
        }
        catch (ClassNotFoundException e1) {}
        catch (IOException e1) {}
        JPanelGame j = new JPanelGame(c, taskDisplay);
        taskDisplay.gamePanel = j;
        taskDisplay.frame.setContentPane(taskDisplay.gamePanel);
        taskDisplay.frame.revalidate();
		taskDisplay.frame.setEnabled(true);
		taskDisplay.frame.toFront();
		taskDisplay.getController().createNewGame(c, taskDisplay.getController().getGame().getCurrentLevel());
		taskDisplay.setKeyListener();
		frame.dispose();
		frame.setState(JFrame.EXIT_ON_CLOSE);
		
	}

}
