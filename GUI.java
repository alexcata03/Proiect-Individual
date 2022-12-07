package proiect;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Scanner Scan=new Scanner(System.in);
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
		//Inventory Inv=new Inventory();
		//Equipped Equip=new Equipped();
		P1.getI().addToInventory(Silver_Sword, 1);
		//P1.getI().ShowInventory();
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Adventure");
		btnNewButton.setBounds(169, 191, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
