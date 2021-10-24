package model;

public class RoomModel extends Model {
	private int roomID;
	private int maxOfSeat;
	
	public RoomModel() {
		// TODO Auto-generated constructor stub
	}

	public RoomModel(int roomID, int maxOfSeat) {
		super();
		this.roomID = roomID;
		this.maxOfSeat = maxOfSeat;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getMaxOfSeat() {
		return maxOfSeat;
	}

	public void setMaxOfSeat(int maxOfSeat) {
		this.maxOfSeat = maxOfSeat;
	}
}
