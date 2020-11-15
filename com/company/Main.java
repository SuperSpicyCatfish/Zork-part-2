//
//  AUTHORS:        Julia and Tran
//	CLASS: 			CPSC - 233j
//	TEACHER:		Professor McCarthy
//	TIME:			T-Th 8:00am-9:45am
//  DUE:            November 1, 2020
//

package com.company; // Main is part of the com.company package?
import com.company.*;


public class Main{

	public static void main(String[] args) {

		//
		//	Testing
		//
		
		// Weapons sword1 = new Weapons("Wood sword","A flimsy wooden sword",3,true);
		// Treasures coin = new Treasures("Gold coin","A single gold coin with a skull on one side",true,2);
		// Consumables waterJug = new Consumables("Water jug","A portable jug that has some water in it",true,4);
		// NonConsumables ball = new NonConsumables("Bouncy ball","A small ball that has a nice bounce to it",true,"It makes you happy");
		// Characters player = new Characters("Julia", "20 year old gamer, beginning skateboarder, and art enthusiast",20);
		// Room startRoom = new Room("Starting room","A room with some items in it",-1,-1,-1,-1);


		// player.setRoom(startRoom);
		// 									// adding items to the starting room
		// startRoom.addItems(ball);
		// startRoom.addItems(waterJug);
		// startRoom.addItems(coin);
		// startRoom.addItems(sword1);


		// System.out.println(sword1); 		// equivalent to LOOK at WEAPONS
		// sword1.canPickUp();					// if a item can be picked up
		// sword1.useItem();					// using a WEAPONS without a target

		// System.out.println("\n" + coin); 	// equivalent to LOOK at TREASURES
		// coin.useItem();					 	// USE for TREASURES

		// System.out.println("\n" + waterJug);// equivalent to LOOK at CONSUMABLES
		// waterJug.useItem();					// 

		// System.out.println("\n" + ball); 	// equivalent to LOOK at NonConsumables
		// ball.useItem();

		// System.out.println("\n" + player); 	// equivalent to LOOK at themselves 
		// player.getInventory();			   	// equivalent to INVENTORY
		// // player.pickUp(sword1);
		// // player.pickUp(coin);
		// // player.pickUp(waterJug);
		// // player.pickUp(ball);
		// // player.getInventory();

		// System.out.println(player.getRoom());

		// // ************************************************
		// // logic for picking up an item from a room
		// // ************************************************
		// // say a player wants to pick up an item and tells us the index of the item
		// Items temp = (player.getRoom()).getItems(2);	 // the player needs to specify which item via its index
		// player.pickUp(temp); 							 // the player picks up that item
		// (player.getRoom()).removeItems(2);				 // the room removes the item given the index

		// System.out.println(player.getRoom());

		// // player drops Item
		// player.dropItem();

		// System.out.println("\n\n"+ player.getRoom());
		// player.getInventory();

		// player.useItem(); // no items to use, inventory empty

		// temp = (player.getRoom()).getItems(1);	 		// the player needs to specify which item via its index
		// player.pickUp(temp); 							 // the player picks up that item
		// (player.getRoom()).removeItems(1);				 // the room removes the item given the index


		// player.useItem();



		// *************************************
		// Need to test Room's functions 
		// Need to test Game's functions
		// Need to test Character's functions/ interactions with Items, Rooms and attacking other Characters
		// Need a combat system
		// Need to draw a map
		// If a Character's health hits zero - if enemy, delete them
		// - if main player, end game, total up score from the value of all the treasures collected
		// *************************************


		Game theGame = new Game();

		System.out.println("The end");


	}
}