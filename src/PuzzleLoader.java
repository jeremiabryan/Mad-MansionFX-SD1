import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PuzzleLoader {
	
	/* this is the ArrayList of Puzzles we will return to MadMansionFX.java */
	private static ArrayList<Puzzle> puzzleList;
	
	/* the file name */
	private static String PUZZLE_FILE_NAME = "puzzles.txt";
	
	/* the virtual file */
	private static File puzzleFile;
	
	/* the scanner */
	private static Scanner fileScanner;
	
	
	
	
	
	/* just initializing the scanner and opening the file */
	public static void init() {
		puzzleFile = null;
		puzzleList = new ArrayList<Puzzle>();
		File puzzleFile = new File(PUZZLE_FILE_NAME);
		try {
			fileScanner = new Scanner(puzzleFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* where the magic happens: */
	public static void run() {
		
		/* while there's a next puzzle line: */
		while (fileScanner.hasNext()) {
			
			// get the next line of file 
			String nextLine = fileScanner.nextLine();
			
			// separate out every phrase by semicolons;
			String[] splitLine = nextLine.split(";");
			
			// this is an ArrayList that holds the Puzzle's data
			ArrayList<String> temp = new ArrayList<String>();
			
			// add said data
			for (String s : splitLine) {
				temp.add(s);
			}
			
			
			/*
			 * The ArrayList of our Puzzle now looks like this:
			 * 
			 * puzzleData = [PuzzleID], [FloorNumber], [Description], ...[Any hints given]..., [PuzzleAnswer];
			 * 
			 * We don't know how many hints the Puzzle has, if it even has any, we have to work from both ends to get to them.
			 */
			
			
			// creating a new Puzzle object
			Puzzle p = new Puzzle();
			
			// set the Puzzle's int puzzleID
			p.setID(Integer.valueOf(temp.get(0)));
			
			// and remove it from the ArrayList of data
			temp.remove(0);
			
			
			/* 
			 * Now our ArrayList of data to assign to the object looks like this:
			 * 
			 * puzzleData = [FloorNumber], [Description], ...[Any hints given]..., [PuzzleAnswer];
			 * 
			 */
			
			
			// set the Puzzle's int FloorLevel
			p.setFloor(Integer.valueOf(temp.get(0)));
			
			// and remove it from the ArrayList of data
			temp.remove(0);
			
			// puzzleData = [Description], ...[Any hints given]..., [PuzzleAnswer];
			
			// set the Puzzle's String description
			p.setDescription(temp.get(0));
			
			// and remove it from the ArrayList of data
			temp.remove(0);
			
			
			
			/* 
			 * Now our ArrayList of data to assign to the object looks like this:
			 * 
			 * ...[Any hints given]..., [PuzzleAnswer];
			 * 
			 * But puzzle answer will always be last, so let's remove that.
			 */
			
			// set Puzzle's String answer to the last one in the ArrayList
			p.setAnswer(temp.get(temp.size() - 1).toLowerCase());
			
			// remove the data from the data ArrayList
			temp.remove(temp.size() - 1);
			
			
			
			/*
			 * Now our ArrayList of data to assign to the object looks like this:
			 * 
			 * ...[Any hints given]...;
			 * 
			 * So any String left in the ArrayList is a hint.
			 */
			
			// add any String left in the ArrayList to the Puzzle's hints (also an ArrayList);
			for (String s : temp) {
				p.addHint(s);
			}
			
			
			
			
			/*
			 * ASSIGNING THE PUZZLE ROOM:
			 * 
			 * There are 3 floors.
			 * Each puzzle was assigned to a certain floor in the data file.
			 * Each floor has one 'boss room' which cannot have a puzzle.
			 * It is the 10th room on each floor. So:
			 * - Floor 1: Room 10 cannot have a puzzle
			 * - Floor 2: Room 20 cannot have a puzzle
			 * - Floor 3: Room 30 cannot have a puzzle
			 * 
			 * Otherwise, the other 9 rooms have an equal chance to get the puzzle randomly.
			 */
			
			// random:
			Random r = new Random();
			
			/*
			 * Assigning the room number:
			 * 
			 * Example, let's say that p.getFloor() gives you Floor 2.
			 * 
			 * (p.getFloor() * 10) = 20;
			 * (r.nextInt(9) + 1) = random(1-9);
			 * 
			 * BEST CASE: 20 + 9 = 29;
			 * WORST CASE: 20 + 1 = 21;
			 * 
			 * Which is actually Floor 3, because Floor 1 is 1-9, Floor 2 is 11-19, Floor 3 is 21-29, excluding boss rooms.
			 * 
			 * So subtract to give you the Room range for the assigned floor in the text file.
			 * 
			 * 
			 */
			
			p.setRoomNumber(((p.getFloor() * 10) + (r.nextInt(9) + 2)) - 10);
			
			// the document states that puzzles on floor 1 get 5 attempts, floor 2 gets 4, and floor 3 gets 3.
			if (p.getFloor() == 1) {
				p.setAttempts(5);
			}
			else if (p.getFloor() == 2) {
				p.setAttempts(4);
			}
			else if (p.getFloor() == 3) {
				p.setAttempts(3);
			}
			else {
				;
			}
			
			// add it to our Puzzle ArrayList that we send to the game, and all Puzzles are ready for use.
			puzzleList.add(p);
			
		}
		
		
	}
	
	// method to get the Puzzle ArrayList.
	public static ArrayList<Puzzle> getPuzzles() {
		return puzzleList;
	}
	
	

}
