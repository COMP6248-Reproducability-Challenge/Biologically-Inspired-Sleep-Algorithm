//creating a BasicRotor class which is a subclass of the Rotor class
public class BasicRotor extends Rotor {

	//constructor method
	public BasicRotor() {

	}


	//constructor method that takes a string as a parameter
	public BasicRotor(String type) {
		this.initialise(type);
	}


	//method to specify the type of basic rotor
	public void initialise(String type) {
		if (type.equals("I")) {
			mapping = new Integer[] { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9};
		}
		else if (type.equals("II")) {
			mapping = new Integer[] { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
		}
		else if (type.equals("III")) {
			mapping = new Integer[] { 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };
		}
		else if (type.equals("IV")) {
			mapping = new Integer[] {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };
		}
		else if (type.equals("V")) {
			mapping = new Integer[] { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
		}
		else {
			System.out.println("Invalid input. Only enter I-V");
		}
	}
	

	/* method that takes an integer representing a letter and returns an integer
	 * represented by the positioning in the mapping
	 */
	public int substitute(int num1) throws Exception {
		int mapPosition = num1 - getPosition();

		if (mapPosition < 0) {
			mapPosition += 26;
		}

		num1 = mapping[mapPosition];
		
		int subIn = num1 + getPosition();
        if(subIn >= 26){
            subIn -= 26;
        }
        return subIn;
	}
	

	//method that uses inverse mapping to change the integer passed to it
	public int substituteBack(int num2) throws Exception {
		Integer[] inverseMapping = new Integer[26];
		
		for (int i = 0; i < 26; i++) {
			inverseMapping[mapping[i]] = i;
		}
		
		Integer mapPosition = num2 - getPosition();
		if (mapPosition < 0) {
			mapPosition += 26;
		}
		num2 = inverseMapping[mapPosition];
		
		Integer subBack = num2 + getPosition();
        if(subBack >= 26){
            subBack -= 26;
        }
        return subBack;
		
	}
	

	//method to rotate the position in the rotor one by one
	public void rotate() throws Exception {
		if (position == 25) {
			position = 0;
		}
		else {
			position += 1;
		}
	}
}
