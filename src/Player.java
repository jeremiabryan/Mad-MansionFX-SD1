
public class Player {
	private int roomNumber;
	private int score;
	private int maxFloor;
	private String playerID = "";
	private Item[] inventory;
	private int inventoryIndex;
	private int playerHealth;
	private int playerAttack;
	private int playerArmor;
	private Item wieldedWeapon;
	private Item wieldedArmor;
	
	
	public void setRoom(Room room) {
		this.roomNumber = roomNumber;
	}
	
	public int getRoom() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getPlayerID() {
		return playerID;
	}
	
	Player(String[] splitLine) {
		/* processing player text data */
		this.playerID = splitLine[0];
		this.score = Integer.valueOf(splitLine[1]);
		this.roomNumber = 1;
		inventory = new Item[10];
		inventoryIndex = 0;
	}
	
	public String toString() {
		return "PlayerID: " + playerID
				+ "; " + "Score: " + score + "; " + "Room Number: " + roomNumber + ";";
	}
	
	public void setHealth(int i) {
		this.playerHealth = i;
	}
	
	public int getHealth() {
		return playerHealth;
	}
	
	public void addItem(Item i) {
		inventory[inventoryIndex] = i;
		inventoryIndex++;
	}
	
	public Item[] getInventory() {
		return inventory;
	}
	
	public int getArmor() {
		return this.playerArmor;
	}
	
	public void equip(Item i) {
		if (i.getItemStatType().equalsIgnoreCase("Armor")) {
			this.wieldedArmor = i;
			this.playerArmor = i.getArmorPoints();
		}
		if (i.getItemStatType().equalsIgnoreCase("Damage")) {
			this.wieldedWeapon = i;
			this.playerAttack = i.getDamagePoints();
		}
		if (i.getItemStatType().equalsIgnoreCase("Healing")) {
			
			if (playerHealth + i.getHealpoints() > 100) {
				playerHealth = 100;
			}
			else {
				this.setHealth(playerHealth + i.getHealpoints());

			}
		}
	}
	
	public void unequip(Item i) {
		if (i.getItemStatType().equalsIgnoreCase("Armor")) {
			this.wieldedArmor = null;
			this.playerArmor = 0;
		}
		if (i.getItemStatType().equalsIgnoreCase("Damage")) {
			this.wieldedWeapon = null;
			this.playerAttack = 10;
		}
		if (i.getItemStatType().equalsIgnoreCase("Healing")) {
			;
		}
	}
	
	public int getDamage() {
		if (playerAttack == 0) {
			return 10;
		}
		else {
			return playerAttack;
		}
		
	}
	
	public void drop(Item item) {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == item) {
				inventory[i] = null;
			}
		}
	}
	

	
}
