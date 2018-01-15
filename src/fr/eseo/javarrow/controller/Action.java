package fr.eseo.javarrow.controller;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import fr.eseo.javarrow.view.Window;

public class Action extends AbstractAction{
	public static final String NAME_ACTION = "Action";

	public Action() {
		super(NAME_ACTION);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Controler(Window.getInstance().getDraw());
	}
}

