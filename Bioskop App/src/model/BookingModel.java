package model;

public class BookingModel extends Model {
	private int bookingID;
	private int seatID;
	private int screeningID;
	private int customerID;
	
	public BookingModel() {
		// TODO Auto-generated constructor stub
	}
	
	public BookingModel(int bookingID, int seatID, int screeningID, int customerID) {
		super();
		this.bookingID = bookingID;
		this.seatID = seatID;
		this.screeningID = screeningID;
		this.customerID = customerID;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getSeatID() {
		return seatID;
	}

	public void setSeatID(int seatID) {
		this.seatID = seatID;
	}

	public int getScreeningID() {
		return screeningID;
	}

	public void setScreeningID(int screeningID) {
		this.screeningID = screeningID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}
