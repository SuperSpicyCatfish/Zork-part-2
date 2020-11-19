//
//  AUTHORS:        Julia and Tran
//	CLASS: 			CPSC - 233j
//	TEACHER:		Professor McCarthy
//	TIME:			T-Th 8:00am-9:45am
//  DUE:            November 21, 2020
//

package com.company;
import java.util.ArrayList;
import com.company.*;
import java.util.Scanner;


//=====================================================================
// Characters class
//=====================================================================
class Characters{
	Scanner scan = new Scanner(System.in);

	private Room theRoom; 											// the Room the main character is in
	private String name;
	private String description;
	private final int SIZE = 10;
	private int MAX_HEALTH;											// max health a player can have
	private int health; 											// current health
	private ArrayList<Items> aItems = new ArrayList<Items>(); 		// limiting Characters to only 10 items

	// Start of Telescoping Constructors
	public Characters(){
		this("No name");
	}

	public Characters(String name){
		this(name,"No description");
	}

	public Characters(String name, String description){
		this(name,description,0);
	}

	public Characters(String name,String description, int health){
		this(name,description,health,new Room()); 					//*** unsure if this works ***
	}

	public Characters(String name,String description, int health, Room theRoom){
		this.name = name;
		this.description = description;
		this.health = health;
		MAX_HEALTH = health;
		this.theRoom = theRoom;
	}
	// End of Telescoping Constructors

	public void setName(String name){	// setter function
		this.name = name;
	}		
	public String getName(){			// getter function
		return name;
	}

	public void setDescription(String description){	// setter function
		this.description = description;
	}
	public String getDescription(){					// getter function
		return description;
	}

	public void setHealth(int health){	// setter function, ** you cannot change the max health of a character with this function**
		this.health = health;			// this function is used for when the character takes damage
	}
	public int getHealth(){				// getter function
		return health;
	}

	public void setMAX_HEALTH(int MAX_H){	// setter function for the MAX_HEALTH value
		this.MAX_HEALTH = MAX_H;
	}

	public int getMAX_HEALTH(){			// getter function, returns the MAX_HEALTH value for this character
		return MAX_HEALTH;
	}

	public void setRoom(Room aRoom){	// setter function
        this.theRoom = aRoom;
    }

    public Room getRoom() {				// getter function
        return this.theRoom;
    }


    public void addWeapon(Weapons someWeapon){ // *** FOR GIVING WEAPONS TO MONSTERS ***
    	aItems.add(someWeapon);
    }

    public ArrayList<Items> getCharsInventory(){// game uses this to calculate the players score
    	return aItems;
	}

    public void dropItem(){
    	int choice = -1;
    	Items temp;
    	if(!aItems.isEmpty()){ // if the character's inventory is not empty
    		while(choice < 0 || choice >= aItems.size()){ // while character's choice is invalid
    			getInventory();

    			System.out.print("Which item do you want to drop?\nIndex: ");

    			if(scan.hasNextInt()){ // if a int
    				choice = scan.nextInt();
    				if(choice >= aItems.size() || choice < 0){ // invalid index
						System.out.println("Please enter a valid index.");
						choice = -1;
					}
					else{ // valid index
						temp = aItems.get(choice); // gets the item the character wants to drop
						theRoom.addItems(temp);    // adds the item to the room
						aItems.remove(choice);	   // removes the item from the character's inventory
						return; // TO BREAK OUT 
						// **********************************************************
						// THIS FUNCTIONALITY NEEDS TO BE TESTED
						// **********************************************************
					}
    			}
    			else{ // if not an int
    				System.out.println("Please enter a valid int index of the item to be dropped");
    				choice = -1;
    			}
    		}

    	}
    	else { // if the character does not have items
    		System.out.println("No items to drop");
    	}

    }


    // *************************************************
    // This does not remove an item from the room once it was picked up
    // could lead to duplication of item, BECAREFUL 
    // *************************************************
	public void pickUp(Items someItem){ 

		if(someItem.getPickUp()){ // if the Item can be picked up

			if(aItems.isEmpty())	// if the array is empty, add an item
			{
				aItems.add(someItem); 
				System.out.println(someItem.getName() + " was picked up");
			}
			else if(aItems.size() < SIZE ) // else, we have to check if inventory is full
			{
				aItems.add(someItem);
				System.out.println(someItem.getName() + " was picked up");
			}
			else{
				System.out.println("Inventory is full. Item was not picked up");
			}
		}
		else if(!someItem.getPickUp()){ // if the item can not be picked up
			System.out.println("Item can not be picked up");
		}

	}

	public void getInventory(){		// prints out the Characters' inventory
	
		if(!aItems.isEmpty()) // if the inventory has items
		{
			System.out.println("Inventory:");
			for(int i = 0; i < aItems.size(); ++i){				
				System.out.println("[Index:" + i + "]" + " " + aItems.get(i));
			}
		}
		else{
			System.out.println("Inventory is empty.");
		}
	}

	public void useItem(){	
		int choice = -1;
		Items temp;

		if(!aItems.isEmpty()) // Will only run if the player has items to use
		{
			while(choice < 0 || choice >= aItems.size()){ // the user's choice can not be -1 or >= 10, both are out of bounds
				
				getInventory();		// prints out the player's inventory, the player must decide which item to use by giving an index

				System.out.print("\nWhich item do you want to use?\nIndex: ");


				if(!scan.hasNextInt()){			// if the user does not enter an int value
					System.out.println("Please enter an integer index of the item to be used.");
					choice = -1;
				}
				else {	// if the user enters an int
					choice = scan.nextInt();
					if(choice >= aItems.size() || choice < 0){ // invalid index
						System.out.println("Please enter a valid index.");
						choice = -1;
					}
					else{ // valid index
						temp = aItems.get(choice);
						if(temp instanceof Consumables){ // CHECKING OBJECT TYPE ********** Some cool stuff ************
							((Consumables)temp).useItem(this); // should pass the Characters. OBJECT CASTING
						} 
						else{
							temp.useItem();

						}
						return; // TO BREAK OUT
						// **********************************************************
						// THIS FUNCTIONALITY NEEDS TO BE TESTED
						// **********************************************************
					}
				}
			}
		}
		else{
			System.out.println("No items to use");
		}

	}


	public String toString(){ // toString function for Characters
		String temp = (getName() + ". " + getDescription() + ". Health: " + getHealth());
		return temp;
	}




} // end of Characters
