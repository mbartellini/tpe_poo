package game.backend.level;

import game.backend.GameState;

public class Level1 extends LevelGenerator {
	
	private static int REQUIRED_SCORE = 5000; 
	private static int MAX_MOVES = 20; 

	
	@Override
	protected GameState newState() {
		return new Level1State(REQUIRED_SCORE, MAX_MOVES);
	}

	
	private static class Level1State extends GameState {
		private final long requiredScore;
		
		public Level1State(long requiredScore, int maxMoves) {
			super(maxMoves);
			this.requiredScore = requiredScore;
		}
		
		public boolean playerWon() {
			return getScore() > requiredScore;
		}
	}
}
