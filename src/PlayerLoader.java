import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerLoader {
	private static File playerFile;
	private static Scanner fileScanner;
	private static String PLAYER_FILE_NAME = "players.txt";
	private static ArrayList<Player> playerList;
	private static Player returnPlayer;
	
	
	public static void init() {
		playerList = new ArrayList<Player>();
		File playerFile = new File(PLAYER_FILE_NAME);
		try {
			fileScanner = new Scanner(playerFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void run() {
		while (fileScanner.hasNext()) {
			
			// next line of file
			String nextLine = fileScanner.nextLine();
			
			// set up string array for each room's csv line
			String[] splitLine = nextLine.split(";", 3);
		
			Player p = new Player(splitLine);
			playerList.add(p);
			System.out.println("---");
				
			
			
			
		}
		System.out.println(playerList.size());
		for (Player p : playerList) {
			System.out.println(p.toString());
			returnPlayer = p;
		}
		
		
	}
	
	public static Player getPlayer() {
		return returnPlayer;
	}
	
	
	
}
