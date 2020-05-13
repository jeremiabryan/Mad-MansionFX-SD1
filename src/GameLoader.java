import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLoader {
	private static File roomFile;
	private static Scanner fileScanner;
	private static String ROOM_FILE_NAME = "rooms.txt";
	private static ArrayList<Room> roomList;
	
	
	
	public static void init() {
		roomList = new ArrayList<Room>();
		File roomFile = new File(ROOM_FILE_NAME);
		try {
			fileScanner = new Scanner(roomFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void run() {
		
		while (fileScanner.hasNext()) {
			
			// next line of file
			String nextLine = fileScanner.nextLine();
			
			// set up string array for each room's csv line
			String[] splitLine = nextLine.split(";", 8);
		
			Room r = new Room(splitLine);
			System.out.println(r);
			roomList.add(r);
			System.out.println("---");
			
			
		}
		System.out.println(roomList.size());
		for (Room r : roomList) {
			System.out.println(r.toString());
		}
		
	}
	
	public static Room[] getRooms() {
		Room[] roomArray = new Room[roomList.size() + 1];
		for (Room r : roomList) {
			roomArray[r.getNumber()] = r;
		}
		System.out.println(roomArray.length);
		return roomArray;
	}
	
	
}


