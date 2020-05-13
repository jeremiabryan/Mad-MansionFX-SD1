import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class Monster {
	private int monsterID;
	private String monsterName = "";
	private String monsterDescription = "";
	private int playerHPGain;
	private int playerAPGain;
	private int[] monsterHP = new int[2];
	private int[] monsterAD = new int[2];
	private int[] monsterArmor = new int[2];
	private ArrayList<Item> itemDropPool;
	private int itemID;
	private int floorNumber;
	private boolean isAlive;
	private boolean isTurn;
	private int absoluteHealth;
	private ArrayList<Integer> itemIDList;
	private boolean isAsleep;
	private int originalHP;
	
	
	/**
	 * 
	 */
	public Monster() {
	}

	/**
	 * @param monsterName
	 * @param monsterDescription
	 * @param monsterHP
	 * @param monsterAD
	 * @param monsterArmor
	 * @param itemDropPool
	 */
	public Monster(int monsterID, 
			String monsterName, 
			int playerHPGain, 
			int playerAPGain, 
			int[] monsterHP, 
			int[] monsterAD, 
			int[] monsterArmor,
			int itemID,
			int floorNumber) {
		this.monsterID = monsterID;
		this.monsterName = monsterName;
		this.playerHPGain = playerHPGain;
		this.playerAPGain = playerAPGain;
		this.monsterHP = monsterHP;
		this.monsterAD = monsterAD;
		this.monsterArmor = monsterArmor;
		this.itemID = itemID;
		this.floorNumber = floorNumber;
		isAlive = true;
		isTurn = true;
		isAsleep = false;
		
		
		itemDropPool = new ArrayList<Item>();
		itemIDList = new ArrayList<Integer>();
		itemIDList.add(itemID);
		Random r = new Random();
		absoluteHealth = monsterHP[r.nextInt(2)];
		originalHP = absoluteHealth;
	}


	/**
	 * @return the monsterName
	 */
	public String getMonsterName() {
		return monsterName;
	}


	/**
	 * @param monsterName the monsterName to set
	 */
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}

	
	

	/**
	 * @return the monsterDescription
	 */
	public String getMonsterDescription() {
		return monsterDescription;
	}
	
	public void setAsleep(boolean b) {
		this.isAsleep = b;
		absoluteHealth = originalHP;
	}
	
	public boolean isAsleep() {
		return isAsleep;
	}


	/**
	 * @param monsterDescription the monsterDescription to set
	 */
	public void setMonsterDescription(String monsterDescription) {
		this.monsterDescription = monsterDescription;
	}


	/**
	 * @return the monsterHP
	 */
	public int[] getMonsterHP() {
		return monsterHP;
	}


	/**
	 * @param monsterHP the monsterHP to set
	 */
	public void setMonsterHP(int[] monsterHP) {
		this.monsterHP = monsterHP;
	}


	/**
	 * @return the monsterAD
	 */
	public int[] getMonsterAD() {
		return monsterAD;
	}
	
	public boolean getTurn() {
		return isTurn;
	}


	/**
	 * @param monsterAD the monsterAD to set
	 */
	public void setMonsterAD(int[] monsterAD) {
		this.monsterAD = monsterAD;
	}


	/**
	 * @return the monsterArmor
	 */
	public int[] getMonsterArmor() {
		return monsterArmor;
	}
	
	public boolean isAlive() {
		return isAlive;
	}


	/**
	 * @param monsterArmor the monsterArmor to set
	 */
	public void setMonsterArmor(int[] monsterArmor) {
		this.monsterArmor = monsterArmor;
	}


	/**
	 * @return the itemDropPool
	 */
	public ArrayList<Item>getItemDropPool() {
		return itemDropPool;
	}


	/**
	 * @param itemDropPool the itemDropPool to set
	 */
	public void setItemDropPool(ArrayList<Item> itemDropPool) {
		this.itemDropPool = itemDropPool;
	}
	
	public int getRoom() {
		return floorNumber;
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public void setRoom(int i) {
		this.floorNumber = i;
	}
	
	public int getAttack() {
		isTurn = false;
		Random r = new Random();
		int damage = r.nextInt(monsterAD[1] - monsterAD[0]);
		return monsterAD[0] + damage;
	}
	
	public int getHealth() {
		return absoluteHealth;
	}
	
	public void incurDamage(int i) {

		if(absoluteHealth <= 0) {
			absoluteHealth = 0;
		}
		else
		{
			absoluteHealth-=i;
		}

		isTurn = true;
	}
	
	public void setDead() {
		itemDropPool = null;
		isAlive = false;
	}
	
	public void addItemID(int itemID) {
		itemIDList.add(itemID);
	}
	
	public ArrayList<Integer> getItemIDs() {
		return itemIDList;
	}
	
	public void addItem(Item item) {
		itemDropPool.add(item);
	}
	
	public ArrayList<Item> getItems() {
		return itemDropPool;
	}
	
	
}
