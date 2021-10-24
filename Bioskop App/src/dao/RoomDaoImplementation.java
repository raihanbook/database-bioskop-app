package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RoomModel;
import utility.DatabaseConnection;

public class RoomDaoImplementation implements DaoInterfaces<RoomModel> {
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(RoomModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into room (max_of_seat) values (?)";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getMaxOfSeat());
		int result = prepared.executeUpdate();
		return result;
	}

	@Override
	public void delete(RoomModel model) throws SQLException {
    // TODO Auto-generated method stub
		String query = "delete from room where room_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getRoomID());
		prepared.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from room where room_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

	@Override
	public void update(RoomModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update room set max_of_seat = ? where room_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getMaxOfSeat());
		prepared.setInt(2, model.getRoomID());
		prepared.executeUpdate();
	}

	@Override
	public RoomModel getById(RoomModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from room where room_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getRoomID());
		
		ResultSet result = prepared.executeQuery();
		
		RoomModel roomModel = new RoomModel();
		
		while (result.next()) {
			roomModel.setRoomID(result.getInt("room_id"));
			roomModel.setMaxOfSeat(result.getInt("max_of_seat"));
		}
		
		return roomModel;
	}

	@Override
	public RoomModel getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from room where room_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, id);
		
		ResultSet result = prepared.executeQuery();
		
		RoomModel roomModel = new RoomModel();
		
		while (result.next()) {
			roomModel.setRoomID(result.getInt("room_id"));
			roomModel.setMaxOfSeat(result.getInt("max_of_seat"));
		}
		
		return roomModel;
	}

	@Override
	public List<RoomModel> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from room";
		PreparedStatement prepared = con.prepareStatement(query);
		ResultSet result = prepared.executeQuery();
		List<RoomModel> listRoom = new ArrayList<RoomModel>();

		while (result.next()) {
			RoomModel roomModel = new RoomModel();
			roomModel.setRoomID(result.getInt("room_id"));
			roomModel.setMaxOfSeat(result.getInt("max_of_seat"));
			listRoom.add(roomModel);
		}

		return listRoom;
	}
}