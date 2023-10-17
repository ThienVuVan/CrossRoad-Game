package view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	private JFrame jframe;
	public GameWindow(GamePanel gamePanel) {
		jframe = new JFrame();
		jframe.add(gamePanel);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
	}
}
