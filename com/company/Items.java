//
//  AUTHORS:        Julia and Tran
//	CLASS: 			CPSC - 233j
//	TEACHER:		Professor McCarthy
//	TIME:			T-Th 8:00am-9:45am
//  DUE:            November 21, 2020
//

package com.company;
import com.company.*;


//=====================================================================
// Item interface
//=====================================================================
interface Items {

	public void useItem();					// each class will provide functionality
	public boolean canPickUp();  			// returns true/false if the player can pick up this item
	public boolean getPickUp();

	public String getName();
	public void setName(String n);
	public String getDescription();
	public void setDescription(String d);
}

//=====================================================================
// Weapon class
//=====================================================================
class Weapons implements Items {
	private String name;
	private String description;
	private int damage;						
	private boolean pickUp;					


	// Start of Telescoping Constructors
	public Weapons(){				
		this("NO NAME");		
	}

	public Weapons(String name){
		this(name,"NO DESCRIPTION");
	}

	public Weapons(String name, String description){
		this(name,description,0);
	}

	public Weapons(String name, String description, int damage){
		this(name,description,damage,false);
	}

	public Weapons(String name, String description, int damage, boolean pickUp){
		this.name = name;								
		this.description = description;					
		this.damage = damage;
		this.pickUp = pickUp;
	}
	// End of Telescoping Constructors


	public void setName(String name){ this.name = name;} // setter function
	public String getName(){return name;}				 // getter function

	public void setDescription(String description){this.description = description;} // setter function
	public String getDescription(){return description;} 							// getter function

	public void setDamage(int damage){this.damage = damage;}
	public int getDamage(){return damage;}

	public void setPickUp(boolean pickUp){this.pickUp = pickUp;} 	// setter function
	public boolean getPickUp(){return pickUp;}						// getter function

	public boolean canPickUp(){										// interface function
		if(getPickUp()){
			System.out.println("Can PICK UP " + getName());
		}
		else{
			System.out.println("Can NOT PICK UP " + getName());
		}
		return getPickUp();
	}			

	public void useItem(){				// Weapon's useItem() will attack and do damage to a valid target, this useItem didnt supply a target
		System.out.println("ATTACK with " + getName());
		System.out.println("Nothing happened...");	
		
	}

	// Overloaded useItem()				
	public void useItem(Characters target){	// attacking a specified Character
		System.out.println("ATTACK " + target.getName() + " with " + getName());


		int newHealth = (target.getHealth() - getDamage());
		target.setHealth(newHealth); 							// changes the Character's health

		if(target.getHealth() <= 0)
		{
			target.setHealth(0);
			System.out.println(target.getName() + " was killed");
			// **********************************************************************
			// THE ROOM MUST DELETE THE CHARACTER/TARGET
			// IF THE TARGET WAS THE MAIN CHARACTER AND THEY DIE, THE GAME MUST
			// END. THE PLAYER'S TREASURE MUST BE TALLIED UP TO FIGURE OUT THEIR SCORE
			// **********************************************************************
		}
		else{
			System.out.println(getDamage() + " damage done");
		}
		
	}

	public String toString(){  // toString function
		String temp = ("A " + getName() + ". " + getDescription() +". Damage: " + getDamage());
		return temp;
	}

	
}


//=====================================================================
// Treasure class
//=====================================================================
 class Treasures implements Items{
	private String name;
 	private String description;
 	private boolean pickUp;
 	private int value;


 	// Start of Telescoping Constructors
 	public Treasures(){
 		this("NO NAME");
 	}

 	public Treasures(String name){
 		this(name,"NO DESCRIPTION");
 	}

 	public Treasures(String name,String description){
 		this(name,description,false);
 	}

 	public Treasures(String name,String description, boolean pickUp){
 		this(name,description,pickUp,0);
 	}

 	public Treasures(String name, String description, boolean pickUp, int value){
 		this.name = name;
 		this.description = description;
 		this.pickUp = pickUp;
 		this.value = value;
 	}
	// End of Telescoping Constructors

 	public void setName(String name){this.name = name;}	// setter function
 	public String getName(){return name;}				// getter function

 	public void setDescription(String description){this.description = description;}	// setter function
 	public String getDescription(){return description;}								// getter function

 	public void setValue(int value){this.value = value;}	// setter function
 	public int getValue(){return value;}					// getter function

 	public void setPickUp(boolean pickUp){this.pickUp = pickUp;} // setter function
 	public boolean getPickUp(){return pickUp;}					 // getter function

	public boolean canPickUp(){									 // interface function
		if(getPickUp()){
			System.out.println("Can PICK UP " + getName());
		}
		else{
			System.out.println("Can NOT PICK UP " + getName());
		}
		return getPickUp();
	}

	public void useItem(){
		System.out.println("Playing with the " + getName());	
		// ***************************************************************************
		// treasure does not do anything besides increase the players score at the end 
		// ***************************************************************************
	}

	public String toString(){		// toString method
		String temp = ("A " + getName() + ". "  + getDescription() + ". Value: " + getValue());
		return temp;
	}

 }

