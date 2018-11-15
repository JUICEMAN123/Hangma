import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hangman extends JPanel{

	static String word;
	static Scanner k = new Scanner(System.in);
	static boolean[] guessedWord;
	static char[] wordChars;

	static int lives = 6;
	static int correct = 0;

	HangmanFrame frame;

	JTextField in = new JTextField();
	JTextArea text = new JTextArea();

	public Hangman(HangmanFrame frame){
		this.frame = frame;
		setLayout(null);

		in.setBounds(10, frame.HEIGHT - 85, frame.WIDTH - 20, 50);
		in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word = in.getText();
				in.setText("");
			}
		});
		add(in);

		text.setBounds(frame.WIDTH - 200, 20, 180, 50);

	}

	static void runGame(){
		lives = 6;
		correct = 0;
		guessedWord = new boolean[word.length()];
		wordChars = word.toCharArray();
		playGame();
	}

	static void getWord(){
		System.out.println("Enter Word --> ");
		for(int i = 0; i < 200; i++){
			System.out.println();
		}
	}

	static void playGame(){
		System.out.println(buildWord());
		while(true){
			System.out.println("Enter Letter --> ");
			char c = k.next().charAt(0);
			boolean inWord = checkWord(c);
			if(!inWord){
				lives--;
				System.out.println("Not in Word. Try Again!");
			}
			else {
				System.out.println("The letter " + c + " is in this word");
			}
			if(lives > 0){
				System.out.println(buildWord());
				System.out.println();
				if(correct == word.length()){
					System.out.println("\nYou WIN!\nDo you wnat to play again? Y or N -->");
					boolean again = (k.next() == "Y");
					if(again){
						runGame();
					}
					break;
				}
			} else{
				System.out.println("\nYou failed!\nDo you wnat to play again? Y or N -->");
				boolean again = (k.next() == "Y");
				if(again){
					runGame();
				}
				break;
			}

		}

	}

	static String buildWord(){
		String s = "";
		for(int i = 0; i < guessedWord.length; i++){
			if(!guessedWord[i]){
				s+= "*";
			} else{
				s+=word.substring(i, i+1);
			}
		}
		return s;
	}

	static boolean checkWord(char c){
		boolean inWord = false;
		for(int i = 0; i < word.length(); i++){
			if(word.charAt(i) == c){
				guessedWord[i] = true;
				inWord = true;
			}
		}
		correct = 0;
		for(boolean b : guessedWord){
			correct += (b) ? 1 : 0;
		}
		return inWord;
	}

}




/*import java.util.*;

public class Hangman{

	static String word;
	static Scanner k = new Scanner(System.in);
	static boolean[] guessedWord;
	static char[] wordChars;

	static int lives = 6;
	static int correct = 0;

	public static void main(String[] args){
		runGame();
	}

	static void runGame(){
		lives = 6;
		correct = 0;
		getWord();
		guessedWord = new boolean[word.length()];
		wordChars = word.toCharArray();
		playGame();
	}

	static void getWord(){
		System.out.println("Enter Word --> ");
		word = k.nextLine();
		for(int i = 0; i < 200; i++){
			System.out.println();
		}
	}

	static void playGame(){
		System.out.println(buildWord());
		while(true){
			System.out.println("Enter Letter --> ");
			char c = k.next().charAt(0);
			boolean inWord = checkWord(c);
			if(!inWord){
				lives--;
				System.out.println("Not in Word. Try Again!");
			}
			else {
				System.out.println("The letter " + c + " is in this word");
			}
			if(lives > 0){
				System.out.println(buildWord());
				System.out.println();
				if(correct == word.length()){
					System.out.println("\nYou WIN!\nDo you wnat to play again? Y or N -->");
					boolean again = (k.next() == "Y");
					if(again){
						runGame();
					}
					break;
				}
			} else{
				System.out.println("\nYou failed!\nDo you wnat to play again? Y or N -->");
				boolean again = (k.next() == "Y");
				if(again){
					runGame();
				}
				break;
			}

		}

	}

	static String buildWord(){
		String s = "";
		for(int i = 0; i < guessedWord.length; i++){
			if(!guessedWord[i]){
				s+= "_ ";
			} else{
				s+=word.substring(i, i+1) + " ";
			}
		}
		return s;
	}

	static boolean checkWord(char c){
		boolean inWord = false;
		for(int i = 0; i < word.length(); i++){
			if(word.charAt(i) == c){
				guessedWord[i] = true;
				inWord = true;
			}
		}
		correct = 0;
		for(boolean b : guessedWord){
			correct += (b) ? 1 : 0;
		}
		return inWord;
	}

}*/