package application.model;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Mission {

	private String name;
	private String operator;
	private int year;
	private String type;
	private Spacecraft[] craft = new Spacecraft[5];
	private Astronaut[] crew = new Astronaut[10];
	private int i = 0;
	private int j = 0;
	
	public Mission(String name) {
		loadMission(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public String getOperator() {
		return this.operator;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void addSpacecraft(Spacecraft craft) {
		this.craft[i] = craft;
		i++;
	}
	
	public void addCrewMember(Astronaut crew) {
		this.crew[j] = crew;
		j++;
	}
	
	public void loadMission(String mission) {
		try {
			File file = new File("src/data/Apollo" + mission + ".csv");
			
			if (!file.exists()) {
				System.out.println("No File!");
			}
			
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNextLine()) {
				String[] thisLine = scanner.nextLine().split(",");
				
				switch (thisLine[0]) {
					case "Mission": 
						this.name = thisLine[1];
						this.operator = thisLine[2];
						this.year = Integer.valueOf(thisLine[3]);
						this.type = thisLine[4];
						break;
					case "Crew": 
						Astronaut astronaut = new Astronaut(thisLine[2],thisLine[1]);
						addCrewMember(astronaut);
						break;
					case "Spacecraft": 
						Spacecraft spacecraft = new Spacecraft(thisLine[1],thisLine[2],Integer.valueOf(thisLine[3]));
						addSpacecraft(spacecraft);
						break;
					default: 
						System.out.println("Unknown type...");
				}
			}
			
			scanner.close();
		} catch (FileNotFoundException error) {
			System.out.println(error);
		}
	};
	
	public String getCrew(int position) {
		return "" + this.crew[position];
	}
	
	public String getCraft(int position) {
		return "" + this.craft[position];
	}
	
	public String toString() {
		String str = "";
		
		str = str + String.format("%s (%s)\n\t%s, %d\n\tSpacecrafts:\n", this.name, this.operator, this.type, this.year);
		
		for (Spacecraft craft : this.craft) {
			if (craft == null) break;
			str = str + craft;
		}
		
		str = str + String.format("\tCrew:\n");
		
		for (Astronaut crew : this.crew) {
			if (crew == null) break;
			str = str + crew;
		}
		
		return str;
	}
}