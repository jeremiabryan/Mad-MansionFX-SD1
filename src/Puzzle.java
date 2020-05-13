import java.io.*;
import java.util.ArrayList;

public class Puzzle {

 public final String puzzleName = "";
 public int puzzleID = 0;
 public String puzzleAnswer = "";
 public final String puzzleLocation = "";
 public int floorNumber;
 public String puzzleDescription = "";
 public final String puzzleReward = "";
 public ArrayList<String> hints;
 public int roomNumber;
 public boolean isSolved;
 private int attempts;
	
	
// Make sure this is right
 	
 	Puzzle (){
 		hints = new ArrayList<String>();
 		isSolved = false;
 	}
 	
 	public void setAnswer(String s) {
 		this.puzzleAnswer = s;
 	}
 	
 	public void setID(int id) {
 		this.puzzleID = id;
 	}
 	
 	public void setQuestion(String s) {
 		this.puzzleDescription = s;
 	}
 	
 	public void addHint(String s) {
 		hints.add(s);
 	}
 	
 	public void setFloor(int floorNumber) {
 		this.floorNumber = floorNumber;
 	}
 	
 	public void setDescription(String s) {
 		this.puzzleDescription = s;
 	}
 	

 	public String getDescription() {
 		return this.puzzleDescription;
 	}
 	
 	public int getFloor() {
 		return floorNumber;
 	}
 	
 	public int getRoom() {
 		return roomNumber;
 	}
 	
 	public void setRoomNumber(int roomNumber) {
 		this.roomNumber = roomNumber;
 	}
 	
 	public boolean isSolved() {
 		return isSolved;
 	}
 	
 	public String getAnswer() {
 		return puzzleAnswer;
 	}
 	
 	public void setAttempts(int i) {
 		this.attempts = i;
 	}
 	
 	public int getAttempts() {
 		return attempts;
 	}
 	
 	public void solve() {
 		
 		isSolved = true;
 	}
 	
 	public ArrayList<String> getHints() {
 		return hints;
 	}

	
}
