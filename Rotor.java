
public abstract class Rotor {
	
	protected String name;
	protected Integer position;
	protected Integer[] mapping;
	protected Integer rotorsize = 26;
	
	public void setPosition(Integer setpos) {
		position = setpos;
	}
	
	
	public Integer getPosition() {
		return position;
	}
	
	
	public void initialise(String init) {
		
	}
	
	
	public Integer substitute(Integer change) {
		return change;
	}
}
