//Imports Random to help randomize the word generated.
import java.util.Random;

/**
 * Class to generate a word if Hard is the chosen difficulty
 */
public class GenerateHardWord {
	
	//Randomizer to be used to randomize a word generation
	private Random randomizer = new Random();

	//String arrays to hold possible words based on their category
	private String[] hmanimal = {"ECHIDNA", "CAPYBARA", "ALBATROSS", "NARWHAL", "PLATYPUS", "KINGFISHER", "WALRUS", "ALLIGATOR", "BARNACLE", "MAYFLY"};
	private String[] hmgeography = {"PATAGONIA", "PHILIPPINES", "PERSIAN GULF", "SLOVAKIA", "LITHUANIA", "LIECHTENSTEIN", "GIBSON STEPS", "SKAFTAFELL", "CASPIAN SEA", "ANTARCTICA"};
	private String[] hmvg = {"TOUHOU", "XENOBLADE", "OOKAMI", "ARMS", "EON ALTAR", "MABINOGI", "TROVE", "KID ICARUS", "MIGHTY NO. 9", "AXIOM VERGE"};

	//Gets a random word from the animal word bank
	public String getAnimal(){
		return hmanimal[randomizer.nextInt(10)];
	}
	
	//Gets a random word from the geography word bank
	public String getGeography(){
		return hmgeography[randomizer.nextInt(10)];
	}

	//Gets a random word from the video game word bank
	public String getVG(){
		return hmvg[randomizer.nextInt(10)];
	}
}
