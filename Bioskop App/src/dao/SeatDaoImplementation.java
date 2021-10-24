package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SeatModel;
import utility.DatabaseConnection;

public class SeatDaoImplementation implements DaoInterfaces<SeatModel> {
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(SeatModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into seat (room_seat_id) values (?)";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getRoomSeatID());
		int result = prepared.executeUpdate();
		return result;
	}

	@Override
	public void delete(SeatModel model) throws SQLException {
    // TODO Auto-generated method stub
		String query = "delete from seat where seat_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getSeatID());
		prepared.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from seat where seat_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

	@Override
	public void update(SeatModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update seat set room_seat_id = ? where seat_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getRoomSeatID());
		prepared.setInt(2, model.getSeatID());
		prepared.executeUpdate();
	}

	@Override
	public SeatModel getById(SeatModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from seat where seat_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getSeatID());
		
		ResultSet result = prepared.executeQuery();
		
		SeatModel seatModel = new SeatModel();
		
		while (result.next()) {
			seatModel.setSeatID(result.getInt("seat_id"));
			seatModel.setRoomSeatID(result.getInt("room_seat_id"));
		}
		
		return seatModel;
	}

	@Override
	public SeatModel getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from seat where seat_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, id);
		
		ResultSet result = prepared.executeQuery();
		
		SeatModel seatModel = new SeatModel();
		
		while (result.next()) {
			seatModel.setSeatID(result.getInt("seat_id"));
			seatModel.setRoomSeatID(result.getInt("room_seat_id"));
		}
		
		return seatModel;
	}

	@Override
	public List<SeatModel> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from seat";
		PreparedStatement prepared = con.prepareStatement(query);
		ResultSet result = prepared.executeQuery();
		List<SeatModel> listSeat = new ArrayList<SeatModel>();

		while (result.next()) {
			SeatModel seatModel = new SeatModel();
			seatModel.setSeatID(result.getInt("seat_id"));
			seatModel.setRoomSeatID(result.getInt("room_seat_id"));
			listSeat.add(seatModel);
		}

		return listSeat;
	}
}
