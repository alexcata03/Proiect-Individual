package proiect;

public class Equipment extends Item{
    private int armor;
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getArmor()
	{
		return this.armor;
	}
	private int damagemin;
    public int getDamagemin() {
		return damagemin;
	}
	public void setDamagemin(int damagemin) {
		this.damagemin = damagemin;
	}
	private int damagemax;
	public int getDamagemax() {
		return damagemax;
	}
	public void setDamagemax(int damagemax) {
		this.damagemax = damagemax;
	}
	public Equipment(String n,int q, String r,String t,int a,int dmin,int dmax)
	{
		super(n,q, r ,t );
		this.armor=a;
		this.damagemax=dmax;
		this.damagemin=dmin;
	}
	@Override
	public String toString() 
	{
		if(this.getType().compareTo("weapon")==0)
	    return super.getName()+" Type:"+ super.getType()+ " Rarity:" + super.getRarity()+ " Quantity:"+super.getQuantity()
	    + " Damage:" + this.damagemin + "-" + this.damagemax;
		else
			return super.getName()+" Type:"+ super.getType()+ " Rarity:" + super.getRarity()+ " Quantity:"+super.getQuantity()
		    + " Armor:" +this.armor;
	}
}
