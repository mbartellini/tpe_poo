package game.backend;

public abstract class GameState {

	private final int maxMoves;
	private long score;
	private int moves;

	public GameState(int maxMoves){
		this.maxMoves = maxMoves;
	}
	
	public void addScore(long value) {
		this.score = this.score + value;
	}
	
	public long getScore(){
		return score;
	}
	
	public void addMove() {
		moves++;
	}
	
	public int getMoves() {
		return moves;
	}

	public boolean gameOver() {
		return playerWon() || getMoves() >= maxMoves;
	}
	
	public abstract boolean playerWon();

	public String getStateString() {
		return String.format("Score: %d - Moves: %d/%d", getScore(), moves, maxMoves);
	}

}
