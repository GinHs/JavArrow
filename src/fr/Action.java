package fr;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import fr.Window;

public class Action extends AbstractAction{
	public static final String NOM_ACTION = "Action";

	public Action() {
		super(NOM_ACTION);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//new Controler(Window.getInstance().getDraw());
}
}
