package fixtures;

import fixtures.Room;//
import fixtures.Fixture;//  

public class Room extends Fixture {
     Room exits[]=new Room[4];
     public Room (String name, String shortDesc, String longDesc) {
     super(name, shortDesc, longDesc);
     }
	public Room[] getExits() {
		return exits;
	}
	
     public Room  getExit(String Direction) {
     int index=0;
     switch(Direction) {
     case "NORTH":
    	 index=0;
    	 break;
    	 
     case "SOUTH":
    	 index=1;
    	 break;
     case "WEST":
    	 index=2;
    	 break;
     case "EAST":
    	 index=3;
    	 break;
     }
     if (index >= this.exits.length || this.exits[index] == null) {
			System.out.println(" No room ");
			return this;
     }
		return this.exits[index];
     }
     public void setExits(Room[] exits) {
 		this.exits = exits;
 	}
     public void setExits(Room exit, int index) {
 		this.exits[index] = exit;
 	}
	}
