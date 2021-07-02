package Game;

import java.util.Scanner;

import fixtures.Room;

//import fixture.Room;
//import Game.Player;

//import game.RoomManager;

public class Main {
	private static RoomManager manager = new RoomManager(4);
	public static boolean running=true;
	
	
	public static void main(String[] args) {
	manager.init();
	Player player = new Player();
	System.out.println("Welcome to my home tour!"
			+ "\nTo move around, you can say GO OR MOVE and the direction "
			+ "\nFor stop playing, enter \"quit\""
			);
	player.setCurrentRoom(manager.getStartingRoom());
	
	while (running) {
		printRoom(player);
		String[] input = collectInput();
		parse(input, player);
	}
	if (!running) {
		System.out.println("Thanks for playing");
	}

	}
	
	private static void printRoom(Player player) {
//		System.out.println(":::: CURRENT ROOM ::::");
		System.out.println("Name: " + player.getCurrentRoom().getName());
		//System.out.println("Short Desc: " + player.getCurrentRoom().getShortDescription());
		System.out.println("Long Desc: " + player.getCurrentRoom().getLongDescription());
		
		
		Room[] exits= player.getCurrentRoom().getExits();
		System.out.println("\nExits:");
				for(int i=0; i<4;i++) {
					if(exits[i]!=null) {
						if(i==0) {
							System.out.println("North: "+exits[i].getShortDescription());
						}
						if(i==1) {
							System.out.println("East: "+exits[i].getShortDescription());
						}
						if(i==2) {
							System.out.println("South: "+exits[i].getShortDescription());
						}
						if(i==3) {
							System.out.println("West: "+exits[i].getShortDescription());
						}
					
					}}	

	}
	private static String[] collectInput() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] phrase = input.split(" ");
		return phrase;
	}
	
	private static void parse(String[] command, Player player) {
		String action = command[0].toUpperCase().intern();
		String direction = null;// =null
		
		if (command.length > 1) {
			direction = command[1].toUpperCase().intern();
		}
		
		if (action == "GO" | action == "MOVE") {
			System.out.println("You try to move: " + direction);
			Room move = player.getCurrentRoom().getExit(direction);
			player.setCurrentRoom(move);
		} else if (action == "QUIT") {
			running = false;
		}
	}

}