//=====================================================================
// Consumables class
//=====================================================================
class Consumables implements Items{
	private String name;
	private String description;
	private boolean pickUp;
	private int value;				// amount of health it restores 


 	// Start of Telescoping Constructors
	public Consumables(){
		this("NO NAME");
	}

	public Consumables(String name){
		this(name,"NO DESCRIPTION");
	}

	public Consumables(String name,String description){
		this(name,description,false);
	}

	public Consumables(String name,String description, boolean pickUp){
		this(name,description,pickUp,0);
	}

	public Consumables(String name, String description, boolean pickUp, int value){
		this.name = name;
		this.description = description;
		this.pickUp = pickUp;
		this.value = value;
	}
	// End of Telescoping Constructors

	public void setName(String name){this.name = name;}	// setter function
 	public String getName(){return name;}				// getter function

 	public void setDescription(String description){this.description = description;}	// setter function
 	public String getDescription(){return description;}								// getter function

 	public void setPickUp(boolean pickUp){this.pickUp = pickUp;} // setter function
 	public boolean getPickUp(){return pickUp;}					 // getter function

	public boolean canPickUp(){									 // interface function
		if(getPickUp()){
			System.out.println("Can PICK UP " + getName() );
		}
		else{
			System.out.println("Can NOT PICK UP " + getName());
		}
		return getPickUp();
	}

	public void setValue(int value){	// setter function
		this.value = value;
	}
	public int getValue(){				// getter function 
		return value;
	}

	public void useItem(){				// if we do not provide a target/character to provide healing to
		System.out.println("Used " + getName() + ".");
		System.out.println("Nothing happened...");
	}

	// Overloaded useItem()
	public void useItem(Characters target){ // the target in this case is the Character in the (), allows for healing other characters
		System.out.println("Used " + getName() + "."); //" It restores " + this.getValue() + " health.");

		int newHealth = target.getHealth() + getValue(); 
		if(newHealth > target.getMAX_HEALTH()){
			target.setHealth(target.getMAX_HEALTH());	// setting the target's health to the max value it can be, there is no over healing
			System.out.println("Health is at max! Health: " + target.getHealth());
		}
		else{
			target.setHealth(newHealth);
			System.out.println("It restores " + getValue() + " health. To " + target.getName());
		}
	}

	public String toString(){	// toString function
		String temp = ("A " + getName() + ". " + getDescription() + ". Healing: " + getValue());
		return temp;
	}

}

//=====================================================================
// NonConsumable class
//=====================================================================
class NonConsumables implements Items{
	private String name;
	private String description;
	private boolean pickUp;
	private String whenUsed;	// unique for each item, ex: Ball, when used,"You bounce the ball. It makes you happy."

 	// Start of Telescoping Constructors
	public NonConsumables(){
		this("NO NAME");
	}

	public NonConsumables(String name){
		this(name,"NO DESCRIPTION");
	}

	public NonConsumables(String name, String description){
		this(name,description,false);
	}

	public NonConsumables(String name, String description, boolean pickUp){
		this(name,description,pickUp,"Nothing happened");
	}

	public NonConsumables(String name, String description, boolean pickUp, String whenUsed){
		this.name = name;
		this.description = description;
		this.pickUp = pickUp;
		this.whenUsed = whenUsed;
	}
	// End of Telescoping Constructors

	public void setName(String name){this.name = name;}	// setter function
 	public String getName(){return name;}				// getter function

 	public void setDescription(String description){this.description = description;}	// setter function
 	public String getDescription(){return description;}								// getter function

 	public void setPickUp(boolean pickUp){this.pickUp = pickUp;} // setter function
 	public boolean getPickUp(){return pickUp;}					 // getter function

	public boolean canPickUp(){									 // interface function
		if(getPickUp()){
			System.out.println("Can PICK UP " + getName());
		}
		else{
			System.out.println("Can NOT PICK UP " + getName());
		}
		return getPickUp();
	}

	public void setWhenUsed(String whenUsed){	// setter function
		this.whenUsed = whenUsed;
	}
	public String getWhenUsed(){				// getter function
		return whenUsed;
	}

	public void useItem(){
		System.out.println("You use " + getName() + ". " + getWhenUsed() + "."); 
		// **********************************************************************************
		// Unsure if we should expand this? or allow using NonConsumables to do anything else 
		// **********************************************************************************
	}

	public String toString(){	// toString function
		String temp = ("A " + getName() + ". " + getDescription() + ".");
		return temp;
	}

} // end of items