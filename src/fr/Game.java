package fr;

public class Game {
	private Character player1;
	private Character player2;
	private Character activePlayer;
	private int deltaX;
	private int deltaY;
	private int scorePlayer1;
	private int scorePlayer2;
	private JPanel JPanelPlayer1;
	private JPanel JPanelPlayer2;
	private Trajectory trajectory;
	
	public Game(Character player1, Character player2, Character activePlayer) {
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setActivePlayer(activePlayer);
	}
	
	public void playARound(float angle, float initialSpeed) {
		this.getActivePlayer();
		//test commit
		this.changeActivePlayer();
	}
	
	private void changeActivePlayer() {
		if(this.getActivePlayer().equals(this.getPlayer1())) {
			this.setActivePlayer(this.getPlayer2());
		} else {
			this.setActivePlayer(this.getPlayer1());
		}
	}
	
	public Trajectory getTrajectory() {
		return this.trajectory;
	}
	
	public void setTrajectory(Trajectory trajectory) {
		this.trajectory = trajectory;
	}
	
	public JPanel getJPanelPlayer2() {
		return this.JPanelPlayer2;
	}
	
	public void setJPanelPlayer2(JPanel JPanelPlayer2) {
		this.JPanelPlayer2 = JPanelPlayer2;
	}
	
	public JPanel getJPanelPlayer1() {
		return this.JPanelPlayer1;
	}
	
	public void setJPanelPlayer1(JPanel JPanelPlayer1) {
		this.JPanelPlayer1 = JPanelPlayer1;
	}
	
	public int getNumManche() {
		return this.getScorePlayer1() + this.getScorePlayer2();
	}

	public int getDeltaY() {
		return this.deltaY;
	}
	
	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}
	
	public int getDeltaX() {
		return this.deltaX;
	}
	
	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}

	public int getScorePlayer2() {
		return this.scorePlayer2;
	}
	
	public void setScorePlayer2(int scorePlayer2) {
		this.scorePlayer2 = scorePlayer2;
	}
	
	public int getScorePlayer1() {
		return this.scorePlayer1;
	}
	
	public void setScorePlayer1(int scorePlayer1) {
		this.scorePlayer1 = scorePlayer1;
	}
	
	public Character getActivePlayer() {
		return activePlayer;
	}
	
	public void setActivePlayer(Character activePlayer) {
		this.activePlayer = activePlayer;
	}
	
	public Character getPlayer2() {
		return player2;
	}
	
	public void setPlayer2(Character player2) {
		this.player2 = player2;
	}
	
	public Character getPlayer1() {
		return player1;
	}
	
	public void setPlayer1(Character player1) {
		this.player1 = player1;
	}
	
}
