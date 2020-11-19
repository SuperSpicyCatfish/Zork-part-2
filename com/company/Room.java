//
//  AUTHORS:        Julia and Tran
//  CLASS:          CPSC - 233j
//  TEACHER:        Professor McCarthy
//  TIME:           T-Th 8:00am-9:45am
//  DUE:            November 21, 2020
//
package com.company;
import com.company.*;
import java.util.ArrayList;


//
// movement system
// design a map - each room has items, characters
// fighting system
//



//=========================================================================
// Direction enum 
//=========================================================================
enum Direction { 
    NORTH, // 0
    SOUTH, // 1
    EAST,  // 2
    WEST,  // 3
    UP,	   // 4
    DOWN;  // 5
    public static final int noExit = -1;
};

//=====================================================================
// Room class
//=====================================================================
class Room {
    private String name;
    private String description;
    private ArrayList<Items> aItemsRoom = new ArrayList<Items>(); // Items in a room


    private int north, south, west, east, up, down; // ** new ** 
    

    // Start of Telescoping Constructors
    public Room(){
        this("NO ROOM NAME");
    }

    public Room(String name){
        this(name,"NO ROOM DESCRIPTION");
    }

    public Room(String name,String description){
        this(name,description,Direction.noExit);
    }

    public Room(String name, String description,int n){
        this(name,description,n,Direction.noExit);
    }

    public Room(String name, String description,int n, int s){
        this(name,description,n,s,Direction.noExit);
    }

    public Room(String name,String description,int n, int s, int w){
        this(name,description,n,s,w,Direction.noExit);
    }

    public Room(String name, String description, int n, int s, int w, int e) {
        
    }
    public Room(String name, String description, int n, int s, int w, int e, int up){

    }

    public Room(String name, String description, int n, int s, int w, int e, int up, int down){
        this.name = name;
        this.description = description;

        this.north = n;
        this.south = s;
        this.west = w;
        this.east = e;
        // ** new ** 
        this.up = up;
        this.down = down;
    }

    // End of Telescoping Constructors

    public String getName() {           // getter function
        return name;
    }

    public void setName(String aName) { // setter function
        this.name = name;
    }

    public String getDescription() {    // getter function
        return description;
    }

    public void setDescription(String aDescription) {  //setter function
        this.description = description;
    }
    public int getN() {                 // getter function  
        return north;
    }

    public void setN(int N) {           // setter function
        this.north = N;
    }

    // s
    public int getS() {                 // getter function
        return south;
    }
    public void setS(int S) {           // setter function
        this.south = S;
    }

    // e
    public int getE() {                 // getter function
        return east;
    }
    public void setE(int E) {           // setter function
        this.east = E;
    }

    // w
    public int getW() {                 // getter function
        return west;
    }
    public void setW(int W) {           // setter function
        this.west = W;
    }

    // up
    public int getUp(){					// getter function
    	return up;                      // ** new **
    }

    public void setUp(int up){			// setter function
    	this.up = up;                   // ** new **
    }

    // down
    public int getDown(){				// getter function
    	return down;                    // ** new **
    }

    public void setDown(int down){		// setter function
    	this.down = down;               // ** new **
    }



    public String toString(){ // toString for the Rooms
        String temp = ("\n"+getName() + ". " + getDescription() + ".\n");
        if(getN() >= 0){
            temp += "There is an exit north\n";
        }
        if(getS() >= 0){
            temp += "There is an exit south\n";
        }
        if(getE() >= 0){
            temp += "There is an exit east\n";
        }
        if(getW() >= 0){
            temp += "There is an exit west\n";
        }
        if(getUp() >= 0){
        	temp += "There is an exit up above\n";             // ** new **
        }
        if(getDown() >= 0){
        	temp += "There is an exit down below\n";           // ** new **
        }
        printItems(); // will print out the items in the room before the description and name of a room
        return temp;
}

    // ***************** UNSURE ***********************
    public Items getItems(int itemIndex){ // returns a specific item??
        return aItemsRoom.get(itemIndex);
    }

    public void printItems(){ // the list of Items a Character can pick up or interact with in a Room
        if(!aItemsRoom.isEmpty()){ // if the room has items, list them out
            System.out.println("Items in Room:");
            for(int i = 0; i < aItemsRoom.size(); ++i){             
                System.out.println("[Index:" + i + "]" + " " + aItemsRoom.get(i));
            }
        }
        else{
            System.out.println("There are no Items in the Room");
        }
    }

    public void addItems(Items someItem){ // adding Items to a Room, if a user drops an Item, add it to the Room
        aItemsRoom.add(someItem);
    }

