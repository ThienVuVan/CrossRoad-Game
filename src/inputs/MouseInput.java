package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import utilz.stateConstants.GameState;
import view.GamePanel;

public class MouseInput implements MouseListener, MouseMotionListener {
	
	private GamePanel gamePanel;
	
	public MouseInput(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(GameState.state) {
		case MENU:
			gamePanel.getGame().getMenu().mousePressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getPlaying().mousePressed(e);
			break;
		case OVER:
			gamePanel.getGame().getOver().mousePressed(e);
		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//gamePanel.getGame().getAnimal().setUp(false);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
