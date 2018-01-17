package fr.eseo.javarrow.model;

import fr.eseo.javarrow.view.Draw;
import fr.Trajectory;

public class Game {
	private Character player1;
	private Character player2;
	private Character activePlayer;
	

	//private int scorePlayer1;
	//private int scorePlayer2;
	private Draw JPanelGame;
	private Draw JPanelPlayer1;
	private Draw JPanelPlayer2;
	private Trajectory trajectory;
	
	public Game(Character player1, Character player2) {
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setActivePlayer(player1);
		//this.setScorePlayer1(0);
		//this.setScorePlayer2(0);
	}
	
	public void activePlayerAiming(int position, int x1, int x2, int y1, int y2) {
		Arrow a = new Arrow(0,0,0,0);
		Trajectory aimingTrajectory = new Trajectory(this.JPanelGame,a, x1, x2, y1, y2);
		//construction et envoi du JPanel
		//sendToActivePlayer(this.drawAimingPanel(aimingTrajectory));
	}
	
	public void activePlayerShooting(int deltaX, int deltaY) {
		/*this.setTrajectory(new Trajectory(deltaX, deltaY));
		sendToPlayers(this.drawingAnimationPanel());*/
	}
	
	/* JPanel pour l'animation flèche */
	public Draw drawingAnimationPanel() {
		return null;//A JPanel
	}
	
	/* JPanel pour le joueur qui vise */
	public Draw drawAimingPanel() {
		return null;//A JPanel
	}
	
	public void playARound() {
		/*Arrow arrow = new Arrow(this.getActivePlayer().getX(), 
				this.getActivePlayer().getY() +
				this.getActivePlayer().getHeight());
		Trajectory trajectory = new Trajectory(arrow);
		while()
		this.changeActivePlayer();*/
	}
	
	public void changeActivePlayer() {
		if(this.getActivePlayer().equals(this.getPlayer1())) {
			this.setActivePlayer(this.getPlayer2());
		} else {
			this.setActivePlayer(this.getPlayer1());
		}
	}
	
	public Draw getActiveJPanel() {
		if(this.getActivePlayer().equals(this.getPlayer1())) {
			return this.getJPanelPlayer1();
		} else {
			return this.getJPanelPlayer2();
		}
	}
	
	public Character getNotActivePlayer() {
		if(this.getActivePlayer().equals(this.getPlayer1())) {
			return this.getPlayer2();
		} else {
			return this.getPlayer1();
		}
	}
	
	
	public Trajectory getTrajectory() {
		return this.trajectory;
	}
	
	public void setTrajectory(Trajectory trajectory) {
		this.trajectory = trajectory;
	}
	
	public Draw getJPanelGame() {
		return this.JPanelGame;
	}
	
	public void setJPanelGame(Draw JPanelGame) {
		this.JPanelGame = JPanelGame;
	}
	
	public Draw getJPanelPlayer2() {
		return this.JPanelPlayer2;
	}
	
	public void setJPanelPlayer2(Draw JPanelPlayer2) {
		this.JPanelPlayer2 = JPanelPlayer2;
	}
	
	public Draw getJPanelPlayer1() {
		return this.JPanelPlayer1;
	}
	
	public void setJPanelPlayer1(Draw JPanelPlayer1) {
		this.JPanelPlayer1 = JPanelPlayer1;
	}
	
	/*public int getNumManche() {
		return this.getScorePlayer1() + this.getScorePlayer2();
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
*/
	public void win() {
		this.getActivePlayer();
		
	}
	
}
