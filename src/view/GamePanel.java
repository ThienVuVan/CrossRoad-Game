package view;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import controller.Game;
import inputs.KeyboardInput;
import inputs.MouseInput;



@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	private Game game;
	private MouseInput mouseInput;
	private KeyboardInput keyboardInput;

	public GamePanel(Game game) {
		this.game = game;
		keyboardInput = new KeyboardInput(this);
		mouseInput = new MouseInput(this);
		setPanelSize();
		addKeyListener(keyboardInput);
		addMouseListener(mouseInput);
		addMouseMotionListener(mouseInput);
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1000,600);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
	}
	
	public Game getGame() {
		return game;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}
}
