//creating a Plug class
public class Plug {

	//variables to represent the 2 ends of a plug
	private char end1;
	private char end2;

	//constructor method to create a plug
	public Plug(char end1, char end2) {
		this.end1 = end1;
		this.end2 = end2;
	}


	//method to return one end of a plug
	public char getEnd1() {
		return end1;
	}


	//method to return the other end of the plug
	public char getEnd2() {
		return end2;
	}


	//method to set a character as one end of a plug
	public void setEnd1(char end1) throws Exception {
		this.end1 = end1;
	}


	//method to set a character as the other end of the plug
	public void setEnd2(char end2) throws Exception {
		this.end2 = end2;
	}


	//method to encode a character if it is in a plug or return it as is if it doesn't
	public char encode(char letterIn) throws Exception {
		if (getEnd1() == letterIn) {
			return getEnd2();
		}
		else if (getEnd2() == letterIn) {
			return getEnd1();
		}
		return  letterIn;
	}


	//method to see if a character clashes with any of the plugs
	public Boolean clashesWith(Plug plugin) {
		if ((plugin.getEnd1() == end1) || (plugin.getEnd2() == end2) || (plugin.getEnd1() == end2) || (plugin.getEnd2() == end1)) {
			return true;
		}
		
		return false;
	}
}
