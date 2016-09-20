package dto;

public class Flight extends Entity {
	
	private String date;
	private int seats;
	private int cost;
	private byte upCost;
	
	public Flight(){
		
	}
	
	public Flight(int id, String date, int seats, int cost, byte upCost){
		
		super(id);
		this.date = date;
		this.seats = seats;
		this.cost = cost;
		this.upCost = upCost;
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
