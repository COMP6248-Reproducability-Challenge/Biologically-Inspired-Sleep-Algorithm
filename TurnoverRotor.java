/**
 * c
 */
public class TurnoverRotor extends BasicRotor {

    //defining two variables for the position of the rotor and the next rotor
    protected int turnoverPosition;
    protected BasicRotor nextRotor;

    //constructor method which sets the position of the rotors
    public TurnoverRotor(String name) throws Exception {
        super.initialise(name);  //calls the initialise method from the BasicRotor class

        if (name.equals("I")) {
            turnoverPosition = 24;
        } else if (name.equals("II")) {
            turnoverPosition = 12;
        } else if (name.equals("III")) {
            turnoverPosition = 3;
        } else if (name.equals("IV")) {
            turnoverPosition = 17;
        } else if (name.equals("V")) {
            turnoverPosition = 7;
        }
    }

    //method to specify the next rotor
    public void setNextRotor(BasicRotor bRotor) throws Exception {
        nextRotor = bRotor;
    }

    //method to perform rotation
    public void rotate() throws Exception {

        setPosition((getPosition()+1)%26);  //making sure the position remains between 0 and 25
        if(position == turnoverPosition) {
            nextRotor.rotate();  //calling the rotate method
        }
    }


}
