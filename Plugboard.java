import java.util.*;

//creating a class for the plugboard
public class Plugboard {
	
	ArrayList<Plug> plugList = new ArrayList<Plug>();  //creating an arraylist to hold the plugs

	//method to create plugs by the ends specified in the main method
	public boolean addPlug(char end1, char end2) throws Exception {
		
		Plug newplug = new Plug(end1, end2);
		Boolean clash = false;

		//to check if there is a clash between any of the plugs
		for (Plug p : plugList) {
			if (newplug.clashesWith(p)) {
				clash = true;
				break;  //exits if there is a clash
			}
		}
		if (clash == false) {
			plugList.add(newplug);  //adds the plug to the arraylist if there is no clash
		}
		return clash;
	}


	//method to return the number of plugs
	public int getNumPlugs() {
		
		int countplug = 0;  //counter for the number of plugs

		//to increase the counter if a plug exists in a particular position of plugList
		for(int p = 0; p < plugList.size(); p++) {
			if (plugList.get(p).equals(null)) {
				;
			}
			else {
				countplug++;
			}	
		}
		System.out.println("The number of plugs is: " + countplug);
		return countplug;
	}


	//method to wipe the plugboard when called
	public void clear() {
		plugList.clear();
	}


	//method to return an encoded character if it is part of a plug
	public char substitute(char letterIn) throws Exception {
		for(Plug p: plugList) {
			if (p.getEnd1() == letterIn || p.getEnd2() == letterIn) {
				return p.encode(letterIn);
			}
		}

		return letterIn;
	}
}
