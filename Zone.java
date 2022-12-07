package proiect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zone {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private List<Mob> Mobs=new ArrayList<>();
	private int reclvl;

	public List<Mob> getMobs() {
		return Mobs;
	}

	public void setMobs(List<Mob> mobs) {
		Mobs = mobs;
	}

	public int getReclvl() {
		return reclvl;
	}

	public void setReclvl(int reclvl) {
		this.reclvl = reclvl;
	}
	public Mob findEnemy()
	{
		Random rand = new Random();
	    Mob Enemy = Mobs.get(rand.nextInt(Mobs.size()));
	    return Enemy;
	}
	public Zone(String n,List<Mob> m,int rl)
	{
		this.name=n;
		this.Mobs=m;
		this.reclvl=rl;
	}
	public void ZoneInfo() {
	    System.out.println(name+":");
	            System.out.println("Minimum level required:" + reclvl);
	    for(Mob m : Mobs)
	    	System.out.println(m.getName());
	}
}
