package model;

public class Cell{
	private String marker;
	
	public Cell(){
		this.marker = " . ";
	}

	public void setMarker(String marker){
		this.marker = marker;
	}
	
	public String getMarker(){
		return this.marker;
	}

	@Override
	public String toString() {
		return marker;
	}

	
}