    public void removeItems(int index){
        aItemsRoom.remove(index); // removes an item from a room IE: When a character takes an item from a room
    }

 
 
    public boolean isConnected(int numberConnection){  // returns true if the current room is connected to the given numberConnection
        boolean found = false;                  

        if(this.getN() == numberConnection){
            found = true;
        } 
        else if (this.getS() == numberConnection){
            found = true;
        }
        else if(this.getE() == numberConnection){
            found = true;
        }
        else if(this.getW() == numberConnection){
            found = true;
        }
        else if(this.getUp() == numberConnection){              // ** new **    
            found = true;
        }
        else if(this.getDown() == numberConnection){            // ** new **
            found = true;
        }

        return found;
    }

    

}

//=====================================================================
// Game class 
//=====================================================================
class Game {
    private Characters playerChar;  // main character
    private ArrayList<Room> map;    // map of zork
    private int score;              // the player's score
    private int moves;              // how many times the player moved

    // ************************************************
    // ^^                                            ^^
    // Everytime a player moves, increment a counter.
    // We need to keep track of how many moves a player
    // took in order to win
    // ************************************************


    public Game() {
        playerChar = new Characters("Player","A scrawny character with tatterd clothes",20);
        score = 0;
        // ^^ main character

        // ITEMS START
        Weapons wSword = new Weapons("Wood sword","A flimsy wooden sword",3,true);
        Consumables waterJug = new Consumables("Water jug","A portable jug that has some water in it",true,5);
        Treasures gCoin = new Treasures("Gold coin","A single gold coin with a skull on one side",true,3);
        Weapons sSword = new Weapons("Steel sword","A solid blade with a sharp edge",8,true);
        Treasures rRuby = new Treasures("Red ruby","A shiny red ruby",true,5);
        NonConsumables ball = new NonConsumables("Bouncy ball","A small ball that has a nice bounce to it",true,"It makes you happy");
        NonConsumables candle = new NonConsumables("Wax candle","A thin wax candle with a burnt end",true,"You stare at it");
        NonConsumables skull = new NonConsumables("Human skull","A dusty skull",true,"You feel a chill go down your spine");
        NonConsumables book = new NonConsumables("Worn book","A old and worn book with writing that you can not understand",true,"You stare at the letters");
        Consumables breadLoaf = new Consumables("Bread loaf","A stale loaf of bread",true,2);
        Treasures bSapphire  = new Treasures("Blue Sapphire ","A shiny blue sapphire ",true,5);
        NonConsumables mClaw = new NonConsumables("Monster claw","A bloody claw torn from a monster",true,"You prick your finger on the tip");
        Treasures bCoins = new Treasures("Bag of gold coins","A small bag filled with gold coins",true,30);
        // Weapons for monsters
        Weapons wPlank = new Weapons("Wooden plank","A large wooden plank covered in splinters",5);
        Weapons donutHoler = new Weapons("Donut Holer", "A hollow metal pipe, perfect for making anything into a donut",3);
        Weapons sFangs = new Weapons("Spider fangs","Poisonous fangs that pack a punch",20);
        // ITEMS END

        // CHARACTERS - MONSTERS - START
        Characters monster1 = new Characters("Tall Ogre", "A lanky creature holding a large wooden plank",20);
        Characters monster2 = new Characters("Gnome", "A small gnome with a donut holer",10);
        Characters monster3 = new Characters("Spider","A smol spider with giant fangs",2);
        // CHARACTERS - MONSTERS - END


        // Creating the map
        this.map = new ArrayList<Room>(); 
                                     //      N        S       E       W     
        map.add(new Room("Room1", "Starting Room", 1, Direction.noExit, Direction.noExit, Direction.noExit));
        map.add(new Room("Room2", "no description", Direction.noExit, 1, 2, 7));
        map.add(new Room("Room3", "no description",  Direction.noExit,3,Direction.noExit, 2));
        map.add(new Room("Room4", "no description",  3,4,Direction.noExit, Direction.noExit));
        map.add(new Room("Room5", "no description",  Direction.noExit,Direction.noExit,4, 5));
        map.add(new Room("Room6", "no description",  6,5,Direction.noExit, Direction.noExit));
        map.add(new Room("Room7", "no description",  Direction.noExit,6,7, 8));
        map.add(new Room("Room8", "no description",  8,9,Direction.noExit, Direction.noExit));
        map.add(new Room("Room9", "no description",  9,12,11,10));
        map.add(new Room("Room10", "no description",  Direction.noExit,Direction.noExit,Direction.noExit,10));
        map.add(new Room("Room11", "no description",  Direction.noExit,Direction.noExit,11, Direction.noExit));
        map.add(new Room("Room12", "no description",  12,Direction.noExit,Direction.noExit, Direction.noExit));

        // setting locations for characters
        playerChar.setRoom(map.get(0)); // sets the player's location to the starting room
        monster3.setRoom(map.get(3));   // sets the spider's location
        monster2.setRoom(map.get(9));   // sets the gnome's location
        monster1.setRoom(map.get(11));  // sets the tall orge's location

        // setting locations for items
        (map.get(0)).addItems(wSword);
        (map.get(1)).addItems(waterJug);
        (map.get(2)).addItems(gCoin);
        (map.get(4)).addItems(sSword);
        (map.get(5)).addItems(rRuby);
        (map.get(6)).addItems(ball);
        (map.get(7)).addItems(candle);
        (map.get(7)).addItems(skull);
        (map.get(7)).addItems(book);
        (map.get(8)).addItems(breadLoaf);
        (map.get(9)).addItems(bSapphire);
        (map.get(11)).addItems(bCoins);

        // giving monsters weapons
        monster1.addWeapon(wPlank);
        monster2.addWeapon(donutHoler);
        monster3.addWeapon(sFangs);

        // ***************************************
        // START GAME HERE
        // ***************************************

        // *** Testing if items were in rooms ****
        // System.out.println(playerChar.getRoom());
        // playerChar.setRoom(map.get(1));
        // System.out.println(playerChar.getRoom());

    }



