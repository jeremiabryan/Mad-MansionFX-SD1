import java.util.ArrayList;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
/*
 * This class is meant to be the Controller aspect of the MVC structure.
 * This handler takes the command from the View and manipulates the Model.
 * 
 */
public class CommandHandler implements EventHandler<KeyEvent> {
	private static Stack<String> commandStack = new Stack<String>();
	private static boolean gameHasPlayer;
	private static boolean roomHasMonster;
	private static boolean roomHasPuzzle;
	

	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void handle(KeyEvent event) {
		switch (event.getCode().toString()) {
		case "ENTER": {
				commandStack.add(MadMansionFX.getCommand().trim());
				MadMansionFX.relay();
			}
		}
		
	}
	
	public static String peekCommand() {
		return commandStack.peek();
	}
	

}
