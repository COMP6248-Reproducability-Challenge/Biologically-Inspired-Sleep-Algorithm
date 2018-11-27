import java.io.IOException;

//creating a Main class
public class Main {
	//main method
	public static void main(String[] args) throws IOException, Exception {
		/*
		//creating a new plug
		Plugboard testPB = new Plugboard();
		System.out.println(testPB.addPlug('A', 'Z'));
		*/

		/*
		//checking either of the first two tests
		EnigmaMachine testMachine1 = new EnigmaMachine();
		testMachine1.start();
		*/

		
		//checking for test3
		EnigmaFile testFile = new EnigmaFile();
		testFile.setup();
		testFile.readFile();
		


		//tests for the Bombe
		//Bombe testBombe = new Bombe();
		//testBombe.challenge1();
		//testBombe.challenge2();
		//testBombe.challenge3();

		/* Extension: add a command line interface you your machine to allow the user to
		 * specify the plugs in the machine and the type and initial positions of the rotors.
		 */
/*
		EnigmaMachine testMachine2 = new EnigmaMachine();
		Toolbox myToolbox = new Toolbox();
		System.out.println("Please enter the first plug: ");
		String s1 = myToolbox.readStringFromCmd();
		s1.toUpperCase();
		char c1 = s1.charAt(0);

		System.out.println("Please enter the second plug: ");
		String s2 = myToolbox.readStringFromCmd();
		s2.toUpperCase();
		char c2 = s2.charAt(0);

		testMachine2.addPlug(c1, c2);

		System.out.println("Please enter the rotor type: ");
		String s3 = myToolbox.readStringFromCmd();
		String[] rotorTypes = {"I", "II", "III", "IV", "V"};
		if (Arrays.asList(rotorTypes).contains(s3)) {
			testMachine2.addRotor(new BasicRotor(s3), 0);
		} else {
			System.out.println("Enter a type from I - V");
		}

		System.out.println("Please enter the initial position");
		Integer i1 = myToolbox.readIntegerFromCmd();
		if (i1 >= 26 && i1 < 0) {
			System.out.println("Invalid input. Enter an integer between 0 and 25");
		} else {
			testMachine2.setPosition(0, i1);

		}
*/

	}
}
