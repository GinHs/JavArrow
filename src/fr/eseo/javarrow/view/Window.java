package fr.eseo.javarrow.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import fr.eseo.javarrow.controller.LaunchGameAction;
import fr.eseo.javarrow.model.Character;
import fr.eseo.javarrow.model.Game;


public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final String TITRE_PAR_DEFAUT = "JavArrow";
	private static Window instance = new Window();
	private Draw draw = new Draw(Draw.length,Draw.height,Draw.Color);
	private DrawBegin drawBegin = new DrawBegin(Draw.length,Draw.height,Draw.Color);
	public JTextField pseudo1 = new JTextField("Pseudo1",20);
	public JTextField pseudo2 = new JTextField("Pseudo2",20);
	
	private Window() {
		super(TITRE_PAR_DEFAUT);
		this.setPreferredSize(new Dimension(draw.screenWidth/4,draw.screenHeight/2));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		this.setLayout(new BorderLayout());
		this.add(drawBegin,BorderLayout.CENTER);
		
		JButton bouton = new JButton(new LaunchGameAction());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getPreferredSize().width/2, dim.height/2-this.getPreferredSize().height/2);
		JLabel title = new JLabel("Welcome to JavArrow");
		title.setFont(new Font("TimesRoman ",Font.BOLD,30));

		drawBegin.setLayout(new FlowLayout());
		drawBegin.setBackground(Color.WHITE);
		
		drawBegin.add(title);
		drawBegin.add(pseudo1);
		drawBegin.add(pseudo2);
		drawBegin.add(bouton);
 
		this.repaint();
	}
	
	public static Window getInstance(){
		return instance;
	}
	
	public Draw getDraw(){
		return this.draw;
	}
	
	public DrawBegin getDrawBegin(){
		return this.drawBegin;
	}
}
