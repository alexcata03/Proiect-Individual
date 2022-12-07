package proiect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Mob {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int damage;
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	private int health;
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	private List<Item> Loot=new ArrayList<>();
	private String zone;
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public Map<Item,Integer> generateLoot(List<Item> i)
	{
		Map<Item,Integer> Drop=new HashMap<>();
		Random r = new Random();
		int luck=r.nextInt(i.size());
		for(int j=0;j<luck;j++)
		{
			if(i.get(j).getType().compareTo("material")==0)
			{
				int luck2=r.nextInt(i.get(j).getQuantity());
				if(Drop.containsKey(i.get(j)))
					Drop.put(i.get(j), Drop.get(i.get(j)) + luck2);
				else
					Drop.put(i.get(j),luck2);
			}
			else
			{
			if(Drop.containsKey(i.get(j)))
				Drop.put(i.get(j), Drop.get(i.get(j)) + 1);
			else
				Drop.put(i.get(j),1);
			}
			
		}
		return Drop;
	}
	public List<Item> getLoot() {
		return Loot;
	}
	public void setLoot(List<Item> loot) {
		Loot = loot;
	}
	private int level;
	private int exp;
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Mob(String n, int d, int h,List<Item> l,String z,int e,int lvl)
	{
		this.name=n;
		this.damage=d;
		this.health=h;
		this.Loot=l;
		this.zone=z;
		this.level=lvl;
		this.exp=e;
	}
	@Override
	public String toString() {
	    return name +": "
	            + "Level:" + level+"\r\n"
	            + "Health:"+health+ "\r\n"
	            + "Damage:"+damage+"\r\n"
	            + "Experience:"+exp+"\r\n"
	            + "Current Zone:"+zone+"\r\n"
	            +"Loot table:"+"\r\n"
	            +Loot;

	}
	public void showStats()
	{
		System.out.println(name);
		System.out.println(level);
		System.out.println(health);
		System.out.println(damage);
	}
}
