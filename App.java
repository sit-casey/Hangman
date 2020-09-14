import javax.swing.*;

public class App {
   public static void main(String[] args) {        
        Display game = new Display(); //Begins the game
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly closes application when prompted
        game.setSize(250, 250); //Sets size of window
        game.setVisible(true);	//Sets the window visible
    }
    
}
