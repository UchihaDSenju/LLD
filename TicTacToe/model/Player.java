package model;
public class Player{
	private String name;
	private String marker;
	public Player(String name, String marker){
		this.name = name;
		this.marker = " " + marker.toUpperCase() + " ";
	}
	
	public Player(){}
	
	public String getMarker(){
		return this.marker;
	}

	public String getName() {
		return name;
	}
}
