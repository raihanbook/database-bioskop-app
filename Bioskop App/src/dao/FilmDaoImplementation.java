package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Model;
import model.FilmModel;
import utility.DatabaseConnection;

public class FilmDaoImplementation implements DaoInterfaces<FilmModel> {
	static Connection con = DatabaseConnection.getConnection();
	
	@Override
	public int add(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into film (film_name, category, subtitle) values (?,?,?)";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setString(1, model.getFilmName());
		prepared.setString(2, model.getCategory());
		prepared.setString(3, model.getSubtitle());
		int result = prepared.executeUpdate();
		return result;
	}

	@Override
	public void delete(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from film where film_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getFilmID());
		prepared.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from film where film_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

	@Override
	public void update(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update film set film_name = ?, category = ?, subtitle = ? where film_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setString(1, model.getFilmName());
		prepared.setString(2, model.getCategory());
		prepared.setString(3, model.getSubtitle());
		prepared.setInt(4, model.getFilmID());
		prepared.executeUpdate();
	}

	@Override
	public FilmModel getById(FilmModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from film where film_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		
		prepared.setInt(1, model.getFilmID());
		
		ResultSet result = prepared.executeQuery();
		
		FilmModel filmModel = new FilmModel();
		
		while (result.next()) {
			filmModel.setFilmID(result.getInt("film_id"));
			filmModel.setFilmName(result.getString("film_name"));
			filmModel.setCategory(result.getString("category"));
			filmModel.setSubtitle(result.getString("subtitle"));
		}
		
		return filmModel;
	}

	@Override
	public FilmModel getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from film where film_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		
		ResultSet result = prepared.executeQuery();
		
		FilmModel filmModel = new FilmModel();
		
		while (result.next()) {
			filmModel.setFilmID(result.getInt("film_id"));
			filmModel.setFilmName(result.getString("film_name"));
			filmModel.setCategory(result.getString("category"));
			filmModel.setSubtitle(result.getString("subtitle"));
		}
		
		return filmModel;
	}

	@Override
	public List<FilmModel> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from film";
		PreparedStatement prepared = con.prepareStatement(query);
		ResultSet result = prepared.executeQuery();
		List<FilmModel> listFilm = new ArrayList<FilmModel>();
		
		while (result.next()) {
			FilmModel filmModel = new FilmModel();
			filmModel.setFilmID(result.getInt("film_id"));
			filmModel.setFilmName(result.getString("film_name"));
			filmModel.setCategory(result.getString("category"));
			filmModel.setSubtitle(result.getString("subtitle"));
			listFilm.add(filmModel);
		}
		
		return listFilm;
	}

}