    public ArrayList getMap() {         // returns the map
        return map;
    }

    void setMap(ArrayList<Room> theMap) { // sets the map 
        map = theMap;
    }

    public Characters getPlayer() { // returns the player character
        return playerChar;
    }

    public void setPlayer(Characters p) {   // sets the player character
        playerChar = p;
    }

    public void moveCharacterTo(Characters p, Room aRoom)  // moves character
     {
        p.setRoom(aRoom);
    }

    public void addItemToRoom(int roomIndex,Items someItem){ // for adding items to a room
        Room targetRoom = map.get(roomIndex);
        targetRoom.addItems(someItem);

    }

    // *********************************************************
    // The compiler thinks this function uses unsafe operations
    // *********************************************************
    public void updateScore(){ // **** NEEDS TO BE TESTED **** 
        ArrayList<Items> tempA = playerChar.getCharsInventory();
        Items tempItem;
        int tempScore = 0;
        if(!tempA.isEmpty()){ // if the player's inventory is not empty
            for(int i = 0; i < tempA.size(); ++i){
                tempItem = tempA.get(i);
                if(tempItem instanceof Treasures){
                    tempScore += ((Treasures)tempItem).getValue(); // add up all the treasure items value
                }
            }
         }
         // if the player's inventory is empty, score is 0
        score = tempScore; // set the new score
    }


        // From my understanding of the Room class, in each possible direction there is a number 
        // and that number does not corresponse to the index of the Room it is attached too but simply a numbered
        // connection. Such that, if you wanted to connect two Rooms, they must both share a numbered connection
        // ex. of connected Rooms:
        //                                      NORTH               SOUTH               EAST             WEST
        //  map.add(new Room("room3", "Test3",  3,                  Direction.noExit, Direction.noExit, Direction.noExit));
        //  map.add(new Room("room4", "Test4",  Direction.noExit,   3,                Direction.noExit, Direction.noExit));
        // room4 is to the North of room3. 
        // room3 is to the south of room4.
        //
        // we need to be careful with room connections, we can not have multiple room connections.
        // what i mean is that if 3 rooms are all connected, they can not be connected like this: 
        // room1: N = 1
        // room2: S = 1
        // room3: E = 1
        // because it is unclear which room is connected to each.
        // 
        // i do like how flexible the room connections are
    



  
   
    public Room findOtherRoom(int numberConnection){
        Room currentRoom = playerChar.getRoom(); // gets the current location

        if(numberConnection == -1){ // -1 means no exit in this direction
            System.out.println("No room connected to this exit");
        }
        else{   // if there is a exit in this direction
            for(int i = 0; i < map.size(); ++i){ // go through each room in the arraylist and find the connected room

                if(map.get(i) == currentRoom){
                    // do nothing, because rooms can not loop back to themselves
                }
                else if(map.get(i).isConnected(numberConnection)){ 
                    return map.get(i); // this means we found the room connection
                }                
            } 
        

            }
            return (new Room()); // else return a blank room, this should never run!!!
    }

} // End of Room
