import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Room {
	private int roomID;
	private int floorNumber;
	private String roomDescription = "";
	private Puzzle puzzle;
	private Monster monster;
	private boolean hasMonster;
	private ArrayList<Item> items;
	
	
	
	// roomConnections order based on Never Eat Soggy Waffles; [N, E, S, W];
	private int[] roomConnections = new int[4];
	private boolean isSafePoint;
	private Set<Encounter> eventPool;
	private String toString = "";
	private boolean hasPuzzle;
	
	Room(String[] roomData) {
		
		this.roomID = Integer.valueOf(roomData[0]);

		this.floorNumber = Integer.valueOf(roomData[1]);

		this.isSafePoint = Boolean.valueOf(roomData[2]);

		this.roomDescription = roomData[3];

		/* North */
		this.roomConnections[0] = Integer.valueOf(roomData[4]);
		
		/* East */
		this.roomConnections[1] = Integer.valueOf(roomData[5]);

		/* South */
		this.roomConnections[2] = Integer.valueOf(roomData[6]);

		/* West */
		this.roomConnections[3] = Integer.valueOf(roomData[7]);
		
		items = new ArrayList<Item>();
	}
	
	public String toString() {
		return "ID: " + roomID + "; " 
				+ "Floor: " + floorNumber + "; " 
				+ "Description: " + roomDescription + "; "
				+ "North: " + roomConnections[0] + "; "
				+ "East: " + roomConnections[1] + "; "
				+ "South: " + roomConnections[2]+  "; "
				+ "West: " + roomConnections[3] + ";";
	}
	

	public int getNorth() {
		return roomConnections[0];
	}
	
	public int getSouth() {
		return roomConnections[2];
	}
	
	public int getEast() {
		return roomConnections[1];
	}
	
	public int getWest() {
		return roomConnections[3];
	}
	
	public int getNumber() {
		return this.roomID;
	}
	
	public String getDescription() {
		return roomDescription;
	}
	
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
	public boolean hasPuzzle() {
		return hasPuzzle;
	}
	
	public boolean hasMonster() {
		return hasMonster;
	}
	
	public void setPuzzle(Puzzle p) {
		hasPuzzle = true;
		this.puzzle = p;
	}
	
	public void removePuzzle(Puzzle p) {
		hasPuzzle = false;
		p = null;
	}
	public void removeMonster(Monster m) {
		hasMonster = false;
		monster = null;
	}
	
	public void setMonster(Monster m) {
		hasMonster = true;
		this.monster = m;
	}
	
	public Monster getMonster() {
		return monster;
	}
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void removeItem(Item i) {
		items.remove(i);
	}
	
	

	
	
	
	
	
	
	
	
	

}
