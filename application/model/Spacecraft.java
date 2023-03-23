package application.model;

public class Spacecraft {

	private String name;
	private String type;
	private int number;
	
	public Spacecraft(String name, String type, int number) {
		this.name = name;
		this.type = type;
		this.number = number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String toString() {
		return String.format("%s %s %d", this.type, this.name, this.number);
	}
}
