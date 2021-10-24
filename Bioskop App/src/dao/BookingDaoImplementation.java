package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BookingModel;
import utility.DatabaseConnection;

public class BookingDaoImplementation implements DaoInterfaces<BookingModel> {
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(BookingModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into booking (seat_id, screening_id, customer_id ) values (?,?,?)";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getSeatID());
		prepared.setInt(2, model.getScreeningID());
		prepared.setInt(3, model.getCustomerID());
		int result = prepared.executeUpdate();
		return result;
	}

	@Override
	public void delete(BookingModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from booking where booking_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getBookingID());
		prepared.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from booking where booking_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

	@Override
	public void update(BookingModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update booking set seat_id = ?, screening_id = ?, customer_id = ? where booking_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getSeatID());
		prepared.setInt(2, model.getScreeningID());
		prepared.setInt(3, model.getCustomerID());
		prepared.setInt(4, model.getBookingID());
		prepared.executeUpdate();
	}

	@Override
	public BookingModel getById(BookingModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from booking where booking_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getBookingID());
		
		ResultSet result = prepared.executeQuery();
		
		BookingModel bookingModel = new BookingModel();
		
		while (result.next()) {
			bookingModel.setBookingID(result.getInt("booking_id"));
			bookingModel.setSeatID(result.getInt("seat_id "));
			bookingModel.setScreeningID(result.getInt("screening_id "));
			bookingModel.setCustomerID(result.getInt("customer_id "));
		}
		
		return bookingModel;
	}

	@Override
	public BookingModel getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from booking where booking_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, id);
		
		ResultSet result = prepared.executeQuery();
		
		BookingModel bookingModel = new BookingModel();
		
		while (result.next()) {
			bookingModel.setBookingID(result.getInt("booking_id"));
			bookingModel.setSeatID(result.getInt("seat_id "));
			bookingModel.setScreeningID(result.getInt("screening_id "));
			bookingModel.setCustomerID(result.getInt("customer_id "));
		}
		
		return bookingModel;
	}

	@Override
	public List<BookingModel> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from booking";
		PreparedStatement prepared = con.prepareStatement(query);
		ResultSet result = prepared.executeQuery();
		List<BookingModel> listBooking = new ArrayList<BookingModel>();
		
		while (result.next()) {
			BookingModel bookingModel = new BookingModel();
			bookingModel.setBookingID(result.getInt("booking_id"));
			bookingModel.setSeatID(result.getInt("seat_id "));
			bookingModel.setScreeningID(result.getInt("screening_id "));
			bookingModel.setCustomerID(result.getInt("customer_id "));
			listBooking.add(bookingModel);
		}
		
		return listBooking;
	}
}
