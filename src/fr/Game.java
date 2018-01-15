package fr;
import fr.eseo.javarrow.model.Character;
public class Game {
	private Character player1;
	private Character player2;
	private Character activePlayer;
	
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
