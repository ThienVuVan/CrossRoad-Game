package utilz;

public class stateConstants {
	public enum AnimalState {
		MOUSE, CAT, DOG, NOANI;
		
		public static AnimalState state = NOANI;
	}
	
	public enum GameState {
		PLAYING, MENU, OVER, EXIT;
		
		public static GameState state = MENU;
	}
	
	public enum MapState {
		MAP1, MAP2, NOMAP;
		
		public static MapState state = NOMAP;
	}
	
	public enum MenuState {
		MENU1, MENU2;
		public static MenuState state = MENU1;
	}
	
	public enum ScoreState {
		MARK1, MARK2, MARK3;
		public static ScoreState state = MARK1;
	}
	
	public enum NextState{
		NO, YES;
		public static NextState state = NO;
	}
	
	public enum PlayState{
		NO, YES;
		public static PlayState state = NO;
	}
	
}
