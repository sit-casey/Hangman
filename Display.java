
//Imports the necessary Swing components for the program
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Display extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//Arrays to hold the options for Hangman
	private String[] mode = {"Easy", "Normal", "Hard"};
	private String[] cate = {"Animal", "Geography", "Video Games"};
	
	//Declare objects to get a word for the respective categories
	private GenerateEasyWord easy;
	private GenerateMedWord med;
	private GenerateHardWord hard;
	
	private String word; //Holds the word generated
	private int tries;   //Number of tries someone has left
	private String lettersGuessed;  //String to hold the letters player has guessed
	private int correctGuess = 1;  //Retains the number of guesses it took for player to figure out word
	
	//Swing UI elements to display the game
	private JPanel obj = new JPanel();
	private JTextField guess = new JTextField(1);
	private JButton hint = new JButton("Hint");
	private String showWord;
	private JLabel textWord;
	private JLabel showTries = new JLabel();
	private JLabel showLetters = new JLabel();

	/**
	 * Method to welcome players and explain how to play
	 */
	public void welcome(){
		JOptionPane.showMessageDialog(null, "Welcome to Hangman!" +
											"\n Simply pick a difficulty and category to get started!");
		JOptionPane.showMessageDialog(null, "To guess, enter your letter into the box. You have" + 
											" varying numbers of tries based on your difficulty. " +
											" Hints may not be available either. " +
											"\n If your guess is correct, it will show up and you will" +
											" not lose a try. If not, you will lose a try.");
	}
	
	/**
	 * Sets up the Swing GUI and begins running the program
	 */
	public Display(){
		//Initializes the objects for difficulties to use later
		easy = new GenerateEasyWord();
		med = new GenerateMedWord();
		hard = new GenerateHardWord();

		welcome(); //Calls welcome method
		SetDifficulty(); //Calls method to set the difficulty, also getting the word
		showWord = word.replaceAll(".", "*"); //Covers the chosen word with *s and displays
		//System.out.println(showWord);
		textWord = new JLabel (showWord);  //Creates a Label depicting the progression in guessing the word
		textWord.setLocation(10,10);       //Sets location of label
		
		//Setting up the JPanel and adding the created GUI elements to it
		obj.setLayout(new BoxLayout(obj, BoxLayout.Y_AXIS)); 
		obj.add(guess);
		obj.add(hint);
		obj.add(textWord);
		obj.add(showLetters);
		obj.add(showTries);

		add(obj);  //Adds the JPanel to the JFrame
		Guess();   //Calls the Guess method
		Hint();    //Calls the hint method
		}
	
	/**
	 * Gets number of tries remaining
	 * @return number of tries remaining
	 */
	public int getTries(){return tries;}

	/**
	 * Gets the letters the user already guessed
	 * @return letters already guessed
	 */
	public String getLetters(){return lettersGuessed;}
	
	/**
	 * Sets up the game of hangman, with the category and word
	 * @return Word used for 1 session of Hangman
	 */
	public String SetDifficulty(){
		word = "";  //Stores the word for the game
		
		//Asks user for difficulty and category, then stores it
		int choice = JOptionPane.showOptionDialog(null, "Please select your difficulty", "Difficulty", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, mode, mode[0]);
		int category = JOptionPane.showOptionDialog(null, "Choose a(n) Animal\\Geography\\Video games category!", "Category", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, cate, cate[0]);
		
		if(choice==0){ //Checks if the difficulty is easy, then checks which category the user picked
			if(category==0){
				//Displays what the user picked, and uses the previously created objects to get a word.
				JOptionPane.showMessageDialog(null, "You have chosen Easy Mode on the Animal Category!");
				word = easy.getAnimal();
			}
			else if(category==1){
				JOptionPane.showMessageDialog(null, "You have chosen Easy Mode on the Geography Category!");
				word=easy.getGeography();
			}
			else if(category==2){
				JOptionPane.showMessageDialog(null, "You have chosen Easy Mode on the Video Games Category!");
				word = easy.getVGC();
			}
			tries = 6; //Sets number of tries, varies by difficulties
			lettersGuessed = " "; //Sets value to letters guessed

			//Sets text to display these elements
			showTries.setText("Number of Tries Left: " + Integer.toString(tries));
			showLetters.setText("Letters guessed " + lettersGuessed);
		}
		else if(choice==1){
			if(category==0){
				JOptionPane.showMessageDialog(null, "You have chosen Normal Mode on the Animal Category!");
				word = med.getAnimal();
			}
			else if(category==1){
				JOptionPane.showMessageDialog(null, "You have chosen Normal Mode on the Geography Category!");
				word = med.getGeography();
			}
			else if(category==2){
				JOptionPane.showMessageDialog(null, "You have chosen Normal Mode on the Video Games Category!");
				word = med.getVG();
			}
			tries = 4;
			lettersGuessed = " ";
			showTries.setText("Number of Tries Left: " + Integer.toString(tries));
			showLetters.setText("Letters guessed " + lettersGuessed);
		}
		else if(choice==2){
			if(category==0){
				JOptionPane.showMessageDialog(null, "You have chosen Hard Mode on the Animal Category!");
				word = hard.getAnimal();
			}
			else if(category==1){
				JOptionPane.showMessageDialog(null, "You have chosen Hard Mode on the Geography Category!");
				word = hard.getGeography();
			}
			else if(category==2){
				JOptionPane.showMessageDialog(null, "You have chosen Hard Mode on the Video Games category!");
				word = hard.getVG();
			}
			tries = 3;
			lettersGuessed = " ";
			showTries.setText("Number of tries left: " + Integer.toString(tries));
			showLetters.setText("Letters guessed " + lettersGuessed);
		}
		//System.out.println(word);
		return word; //Returns word
	}
	
	/**
	 * Adds functionality to the Hint JButton
	 */
	public void Hint(){
		hint.addActionListener(new ActionListener(){	//Adds action listener
			public void actionPerformed(ActionEvent e) {	//Checks what the word is, and offers equivalent hint
				if(word.equalsIgnoreCase("cat")){
					JOptionPane.showMessageDialog(null, "Makes a meowing noise");
				}
				else if(word.equalsIgnoreCase("Dog")){
					JOptionPane.showMessageDialog(null, "Man's best friend");
				}
				else if(word.equalsIgnoreCase("Tiger")){
					JOptionPane.showMessageDialog(null, "Striped cat part of Lunar Zodiacs");
				}
				else if(word.equalsIgnoreCase("Wolf")){
					JOptionPane.showMessageDialog(null, "Related to dogs and travels in packs");
				}
				else if(word.equalsIgnoreCase("Rabbit")){
					JOptionPane.showMessageDialog(null, "Small mammals that die from loneliness");
				}
				else if(word.equalsIgnoreCase("Lion")){
					JOptionPane.showMessageDialog(null, "King of the Jungle");
				}
				else if(word.equalsIgnoreCase("Kiwi")){
					JOptionPane.showMessageDialog(null, "Also a food, bird native to New Zealand");
				}
				else if(word.equalsIgnoreCase("Ant")){
					JOptionPane.showMessageDialog(null, "Insect that lives in colonies");
				}
				else if(word.equalsIgnoreCase("Hose")){
					JOptionPane.showMessageDialog(null, "Domesticated and often ridden on");
				}
				else if(word.equalsIgnoreCase("Deer")){
					JOptionPane.showMessageDialog(null, "Species Bambi is");
				}
				else if(word.equalsIgnoreCase("dolphin")){
					JOptionPane.showMessageDialog(null, "Aquatic mammal, well liked.");
				}
				else if(word.equalsIgnoreCase("Penguin")){
					JOptionPane.showMessageDialog(null, "Bird which cannot fly, but swims. Lives in the cold");
				}
				else if(word.equalsIgnoreCase("Beaver")){
					JOptionPane.showMessageDialog(null, "Furry semiaquatic animal America nearly hunted to extinction before");
				}
				else if(word.equalsIgnoreCase("Monkey")){
					JOptionPane.showMessageDialog(null, "Our most closely related animal");
				}
				else if(word.equalsIgnoreCase("octopus")){
					JOptionPane.showMessageDialog(null, "8 is the magic number, aquatic");
				}
				else if(word.equalsIgnoreCase("Polar Bear")){
					JOptionPane.showMessageDialog(null, "White bear which hunts seals to survive");
				}
				else if(word.equalsIgnoreCase("Dingo")){
					JOptionPane.showMessageDialog(null, "Brutal dogs");
				}
				else if(word.equalsIgnoreCase("pigeon")){
					JOptionPane.showMessageDialog(null, "Common urban bird");
				}
				else if(word.equalsIgnoreCase("panda")){
					JOptionPane.showMessageDialog(null, "Black and white bear that gets scared easily");
				}
				else if(word.equalsIgnoreCase("Eagle")){
					JOptionPane.showMessageDialog(null, "Symbol of America");
				}
				else if(word.equalsIgnoreCase("Europe")){
					JOptionPane.showMessageDialog(null, "Continent containing France and Germany among others");
				}
				else if(word.equalsIgnoreCase("Russia")){
					JOptionPane.showMessageDialog(null, "Vast country in Asia continent");
				}
				else if(word.equalsIgnoreCase("Boston")){
					JOptionPane.showMessageDialog(null, "American city where the Spirit of Revolution once resided");
				}
				else if(word.equalsIgnoreCase("America")){
					JOptionPane.showMessageDialog(null, "Stars and Stripes");
				}
				else if(word.equalsIgnoreCase("France")){ 
					JOptionPane.showMessageDialog(null, "Famous capital of a country in Europe.");
				}
				else if(word.equalsIgnoreCase("China")){
					JOptionPane.showMessageDialog(null, "One of the most populous countries on Earth");
				}
				else if(word.equalsIgnoreCase("London")){
					JOptionPane.showMessageDialog(null, "Capital of England");
				}
				else if(word.equalsIgnoreCase("Africa")){
					JOptionPane.showMessageDialog(null, "Continent heavily crippled by imperialism");
				}
				else if(word.equalsIgnoreCase("Asia")){
					JOptionPane.showMessageDialog(null, "Continent containing the majority of total population");
				}
				else if(word.equalsIgnoreCase("Peru")){
					JOptionPane.showMessageDialog(null, "Country in South America");
				}
				else if(word.equalsIgnoreCase("Beijing")){
					JOptionPane.showMessageDialog(null, "Major city in Asia continent");
				}
				else if(word.equalsIgnoreCase("Guam")){
					JOptionPane.showMessageDialog(null, "Island part of US territory");
				}
				else if(word.equalsIgnoreCase("Atlantic Ocean")){
					JOptionPane.showMessageDialog(null, "Touches the Americas, Europe, and Africa");
				}
				else if(word.equalsIgnoreCase("Hungary")){
					JOptionPane.showMessageDialog(null, "Landlocked country whose capital is Budapest");
				}
				else if(word.equalsIgnoreCase("Austria")){
					JOptionPane.showMessageDialog(null, "Capital is Vienna");
				}
				else if(word.equalsIgnoreCase("Kenya")){
					JOptionPane.showMessageDialog(null, "Located in East Africa, capital is Nairobi");
				}
				else if(word.equalsIgnoreCase("Ukraine")){
					JOptionPane.showMessageDialog(null, "Faced a political crisis with Russia concerning Crimea");
				}
				else if(word.equalsIgnoreCase("Belgium")){
					JOptionPane.showMessageDialog(null, "Between Germany and France");
				}
				else if(word.equalsIgnoreCase("Chernobyl")){
					JOptionPane.showMessageDialog(null, "Site of a famous nuclear failure during the Cold War");
				}
				else if(word.equalsIgnoreCase("Aral Sea")){
					JOptionPane.showMessageDialog(null, "Sea in the Middle East which largely dried up in 2010s.");
				}
				else if(word.equalsIgnoreCase("Warrior")){
					JOptionPane.showMessageDialog(null, "Video game class associated with strength");
				}
				else if(word.equalsIgnoreCase("Archer")){
					JOptionPane.showMessageDialog(null, "Class which commonly uses a bow");
				}
				else if(word.equalsIgnoreCase("Bard")){
					JOptionPane.showMessageDialog(null, "Class using music to aid and fight");
				}
				else if(word.equalsIgnoreCase("Druid")){
					JOptionPane.showMessageDialog(null, "Class most closely associated with nature and magic");
				}
				else if(word.equalsIgnoreCase("Paladin")){
					JOptionPane.showMessageDialog(null, "Defensive class often associated with religion");
				}
				else if(word.equalsIgnoreCase("Mage")){
					JOptionPane.showMessageDialog(null, "Most common magic centered class");
				}
				else if(word.equalsIgnoreCase("Rogue")){
					JOptionPane.showMessageDialog(null, "Not as common class associated with stealth");
				}
				else if(word.equalsIgnoreCase("Priest")){
					JOptionPane.showMessageDialog(null, "Healer");
				}
				else if(word.equalsIgnoreCase("Knight")){
					JOptionPane.showMessageDialog(null, "A Warrior, but with a horse");
				}
				else if(word.equalsIgnoreCase("Duelist")){
					JOptionPane.showMessageDialog(null, "One on one fighter, more speedy and usually some sword");
				}
				else if(word.equalsIgnoreCase("Fire Emblem")){
					JOptionPane.showMessageDialog(null, "Nintendo franchise which experienced a revival in 2013");
				}
				else if(word.equalsIgnoreCase("Dark Souls")){
					JOptionPane.showMessageDialog(null, "Infamous game for its high difficulty");
				}
				else if(word.equalsIgnoreCase("Ace Attorney")){
					JOptionPane.showMessageDialog(null, "Visual novel centered on the legal system");
				}
				else if(word.equalsIgnoreCase("Cuphead")){
					JOptionPane.showMessageDialog(null, "Indie game featuring cups receiving widespread attention");
				}
				else if(word.equalsIgnoreCase("Bayonetta")){
					JOptionPane.showMessageDialog(null, "A Beat 'em up created by the same people behind Devil May Cry");
				}
				else if(word.equalsIgnoreCase("Starcraft")){
					JOptionPane.showMessageDialog(null, "'You must construct additional pylons'");
				}
				else if(word.equalsIgnoreCase("Nintendogs")){
					JOptionPane.showMessageDialog(null, "Take care of virtual dogs");
				}
				else if(word.equalsIgnoreCase("Stardew Valley")){
					JOptionPane.showMessageDialog(null, "Indie centered around living on a farm faraway from cities");
				}
				else if(word.equalsIgnoreCase("Chrono Trigger")){
					JOptionPane.showMessageDialog(null, "Classic JRPG well remembered today where the protagonist dies.");
				}
				else if(word.equalsIgnoreCase("Civilization")){
					JOptionPane.showMessageDialog(null, "Create empires, wage war, dominate culturally, scientifically, or economically");
				}
			}
		});
	}
	
	/**
	 * Method taking the user's guesses and updating the game as it goes
	 */
	public void Guess(){
		//Sets the JTextField's alignment
		guess.setAlignmentY(CENTER_ALIGNMENT);
		guess.setAlignmentX(CENTER_ALIGNMENT);
		//Adds an action listener to the JTextField
		guess.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						String checkguess = guess.getText(); //Stores the inputted value inside a String
						//Stores the guess into a char array, in uppercase
						char[] checkguesschar = checkguess.toUpperCase().toCharArray();
						if(word.contains(checkguess.toUpperCase())){	//Checks if the guess is correct
						
							//Goes through the word to find which letter was correct, then
							//reveals the letter on the associated JLabel
							for(int i = 0; i<word.length();i++){
									if(word.charAt(i)== checkguesschar[0]){
										 char[] charArray = showWord.toCharArray();
										 charArray[i] = checkguess.charAt(0);
										 showWord = new String(charArray);
										 //System.out.println(showWord);
										 textWord.setText(showWord);
									}
							}
							//Checks if the user correctly guessed the entire word in one go, or
							//if they've unveiled the entire word. Shows winning message and exits the program
							if(word.equalsIgnoreCase(checkguess) || word.equalsIgnoreCase(showWord)){
                                textWord.setText(word);
								JOptionPane.showMessageDialog(null, "Congratulations! You correctly guessed " + word + " in  " + correctGuess + " tries!");
								JOptionPane.showMessageDialog(null, "Try again on a harder difficulty or another category!");
								System.exit(0);
                            }
                            guess.setText(""); //Resets the JTextfield after every guess
						}
						else{	//If the guess was incorrect
							tries--;	//Deducts # of guesses
							lettersGuessed += checkguess + " ";	//Adds letter to lettersGuessed to show user
							
							//Updates the number of tries left and letters guessed
							showTries.setText("Number of tries left: " + Integer.toString(tries));
							showLetters.setText("Letters guessed: " + lettersGuessed);
							correctGuess++; //Increments guesses user has taken
							guess.setText(" "); //Resets JTextField
							if(tries==0){	//Checks if user has lost the game
								//If so, tells them the word and exits the game.
								JOptionPane.showMessageDialog(null, "You have ran out of tries! The word was " + word);
								System.exit(0);
							}
						}
						
					}
			
		});
		
	}
	

	
}
