package main;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.CustomerDaoImplementation;
import dao.FilmDaoImplementation;
import dao.RoomDaoImplementation;
import model.CustomerModel;
import model.FilmModel;
import model.RoomModel;
import utility.DatabaseConnection;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RoomModel model = new RoomModel();
			model.setMaxOfSeat(5);
			model.setRoomID(3);
			
			RoomDaoImplementation dao = new RoomDaoImplementation();
			dao.update(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
