package proiect;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Player {
   private String name;
   public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
private int level;
   public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
private int str;
   public int getStr() {
	return str;
}
public void setStr(int str) {
	this.str = str;
}
private int health;
   public int getHealth() {
	return health;
}
public void setHealth(int health) {
	this.health = health;
}
private int intel;
   public int getIntel() {
	return intel;
}
public void setIntel(int intel) {
	this.intel = intel;
}
private int mana;
   public int getMana() {
	return mana;
}
public void setMana(int mana) {
	this.mana = mana;
}
private int cmana=mana;
   public int getCmana() {
	return cmana;
}
public void setCmana(int cmana) {
	this.cmana = cmana;
}
private String Zone;
   public String getZone() {
	return Zone;
}
public void setZone(String zone) {
	Zone = zone;
}
private int cexp;
   public int getCexp() {
	return cexp;
}
public void setCexp(int cexp) {
	this.cexp = cexp;
}
private int maxexp;
   public int getMaxexp() {
	return maxexp;
}
public void setMaxexp(int maxexp) {
	this.maxexp = maxexp;
}
private Map<Item,Integer>Inventory=new HashMap<>();
private Equipped e;
public Equipped getE() {
	return e;
}
public void setE(Equipped e) {
	this.e = e;
}
public int dealDamage()
{
	Random r=new Random();
	int damage;
	if(this.getE().getWeapon()==null)
		damage=this.str;
	else
	damage=r.nextInt(this.getE().getWeapon().getDamagemax()-this.getE().getWeapon().getDamagemin()) + this.getE().getWeapon().getDamagemin()+this.str;
	return damage;
}
public int takeDamage(int d)
{
	return this.getE().getTotalarmor()-d;
}
public void levelup()
{
	this.health+=50;
	this.mana+=50;
	this.str+=10;
	this.maxexp+=100;
	this.level++;
}
public void addexp(int e)
{
	this.cexp+=e;
	if(cexp>=maxexp)
	{
		cexp=maxexp-cexp;
		levelup();
	}
}
public Player(String n)
{
	this.str=10;
	this.name=n;
	this.health=100;
	this.maxexp=100;
	this.cexp=0;
	this.mana=100;
	this.Zone="Town";
	Equipped eq=new Equipped(null,null,null,null,null,null);
	this.e=eq;
	Map<Item,Integer> Inv=new HashMap<>();
	this.Inventory=Inv;
}
public void addToInventory(Item i, int quant)
{
	if(Inventory.containsKey(i))
		Inventory.put(i, Inventory.get(i) + quant);
	else
		Inventory.put(i,quant);
}
public void removeFromInventory(Item i, Integer quant)
{
	if(Inventory.containsKey(i))
		Inventory.put(i, Inventory.get(i) - quant);
	if(Inventory.get(i)==0)
		Inventory.remove(i);
}
public boolean ExistsIn(Item i)
{
	return Inventory.containsKey(i);
}
public void ShowInventory() {
	if(Inventory.isEmpty())
		System.out.println("Inventory is empty");
	else
    for(Item i: Inventory.keySet())
    {
    	String key= i.getName();
    	int value=Inventory.get(i);
    	System.out.println("Item Name: "+key+ " Quantity: "+value);
    }	    
}
public void equipItem(Equipment eq)
{
	if(Inventory.containsKey(eq))
	{
		if(eq.getType().compareTo("helmet")==0 && this.e.checkHead()==true)
			{
			this.e.setHead(eq);
		    this.removeFromInventory(eq,1);
			}
		if(eq.getType().compareTo("chestplate")==0 && this.e.checkChest()==true)
		{
		this.e.setChest(eq);
	    this.removeFromInventory(eq,1);
		}
		if(eq.getType().compareTo("weapon")==0 && this.e.checkWeapon()==true)
		{
		this.e.setWeapon(eq);
	    this.removeFromInventory(eq,1);
		}
		if(eq.getType().compareTo("leggings")==0 && this.e.checkLegs()==true)
		{
		this.e.setLegs(eq);
	    this.removeFromInventory(eq,1);
		}
		if(eq.getType().compareTo("boots")==0 && this.e.checkBoots()==true)
		{
		this.e.setBoots(eq);
	    this.removeFromInventory(eq,1);
		}
		if(eq.getType().compareTo("gloves")==0 && this.e.checkGloves()==true)
		{
		this.e.setGloves(eq);
	    this.removeFromInventory(eq,1);
		}
	}
		
}
@Override
public String toString() {
    return name +": "
            + "Level:" + level+ "\r\n"
            + "Health:" +health+"\r\n"
            + "Current Zone:"+Zone;

}
public void unequipItem(Equipment eq)
{
	if(eq.getType().compareTo("helmet")==0 && this.e.checkHead()==false)
	{
	this.e.setHead(null);
    this.addToInventory(eq,1);
	}
}
}
