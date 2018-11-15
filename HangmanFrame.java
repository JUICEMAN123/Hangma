import javax.swing.*;
import java.awt.*;

public class HangmanFrame extends JFrame{

	public Hangman panel = new Hangman(this);
	public static final int WIDTH = 768;
	public static final int HEIGHT = 524;

	public HangmanFrame(){
		setTitle("Hangman");
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
	}

	public static void main(String[] args){
		new HangmanFrame();
	}

}