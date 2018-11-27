
public class EnigmaMachine {

	//defining a new plugboard, a reflector and an array consisting of 3 chosen rotors
	protected Plugboard plugboard1;
	protected Reflector reflector;
	BasicRotor[] bRotors = new BasicRotor[3];

	//constructor method which creates the new plugboard object
	public EnigmaMachine() {
		plugboard1 = new Plugboard();
	}


	//method to create a plug from the given parameters
	public void addPlug(char ch1, char ch2) throws Exception {
		plugboard1.addPlug(ch1, ch2);
	}


	//method to clear the plugboard
	public void clearPlugboard() {
		plugboard1.clear();
	}


	//method to add a rotor chosen from the class that calls it to the Enigma machine
	public void addRotor(BasicRotor brotor, int slot) throws Exception {
		bRotors[slot] = brotor;
	}


	//method to return the rotor specified
	public BasicRotor getRotor(int slot) throws Exception {
		return bRotors[slot];
	}


	//method to add the reflector chosen to the Enigma Machine
	public void addReflector(Reflector r1) throws Exception {
		reflector = r1;
	}


	//method to return the reflector used
	public Reflector getReflector() {
		return reflector;
	}


	//method to set the position of the rotor to the index specified
	public void setPosition(int slot, int position) throws Exception {
		bRotors[slot].setPosition(position);
	}


	//method to convert the character specified to an integer(0-25)
	public int ChToInt(char c) {
        int num = (Character.getNumericValue(c) -10);
        return num;
    }


    //method to convert the integer specified to a character
    public String IntToCh(int num) {
        int i = num+1;
		return i > 0 && i < 27 ? String.valueOf((char)(i + 64)) : null;
    }


    /* method that first takes the passed character and converts it to its integer
     * value, then passing the integer through the different rotors and the reflector
     * and back, changing the integer to its character value and rotating the rotors in the end.
     */
	public char encodeLetter(char letter) throws Exception {
		letter = plugboard1.substitute(letter);
		Integer pos = ChToInt(letter);
		pos = bRotors[0].substitute(pos);
		pos = bRotors[1].substitute(pos);
        pos = bRotors[2].substitute(pos);
        pos = reflector.substitute(pos);
        pos = bRotors[2].substituteBack(pos);
        pos = bRotors[1].substituteBack(pos);
        pos = bRotors[0].substituteBack(pos);
        char c = IntToCh(pos).charAt(0);

        letter = plugboard1.substitute(c);
        System.out.println("Resulting character: " + letter);
        bRotors[0].rotate();
        return letter;
	}


	//tests
	public void start() throws Exception {
		/*
		//test 1
    		this.addPlug('A', 'M');
        this.addPlug('G', 'L');
        this.addPlug('E', 'T');

        this.addRotor(new BasicRotor("I"), 0);
        this.addRotor(new BasicRotor("II"), 1);
        this.addRotor(new BasicRotor("III"), 2);

        this.setPosition(0, 6);
        this.setPosition(1, 12);
        this.setPosition(2, 5);

        this.addReflector(new Reflector("ReflectorI"));

        this.encodeLetter('G');
        this.encodeLetter('F');
        this.encodeLetter('W');
        this.encodeLetter('I');
        this.encodeLetter('Q');
        this.encodeLetter('H');

        System.out.println();
		clearPlugboard();
		*/

	    	/*
	    	//test 2
	    	this.addPlug('B','C');
        this.addPlug('R','I');
        this.addPlug('S','M');
        this.addPlug('A','F');

        this.addRotor(new BasicRotor("IV"),0);
        this.addRotor(new BasicRotor("V"),1);
        this.addRotor(new BasicRotor("II"),2);

        this.setPosition(0, 23);
        this.setPosition(1, 4);
        this.setPosition(2, 9);

        this.addReflector(new Reflector("ReflectorII"));

        this.encodeLetter('G');
        this.encodeLetter('A');
        this.encodeLetter('C');
        this.encodeLetter('I');
        this.encodeLetter('G');

        clearPlugboard();
        */
		
		
		//test 3
		this.addPlug('Q','F');

		TurnoverRotor I = new TurnoverRotor("I");
		TurnoverRotor II = new TurnoverRotor("II");
		TurnoverRotor III = new TurnoverRotor("III");

		I.setNextRotor(II);
		II.setNextRotor(III);

		this.addRotor(I, 0);
		this.setPosition(0, 23);
		this.addRotor(II, 1);
		this.setPosition(1, 11);
		this.addRotor(III, 2);
		this.setPosition(2, 7);

		this.addReflector(new Reflector("ReflectorI"));
		

    }
}
