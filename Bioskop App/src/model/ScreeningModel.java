package model;

import java.sql.Date;

public class ScreeningModel extends Model {
	private int screeningID;
	private int filmID;
	private int roomID;
	private Date screeningDate;
	private int price;
	
	public ScreeningModel() {
		// TODO Auto-generated constructor stub
	}

	public ScreeningModel(int screeningID, int filmID, int roomID, Date screeningDate, int price) {
		super();
		this.screeningID = screeningID;
		this.filmID = filmID;
		this.roomID = roomID;
		this.screeningDate = screeningDate;
		this.price = price;
	}

	public int getScreeningID() {
		return screeningID;
	}

	public void setScreeningID(int screeningID) {
		this.screeningID = screeningID;
	}

	public int getFilmID() {
		return filmID;
	}

	public void setFilmID(int filmID) {
		this.filmID = filmID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public Date getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(Date screeningDate) {
		this.screeningDate = screeningDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}