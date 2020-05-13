import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MonsterLoader {
	
	/* this is the ArrayList of Monsters we will return to MadMansionFX.java */
	private static ArrayList<Monster> monsterList;
	
	/* the file name */
	private static String MONSTER_FILE_NAME = "monsters.txt";
	
	/* the virtual file */
	private static File monsterFile;
	
	/* the scanner */
	private static Scanner fileScanner;
	
	
	
	
	
	public static void init() {
		monsterFile = null;
		monsterList = new ArrayList<Monster>();
		File monsterFile = new File(MONSTER_FILE_NAME);
		try {
			fileScanner = new Scanner(monsterFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void run() {
		
		while (fileScanner.hasNext()) {
			
			String nextLine = fileScanner.nextLine();
			
			if (nextLine.startsWith("//")) {
				;
			}
			else {
				
				String[] splitLine = nextLine.split(";");
				
				ArrayList<String> tempData = new ArrayList<String>();
				
				for (String s : splitLine) {
					tempData.add(s);
				}
				
				
		
				int[] tempMonsterHP = new int[2];
				int[] tempMonsterAD = new int[2];
				int[] tempMonsterArmor = new int[2];
				tempMonsterHP[0] = Integer.valueOf(splitLine[4]);
				tempMonsterHP[1] = Integer.valueOf(splitLine[5]);
				tempMonsterAD[0] = Integer.valueOf(splitLine[6]);
				tempMonsterAD[1] = Integer.valueOf(splitLine[7]);
				tempMonsterArmor[0] = Integer.valueOf(splitLine[8]);
				tempMonsterArmor[1] = Integer.valueOf(splitLine[9]);
				
				Monster monster = new Monster(Integer.valueOf(splitLine[0]), // monster ID
						splitLine[1], // monster name
						Integer.valueOf(splitLine[2]), // health points given to the player
						Integer.valueOf(splitLine[3]), // attack points given to the player
						tempMonsterHP, // monster HP range
						tempMonsterAD, // monster AD range
						tempMonsterArmor,
						Integer.valueOf(splitLine[10]),
						Integer.valueOf(splitLine[11])); // monster Armor range
				
				if (monster.getRoom() == 10 ||
						monster.getRoom() == 20 ||
						monster.getRoom() == 30) {
					;
				}
				else {
					Random r = new Random();
					int weight = r.nextInt(8) + 2;
					int floorNumber = monster.getRoom() * 10 - 10 + weight;
					monster.setRoom(floorNumber);
				}
				
				if (splitLine.length > 12) {
					for (int i = 12; i <= splitLine.length - 1; i++) {
						System.out.println(splitLine[i]);
						monster.addItemID(Integer.valueOf(splitLine[i]));
					}
				}
				monsterList.add(monster);
			}
			
		}
		
	}
	
	public static ArrayList<Monster> getMonsters() {
		return monsterList;	
		}
	
	

}
