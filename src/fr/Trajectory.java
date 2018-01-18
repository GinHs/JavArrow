package fr;

import fr.eseo.javarrow.model.Arrow;
import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.ViewArrow;

/**
 * 
 * La classe Trajectory
 *  
 */
public class Trajectory {
	public Draw draw;
	public Arrow arrow;
	public float characterheight = 50;
	public float t = 0;
	public int n = 0;
	
	/**
	 * Constructeur de la classe Trajectory
	 * @param draw
	 * @param arrow
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 */
	public Trajectory (Draw draw,Arrow arrow,int x1,int x2,int y1,int y2) {
		this.arrow=arrow;
		this.draw=draw;
		this.characterheight=this.draw.getGame().getActivePlayer().getHeight();
		int sol = (int) this.draw.getGame().getActivePlayer().getY();
		Traject(this.draw.getGame().getActivePlayer().getX(),x1,x2,sol-y1,sol-y2);
	}
	
	
	
	/**
	 * 
	 * Cette fonction affiche la trajectoire selon les valeurs initiales du tir du joueur
	 * Elle appelle la fonction @see calculateTrajectory et affiche ensuite le tableau
	 *
	 *@param pos position du joueur qui est en train de joué
	 *@param x1 Abcsisse du premier point de contact du joueur
	 *@param y1 Ordonne du premier point de contact du joueur
	 *@param x2 Abscisse du point de relache du joueur
	 *@param y2 Ordonne du point de relache du joueur
	 *
	 */
	public void Traject(float pos,int x1,int x2,int y1,int y2){
	
		int [][]tab=calculateTrajectory((float)pos,(float)x1,(float)x2,(float)y1,(float)y2);
		int j=1;
		
		//Ajout des vues de fleche apres avoir calculé le tableau de la trajectoire
		while (j<tab[0].length-1 && !(tab[0][j+1]==0 && tab[1][j+1]==0)) {
			Arrow arrow = new Arrow(tab[0][j-1],tab[1][j-1],tab[0][j+1],tab[1][j+1]);
			
			//Pause de 25ms entre chaque nouvelle fleche
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		        
			//On ajoute la nouvelle vue
			this.draw.addView(new ViewArrow(arrow));
			//On actualise le paintcomponent pour afficher correctement la fleche
			this.draw.paintComponent(this.draw.getGraphics());
			j++;
		}
		
		//On test si le joueur est touche ou non
		//si il est touche on fini le round, sinon on change de joueur
		if (this.draw.getGame().getNotActivePlayer().isReach(tab[0][j],tab[1][j])) {
			draw.getGame().increaseRound();
		}else {
			draw.getGame().changeActivePlayer();;
		}
		this.draw.repaint();
		
	}
	
	
	
	/**
	 * 
	 * Cette fonction renvoie un tableau avec les points calculés de la trajectoire 
	 * selon les valeurs initiales du tir du joueur
	 * Elle limite la force des joueurs pour rendre le jeu plus difficile
	 * Elle calcule  la trajectoire de la parabole
	 * 
	 *
	 *@param x0 position du joueur qui est en train de joué
	 *@param x1 Abcsisse du premier point de contact du joueur
	 *@param y1 Ordonne du premier point de contact du joueur
	 *@param x2 Abscisse du point de relache du joueur
	 *@param y2 Ordonne du point de relache du joueur
	 *
	 */
	public int[][] calculateTrajectory(float x0,float x1,float x2,float y1,float y2) {
		//Fonction renvoyant un tableau avec tout les points de la trajectoire 
		// en fonction des valeurs initiales
		int [][] i = new int [2][10000];
		
		//On recupere la position des deux joueurs (car elle depend de la taille de l'ecran)
		int PosP1 =(int) this.draw.getGame().getPlayer1().getX();
		int PosP2 = (int) this.draw.getGame().getPlayer2().getX();
		
		//Limitation de la force maximum pour rendre le jeu plus difficile
		if ((x1-x2)*1080/this.draw.screenWidth>75) {
			x2=x1-75*this.draw.screenWidth/1080;
		} else if ((x1-x2)*1080/this.draw.screenWidth<-75){
			x2=x1+75*this.draw.screenWidth/1080;
		}
		
		//calcul de la trajectoire avec des parabole (droite parametre)
		//System.out.println("PosP2 : "+PosP2);
		
		while(((x1-x2)*t+x0)<(PosP2+1) && ((x1-x2)*t+x0)>(PosP1-1) && (-5*t*t+(y1-y2)*t+characterheight)<4000 && 0<(-5*t*t+(y1-y2)*t+characterheight) ) {
		i[0][n]=(int) ((x1-x2)*t+x0);
		i[1][n]=(int)(-5*t*t+(y1-y2)*t+characterheight);
		t=(float) (t+0.25);
		n++;
		}
		
		//Rectification pour que la derniere fleche soit sur le sol ou les murs
		if (n>2) {
			if (((x1-x2)*t+x0)>PosP2){
				i[0][n]=PosP2;
				i[1][n]=i[1][n-1]+(-i[1][n-2]+i[1][n-1]);
			}
			if (((x1-x2)*t+x0)<(PosP1)){
				i[0][n]=PosP1;
				i[1][n]=i[1][n-1]+(-i[1][n-2]+i[1][n-1]);
			}
			if (0>(-5*t*t+(y1-y2)*t+characterheight)) {
				i[0][n]=i[0][n-1]+(-i[0][n-2]+i[0][n-1]);
				i[1][n]=0;
			}
		}

		
		//on retourne la tableau rempli avec les valeurs de latrajectoire de la fleche
		return i;
		
	}
	

}
