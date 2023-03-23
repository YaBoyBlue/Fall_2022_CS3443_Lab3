package application.model;

public class Astronaut {

	private String name;
	private String position;
	
	public Astronaut(String name, String position) {
		this.name = name;
		this.position = position;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public String toString() {
		return /*String.format("\t\t%s : %s\n", this.position, */this.name/*)*/;
	}
}