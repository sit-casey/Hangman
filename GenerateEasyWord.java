//Random utility for random generation
import java.util.Random;

/**
 * Generates a word if easy is chosen
 */
public class GenerateEasyWord {
	
	//Randomizer
	private Random randomizer = new Random();

	//String arrays holding the word banks for the chosen categories
	private String[] emanimal = {"CAT","DOG", "TIGER", "WOLF", "RABBIT", "LION", "KIWI", "ANT", "HORSE", "DEER" };
	private String[] emgeography = {"EUROPE", "CHINA", "RUSSIA", "LONDON","BOSTON", "AFRICA", "AMERICA", "ASIA", "FRANCE", "PERU"};
	private String[] emvgclasses = {"WARRIOR", "MAGICIAN", "ARCHER", "ROGUE", "BARD", "PRIEST", "PALADIN", "DRUID", "KNIGHT", "DUELIST"};
	
	//Gets a random word from the animal word bank
	public String getAnimal(){
		return emanimal[randomizer.nextInt(10)];
	}
	
	//Gets a random word from the geography word bank
	public String getGeography(){
		return emgeography[randomizer.nextInt(10)];
	}
	
	//Gets a random word from the video game classes word bank
	public String getVGC(){
		return emvgclasses[randomizer.nextInt(10)];
	}

	
}
