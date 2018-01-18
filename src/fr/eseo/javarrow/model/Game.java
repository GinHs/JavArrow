package fr.eseo.javarrow.model;

import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.Window;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.Trajectory;

public class Game {
	private static final int ROUNDMAX = 5;
	private Character player1;
	private Character player2;
	private Character activePlayer;
	private int round;
	private int scorePlayer1;
	private int scorePlayer2;
	private Draw draw;
	
	
	public Game(Draw draw,Character player1, Character player2) {
		this.draw=draw;
		this.setPlayer1(player1);
		this.setPlayer2(player2);
		this.setActivePlayer(player1);
		this.setRound(1);
		this.setScorePlayer1(0);
		this.setScorePlayer2(0);
	}
	
	public void increaseRound() {
		/**Cette fonction est appele lors de la fin d'une manche
		 *Elle actualise le score du joueur qui a gagne
		 *Elle check le nombre de round, elle arrete la partie si c'est le dernier
		 *Elle change un round sur deux le premier joueur de la manche 
		 */
		if(this.activePlayer==this.player1) {
			this.setScorePlayer1(this.getScorePlayer1()+1);
		}else {
			this.setScorePlayer2(this.getScorePlayer2()+1);
		}
		//On check si c'est le dernier round
		if (round != ROUNDMAX) {
		this.round++;
		//On change un round sur deux le premier joueur de la manche
		if (0==round%2) {
			this.setActivePlayer(player2);
		}else {
			this.setActivePlayer(player1);
		}
		}else {
			//Sinon la partie est gagne
			draw.win = true;
		}
		}
	
	public void changeActivePlayer() {
		/**
		 * Cette fonction permet de changer de joueur (Joueur actif)
		 */
		if(this.getActivePlayer().equals(this.getPlayer1())) {
			this.setActivePlayer(this.getPlayer2());
		} else {
			this.setActivePlayer(this.getPlayer1());
		}
	}
	

	
	public Character getNotActivePlayer() {
		/**
		 * Cette fonction permet de recuperer le joueur qui ne joue pas (Joueur qui est vise)
		 */
		if(this.getActivePlayer().equals(this.getPlayer1())) {
			return this.getPlayer2();
		} else {
			return this.getPlayer1();
		}
	}
	
	///////////////////////////
	// ACCESSEURS ET GETTERS //
	///////////////////////////

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
	
	public int getRound() {
		return this.round;
	}
	
	public void setRound(int round) {
		this.round = round;
	}

	
}
