package proiect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	Scanner myScanner=new Scanner(System.in);
	Scanner enterScanner=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Scan=new Scanner(System.in);
		System.out.println("Select a name for your character:");
		String CharacterName=Scan.nextLine();
		Player P1=new Player(CharacterName);
		Item Goblin_Ear=new Item("Goblin Ear",5,"common","material");
		Equipment Silver_Sword=new Equipment("Silver Sword",1,"common","weapon",0,2,5);
		List<Item> Goblin_Drop=new ArrayList();
		Goblin_Drop.add(Goblin_Ear);
		Goblin_Drop.add(Silver_Sword);
		Mob Goblin=new Mob("Goblin",10,20,Goblin_Drop,"Green Forest",15,1);
		List<Mob>Green_Forest_Mobs=new ArrayList();
		Green_Forest_Mobs.add(Goblin);
		Zone Green_Forest=new Zone("Green_Forest",Green_Forest_Mobs,1);
		//System.out.println(P1);
		//System.out.println(Goblin_Ear);
		//System.out.println(Silver_Sword);
		//System.out.println(Goblin);
		//Green_Forest.ZoneInfo();
		P1.addToInventory(Silver_Sword, 1);
		//P1.getI().ShowInventory();
		while(Scan.nextLine()!="Quit Game")
		{
		System.out.println(String.format("     Myth Fighter     "));
		System.out.println("   Select your choice     ");
		System.out.println("   1.Adventure     ");
		System.out.println("   2.Inventory     ");
		System.out.println("   3.Quit Game     ");
		String Option=Scan.nextLine();
		if(Option=="Adventure");
		{
			System.out.println("   Select a zone     ");
			System.out.println("   1.Green_Forest     ");
			System.out.println("   2.Town     ");
			Option=Scan.nextLine();
			if(Option=="Green_Forest")
			{
				Mob enemy=Green_Forest.findEnemy();
				enemy.showStats();
				while(Scan.hasNextLine())
					{
					System.out.println("   Select your choice     ");
					System.out.println("   1.Fight    ");
					System.out.println("   2.Run     ");
					Option=Scan.nextLine();
					if(Option=="Fight")
						{
				          int ok=1;
				          int PlayerCh=P1.getHealth();
				          int EnemyCh=enemy.getHealth();
				          while(PlayerCh!=0 || EnemyCh!=0)
				          	{
				        	  if(ok==1)
				        	  	{
				        		  int damage=P1.dealDamage();
				        		  System.out.println("Player dealt "+damage+" damage");
				        		  EnemyCh=EnemyCh-damage;
				        		  ok=0;
				        	  	}
				        	  else
				        	  	{
				        		  System.out.println("Player took "+enemy.getDamage()+" damage");
				        		  PlayerCh=PlayerCh-enemy.getDamage();
				        		  ok=1;
				        	  	}
				          	}
				          if(PlayerCh!=0)
				          	{
				        	  System.out.println("You won!");
				        	  Map<Item,Integer>Loot=enemy.generateLoot(Goblin_Drop);
				        	  P1.addexp(enemy.getExp());
				        	  System.out.println("   Select your choice     ");
				        	  System.out.println("   1.Loot    ");
				        	  System.out.println("   2.Search     ");
				        	  System.out.println("   2.Run     ");
				        	  Option=Scan.nextLine();
				        	  if(Option=="Loot")
				        	  	{
				        		  for (Map.Entry<Item, Integer> set :Loot.entrySet())
				        		  	{
				        			  P1.addToInventory(set.getKey(),set.getValue());
				        		  	}
				        		  continue;
				        	  	}
				        	  if(Option=="Search")
				        	  	{
				        		  continue;
				        	  	}
				        	  if(Option=="Run")
				        	  	{
				        		  break;
				        	  	}
				          	}
				          else
				          	{
				        	  System.out.println("You lost!");
				        	  break;
				          	}
						}
					}
				}
			}
			if(Option=="Town")
					break;
			if(Option=="Inventory")
				{
					P1.ShowInventory();
				}
		if(Option=="Quit Game")
			System.out.println(" Good Bye");
		
		}
	}
}
    
