//
//  AUTHORS:        Julia, Tran and Rushi
//	CLASS: 			CPSC - 233j
//	TEACHER:		Professor McCarthy
//	TIME:			T-Th 8:00am-9:45am
//	DUE: 			October 30, 2020
//

package com.company;
import java.util.ArrayList;
import com.company.*;


// Commands class
class Commands{

    private String command;
    private String secondCommand;
    private String thirdCommand;
    private String fourthCommand;  //this is the character the player chooses to play as
    // this is so we can add more commands later and don't have to worry about the type of command while testing
    ArrayList<String> nonListedCommands = new ArrayList<String>();

    // telescoping Constructors
    public Commands(){
        this("No command entered");
    }

    public Commands(String firstCommand){
        this(command,"north");
    }

    public Commands(String firstCommand, String secondCommand){
        this(command, secondCommand, "player1");
    }

    public Commands(String firstCommand, String secondCommand, String thirdCommand){
        this(command, secondCommand, thirdCommand, "lantern");
    }

    public Commands(String firstCommand, String secondCommand, String thirdCommand, String fourthCommand){
        this(command, secondCommand, thirdCommand, fourthCommand, "dracula");
    }

    public Commands(String firstCommand, String secondCommand, String thirdCommand, String fourthCommand, ArrayList<String> nonListedCommands){
        this(command, secondCommand, thirdCommand, fourthCommand, "sprint");
    }


    public Commands(String firstCommand, String secondCommand, String thirdCommand, String fourthCommand, ArrayList<String> nonListedCommands){
        this.command = firstCommand;
        this.secondCommand = secondCommand;
        this.thirdCommand = thirdCommand;
        this.fourthCommand = fourthCommand;
        this.nonListedCommands = nonListedCommands;

        //more code will be added here after creation of CommandsList
    }

    public void setCommand(String command) {this.command = command;} //setter function
    public String getCommand() {
        return command;
    } //getter function

    public void setSecondCommand(String secondCommand) {this.secondCommand = secondCommand;} //setter function
    public String getSecondCommand() {
        return secondCommand;
    } //getter function

    public void setThirdCommand(String thirdCommand) {this.thirdCommand = thirdCommand;} //setter function
    public String getThirdCommand() {
        return thirdCommand;
    } //getter function

    public void setFourthCommand(String fourthCommand) {this.fourthCommand = fourthCommand;} //setter function
    public String getFourthCommand() {
        return fourthCommand;
    } //getter function

    //returns any unlisted commands
    public ArrayList<String> getNonListedCommands() {
        return getNonListedCommands();
    }


    //checks if the command is valid
    public boolean isValid() {
        //more code to come
        return (command == null);
    }

    //checks if the direction is provided
    public boolean hasSecondCommand() {
        return !secondCommand.equals("");
    }

    //checks if the player has an item
    public boolean hasThirdCommand(){
        return !thirdCommand.equals("");
    }

    //checks if there is an enemy
    public boolean hasFourthCommand() {
        return !fourthCommand.equals("");
    }

    //checks if the user entered any unlisted commands
    public boolean hasNonListedCommand() {
        return nonListedCommands.size() > 0;
    }


}

/*


// Commands class
class Commands{

    private String command;
    private String item;
    private String direction;
    private String character;  //this is the character the player chooses to play as
    private String enemy;      //this can represent all the monsters
    // this is so we can add more commands later and don't have to worry about the type of command while testing
    ArrayList<String> nonListedCommands = new ArrayList<String>();

    // telescoping Constructors
    public Commands(){
        this("No command entered");
    }

    public Command(String command){
        this(command,"north");
    }

    public Commands(String command, String direction){
        this(command, direction, "player1");
    }

    public Commands(String command, String direction, String character){
        this(command, direction, character, "lantern");
    }

    public Commands(String command, String direction, String character, String item){
        this(command, direction, character, item, "dracula");
    }

    public Commands(String command, String direction, String character, String item, String enemy){
        this(command, direction, character, item, enemy, "sprint");
    }


    public Commands(String command, String direction, String character, String item, String enemy, ArrayList<String> nonListedCommands){
        this.command = command;
        this.direction = direction;
        this.character = character;
        this.item = item;
        this.enemy = enemy;
        this.nonListedCommands = nonListedCommands;

        //more code will be added here after creation of CommandsList
		if(direction.equals("east"))
			this.direction = "East";
		if(direction.equals("west"))
			this.direction = "West";
		if(direction.equals("south"))
			this.direction = "South";
		if(direction.equals("north"))
			this.direction = "North";
		if(direction.equals("up"))
		    this.direction = "Up";
		if(direction.equals("down"))
		    this.direction = "Down";
    }


    public void setCommand(String command) {this.command = command;} //setter function
    public String getCommand() {
        return command;
    } //getter function

    public void setDirection(String direction) {this.direction = direction;} //setter function
    public String getDirection() {
        return direction;
    } //getter function

    public void setItem(String item) {this.item = item;} //setter function
    public String getItem() {
        return item;
    } //getter function

    public void setCommand(String command) {this.command = command;} //setter function
    public String getCommand() {
        return command;
    } //getter function

    //returns any unlisted commands
    public ArrayList<String> getNonListedCommands() {
        return getNonListedCommands();
    }


    //checks if the command is valid
    public boolean isValid() {
        //more code to come
        return (command == null);
    }

    //checks if the direction is provided
    public boolean hasDirection() {
        return !direction.equals("");
    }

    //checks if the player has an item
    public boolean hasItem(){
        return !item.equals("");
    }

    //checks if there is an enemy
    public boolean hasEnemy() {
        return !enemy.equals("");
    }

    //checks if the user entered any unlisted commands
    public boolean hasNonListedCommand() {
        return nonListedCommands.size() > 0;
    }


}

 */