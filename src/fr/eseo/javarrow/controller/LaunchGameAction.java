package fr.eseo.javarrow.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.Window;

/**
 * Controleur pour la creation d'une partie
 */
@SuppressWarnings("serial")
public class LaunchGameAction extends AbstractAction{
	public static final String NAME_ACTION = "Lancer la partie";

	public LaunchGameAction() {
		super(NAME_ACTION);
	}
	/**
	 * Change le panel associé à la fenetre et récupère les données des JTextField
	 * Met à jour les pseudos
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Window window = Window.getInstance();
		Draw draw = window.getDraw();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		new Controler(Window.getInstance().getDraw());

		// Mettre a jour les pseudos
		draw.getGame().getPlayer1().setName(window.pseudo1.getText());
		draw.getGame().getPlayer2().setName(window.pseudo2.getText());
		
		window.setContentPane(Window.getInstance().getDraw());
		window.setPreferredSize(new Dimension(dim.width,dim.height));
		window.setLocation(0,0);
		window.pack();
		window.revalidate();
		window.repaint();
	}
}
