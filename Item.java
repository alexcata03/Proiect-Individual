package proiect;

public class Item {
	public enum Chances{
		common, uncommon, rare, epic
	}
	public enum type{
		material, helmet, chestplate, weapon, leggings, boots, gloves
	}
	private int Quantity;
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	private String Rarity;
	public String getRarity() {
		return Rarity;
	}
	public void setRarity(String rarity) {
		Rarity = rarity;
	}
	private String type;
	public String getType()
	{
		return type;
	}
	public void setType(String t) {
		this.type=t;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Item(String n,int q, String r,String t)
	{
		this.Quantity=q;
		this.Rarity=r;
		this.type=t;
		this.name=n;
	}
	@Override
	public String toString() 
	{
	    return name +" Type:"+ type + " Rarity:" + Rarity+ " Quantity:"+Quantity;
	}
}
