package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ScreeningModel;
import utility.DatabaseConnection;

public class ScreeningDaoImplementation implements DaoInterfaces<ScreeningModel> {
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(ScreeningModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into screening (film_id, room_id, screening_date, price) values (?,?,?,?)";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getFilmID());
		prepared.setInt(2, model.getRoomID());
		prepared.setDate(3, model.getScreeningDate());
		prepared.setInt(4, model.getPrice());
		int result = prepared.executeUpdate();
		return result;
	}

	@Override
	public void delete(ScreeningModel model) throws SQLException {
    // TODO Auto-generated method stub
		String query = "delete from screening where screening_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getScreeningID());
		prepared.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from screening where screening_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

	@Override
	public void update(ScreeningModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update screening set film_id = ?, room_id = ?, screening_date = ?, price = ? where screening_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getFilmID());
		prepared.setInt(2, model.getRoomID());
		prepared.setDate(3, model.getScreeningDate());
		prepared.setInt(4, model.getPrice());
		prepared.setInt(5, model.getScreeningID());
		prepared.executeUpdate();
	}

	@Override
	public ScreeningModel getById(ScreeningModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from screening where screening_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getScreeningID());
		
		ResultSet result = prepared.executeQuery();
		
		ScreeningModel screeningModel = new ScreeningModel();
		
		while (result.next()) {
			screeningModel.setScreeningID(result.getInt("screening_id"));
			screeningModel.setFilmID(result.getInt("film_id"));
			screeningModel.setRoomID(result.getInt("room_id"));
			screeningModel.setScreeningDate(result.getDate("screening_date"));
			screeningModel.setPrice(result.getInt("price"));
		}
		
		return screeningModel;
	}

	@Override
	public ScreeningModel getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from screening where screening_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, id);
		
		ResultSet result = prepared.executeQuery();
		
		ScreeningModel screeningModel = new ScreeningModel();
		
		while (result.next()) {
			screeningModel.setScreeningID(result.getInt("screening_id"));
			screeningModel.setFilmID(result.getInt("film_id"));
			screeningModel.setRoomID(result.getInt("room_id"));
			screeningModel.setScreeningDate(result.getDate("screening_date"));
			screeningModel.setPrice(result.getInt("price"));
		}
		
		return screeningModel;
	}

	@Override
	public List<ScreeningModel> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from screening";
		PreparedStatement prepared = con.prepareStatement(query);
		ResultSet result = prepared.executeQuery();
		List<ScreeningModel> listScreening = new ArrayList<ScreeningModel>();

		while (result.next()) {
			ScreeningModel screeningModel = new ScreeningModel();
			screeningModel.setScreeningID(result.getInt("screening_id"));
			screeningModel.setFilmID(result.getInt("film_id"));
			screeningModel.setRoomID(result.getInt("room_id"));
			screeningModel.setScreeningDate(result.getDate("screening_date"));
			screeningModel.setPrice(result.getInt("price"));
			listScreening.add(screeningModel);
		}

		return listScreening;
	}
}