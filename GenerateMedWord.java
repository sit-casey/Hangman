//Imports Random to help randomize the word generated.
import java.util.Random;

/**
 * Generates a word if the medium difficulty is chosen
 */
public class GenerateMedWord {
	
	//Randomizer
	private Random randomizer = new Random();

	//String arrays holding the word bank for medium difficulty
	private String[] mmanimal = {"DOLPHIN", "POLAR BEAR", "PENGUIN", "DINGO", "BEAVER", "PIGEON", "MONKEY", "PANDA", "OCTOPUS", "EAGLE"};
	private String[] mmgeography = {"BEIJING", "KENYA", "GUAM", "UKRAINE", "ATLANIC OCEAN", "BELGIUM", "HUNGARY", "CHERNOBYL", "AUSTRIA", "ARAL SEA"};
	private String[] mmvg = {"FIRE EMBLEM", "STARCRAFT", "DARK SOULS", "NINTENDOGS", "PHOENIX WRIGHT: ACE ATTORNEY", "STARDEW VALLEY","CUPHEAD", "CHRONO TRIGGER", "BAYONETTA", "CIVILIZATION"};

	//Gets a random word from the animal word bank
	public String getAnimal(){
		return mmanimal[randomizer.nextInt(10)];
	}
	
	//Gets a random word from the geography word bank
	public String getGeography(){
		return mmgeography[randomizer.nextInt(10)];
	}
		
	//Gets a random word from the videogame word bank
	public String getVG(){
		return mmvg[randomizer.nextInt(10)];
	}
}
