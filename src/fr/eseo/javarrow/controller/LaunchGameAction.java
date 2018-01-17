package fr.eseo.javarrow.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.javarrow.model.Character;
import fr.eseo.javarrow.model.Game;
import fr.eseo.javarrow.view.Draw;
import fr.eseo.javarrow.view.Window;

public class LaunchGameAction extends AbstractAction{
	public static final String NAME_ACTION = "Lancer la partie";

	public LaunchGameAction() {
		super(NAME_ACTION);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Window window = Window.getInstance();
		Draw draw = window.getDraw();
		
		new Controler(Window.getInstance().getDraw());

		// Mettre a jour les pseudos
		draw.getGame().getPlayer1().setName(window.pseudo1.getText());
		draw.getGame().getPlayer2().setName(window.pseudo2.getText());
		
		window.setContentPane(Window.getInstance().getDraw());
		window.setPreferredSize(new Dimension(1920,1080));
		window.setLocation(0,0);
		window.pack();
		window.revalidate();
		window.repaint();
	}
}
