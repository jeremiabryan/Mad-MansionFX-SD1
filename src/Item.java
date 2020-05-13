
public class Item {

	private String ItemName;
	private int ItemID;
	private String	ItemDescription;
	private String ItemStatType;
	private int ItemStatAmount;
	
	private int damagePoints;
	private int armorPoints;
	private int healpoints;
	private boolean wasDropped;
	




	/**
	 * @param itemID
	 * @param itemName
	 * @param itemDescription
	 * @param itemStatType
	 * @param itemStatAmount
	 * @param damagePoints
	 * @param armorPoints
	 * @param healpoints
	 */
	public Item(int itemID, String itemName, String itemDescription, String itemStatType, int itemStatAmount,
			int damagePoints, int armorPoints, int healpoints) {
		ItemName = itemName;
		ItemID = itemID;
		ItemDescription = itemDescription;
		ItemStatType = itemStatType;
		ItemStatAmount = itemStatAmount;
		this.damagePoints = damagePoints;
		this.armorPoints = armorPoints;
		this.healpoints = healpoints;
	}


	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return ItemName;
	}


	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		ItemName = itemName;
	}


	/**
	 * @return the itemID
	 */
	public int getItemID() {
		return ItemID;
	}


	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID) {
		ItemID = itemID;
	}


	/**
	 * @return the itemDescription
	 */
	public String getItemDescription() {
		return ItemDescription;
	}


	/**
	 * @param itemDescription the itemDescription to set
	 */
	public void setItemDescription(String itemDescription) {
		ItemDescription = itemDescription;
	}


	/**
	 * @return the itemStatType
	 */
	public String getItemStatType() {
		return ItemStatType;
	}


	/**
	 * @param itemStatType the itemStatType to set
	 */
	public void setItemStatType(String itemStatType) {
		ItemStatType = itemStatType;
	}


	/**
	 * @return the itemStatAmount
	 */
	public int getItemStatAmount() {
		return ItemStatAmount;
	}


	/**
	 * @param itemStatAmount the itemStatAmount to set
	 */
	public void setItemStatAmount(int itemStatAmount) {
		ItemStatAmount = itemStatAmount;
	}


	/**
	 * @return the damagePoints
	 */
	public int getDamagePoints() {
		return damagePoints;
	}


	/**
	 * @param damagePoints the damagePoints to set
	 */
	public void setDamagePoints(int damagePoints) {
		this.damagePoints = damagePoints;
	}


	/**
	 * @return the armorPoints
	 */
	public int getArmorPoints() {
		return armorPoints;
	}


	/**
	 * @param armorPoints the armorPoints to set
	 */
	public void setArmorPoints(int armorPoints) {
		this.armorPoints = armorPoints;
	}


	/**
	 * @return the healpoints
	 */
	public int getHealpoints() {
		return healpoints;
	}


	/**
	 * @param healpoints the healpoints to set
	 */
	public void setHealpoints(int healpoints) {
		this.healpoints = healpoints;
	}

	@Override
	public String toString() {
		return "Item [ItemName=" + ItemName + ", ItemID=" + ItemID + ", ItemDescription=" + ItemDescription
				+ ", ItemStatType=" + ItemStatType + ", ItemStatAmount=" + ItemStatAmount + ", damagePoints="
				+ damagePoints + ", armorPoints=" + armorPoints + ", healpoints=" + healpoints + "]";
	}
	
	public boolean isDrop() {
		return wasDropped;
	}
	
	public void setDropped(boolean wasDropped) {
		this.wasDropped = wasDropped;
	}
	
	
}
