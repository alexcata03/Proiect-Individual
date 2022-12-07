package proiect;

public class Equipped {
	private Equipment head;
	public Equipment getHead() {
		return head;
	}
	public void setHead(Equipment head) {
		this.head = head;
	}
	private Equipment chest;
	public Equipment getChest() {
		return chest;
	}
	public void setChest(Equipment chest) {
		this.chest = chest;
	}
	private Equipment legs;
	public Equipment getLegs() {
		return legs;
	}
	public void setLegs(Equipment legs) {
		this.legs = legs;
	}
	private Equipment boots;
	public Equipment getBoots() {
		return boots;
	}
	public void setBoots(Equipment boots) {
		this.boots = boots;
	}
	private Equipment gloves;
	public Equipment getGloves() {
		return gloves;
	}
	public void setGloves(Equipment gloves) {
		this.gloves = gloves;
	}
	private Equipment weapon;
	public Equipment getWeapon() {
		return weapon;
	}
	public void setWeapon(Equipment weapon) {
		this.weapon = weapon;
	}
	private int totalarmor=0;
	public int getTotalarmor() {
		return totalarmor;
	}
	public void CheckTotalarmor(int totalarmor) {
		if(checkHead()!=true)
			totalarmor=totalarmor+head.getArmor();
		if(checkChest()!=true)
			totalarmor=totalarmor+chest.getArmor();
		if(checkLegs()!=true)
			totalarmor=totalarmor+legs.getArmor();
		if(checkBoots()!=true)
			totalarmor=totalarmor+boots.getArmor();
		if(checkGloves()!=true)
			totalarmor=totalarmor+gloves.getArmor();
	}
	public boolean checkHead()
	{
		if(this.head!=null)
			return true;
		else
			return false;
	}
	public boolean checkChest()
	{
		if(this.chest!=null)
			return true;
		else
			return false;
	}
	public boolean checkLegs()
	{
		if(this.legs!=null)
			return true;
		else
			return false;
	}
	public boolean checkBoots()
	{
		if(this.boots!=null)
			return true;
		else
			return false;
	}
	public boolean checkGloves()
	{
		if(this.gloves!=null)
			return true;
		else
			return false;
	}
	public boolean checkWeapon()
	{
		if(this.weapon!=null)
			return true;
		else
			return false;
	}
	public void showEquipped() 
	{
	    System.out.println("Equipped Items:");
	    if(checkHead()==true)
	    	System.out.println("Helmet:None");
	    	else
	    System.out.println("Helmet:" + head);
	    if(checkChest()==true)
	    	System.out.println("Chestplate:None");
	    	else
	    System.out.println("Chestplate:" + chest);
	    if(checkLegs()==true)
	    	System.out.println("Leggings:None");
	    	else
	    System.out.println( "Leggings:" + legs);
	    if(checkBoots()==true)
	    	System.out.println("Boots:None");
	    	else
	    System.out.println( "Boots:" + boots);
	    if(checkGloves()==true)
	    	System.out.println("Gloves:None");
	    	else
	  	System.out.println( "Gloves:" + gloves);
	    if(checkWeapon()==true)
	    	System.out.println("Weapon:None");
	    	else
	 	System.out.println( "Weapon:" + weapon);
	}
	public Equipped(Equipment h,Equipment c,Equipment l, Equipment b, Equipment g, Equipment w)
	{
		this.boots=b;
		this.chest=c;
		this.gloves=g;
		this.head=h;
		this.legs=l;
		this.weapon=w;
	}
}
