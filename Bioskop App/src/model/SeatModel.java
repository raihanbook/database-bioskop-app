package model;

public class SeatModel extends Model {
	private int seatID;
	private int roomSeatID;
	
	public SeatModel() {
		// TODO Auto-generated constructor stub
	}

	public SeatModel(int seatID, int roomSeatID) {
		super();
		this.seatID = seatID;
		this.roomSeatID = roomSeatID;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	public int getRoomSeatID() {
		return roomSeatID;
	}

	public void setRoomSeatID(int roomSeatID) {
		this.roomSeatID = roomSeatID;
	}
}