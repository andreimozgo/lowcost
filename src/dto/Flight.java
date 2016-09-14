package dto;

public class Flight extends Entity {
	
	private int id;
	private String date;
	private int seats;
	private int cost;
	private byte upCost;
	
	public Flight(){
		
	}
	
	public Flight(int id, String date, int seats, int cost, byte upCost){
		
		this.id = id;
		this.date = date;
		this.seats = seats;
		this.cost = cost;
		this.upCost = upCost;
	}
	
	public int getId(){
		return id;
	}
	
	public String getDate(){
		return date;
	}
	
	public int getSeats(){
		return seats;
	}

	public byte getUpCost(){
		return upCost;
	}
	
	public String toString(){
		return date+seats+cost;
	}
}
