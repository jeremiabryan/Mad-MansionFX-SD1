import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemLoader {

	private static File itemFile;
	private static Scanner fileScanner;
	private static String ITEM_FILE_NAME = "items.txt";
	private static ArrayList<Item> itemList;
	private static Item returnItem;




	public static void init() {
		itemList = new ArrayList<Item>();
		File itemFile = new File(ITEM_FILE_NAME);
		try {
			fileScanner = new Scanner(itemFile);
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
			System.out.println("Item details: ");
			
			for (int i = 0; i < splitLine.length; i++) {
				System.out.println("- " + splitLine[i]);
			}

			Item i = new Item(Integer.valueOf(splitLine[0]), splitLine[1], 
					splitLine[2], splitLine[3],
					Integer.valueOf(splitLine[4]), Integer.valueOf(splitLine[5]), 
					Integer.valueOf(splitLine[6]), Integer.valueOf(splitLine[7]));
			itemList.add(i);
			
			
		}
		
		
		
	}
	
	public static ArrayList<Item> getItems() {
		return itemList;
	}
}