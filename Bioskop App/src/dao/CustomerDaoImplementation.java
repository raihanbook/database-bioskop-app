package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CustomerModel;
import utility.DatabaseConnection;

public class CustomerDaoImplementation implements DaoInterfaces<CustomerModel> {
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int add(CustomerModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "insert into customer (first_name, last_name, no_hp, address, email, birthdate) values (?,?,?,?,?,?)";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setString(1, model.getFirstName());
		prepared.setString(2, model.getLastName());
		prepared.setString(3, model.getNoHP());
		prepared.setString(4, model.getAddress());
		prepared.setString(5, model.getEmail());
		prepared.setDate(6, model.getBirthdate());
		int result = prepared.executeUpdate();
		return result;
	}

	@Override
	public void delete(CustomerModel model) throws SQLException {
    // TODO Auto-generated method stub
		String query = "delete from customer where customer_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getCustomerID());
		prepared.executeUpdate();
	}

	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "delete from customer where customer_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);
		prepared.setInt(1, id);
		prepared.executeUpdate();
	}

	@Override
	public void update(CustomerModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "update customer set first_name = ?, last_name = ?, no_hp = ?, address = ?, email = ?, birthdate = ? where customer_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setString(1, model.getFirstName());
		prepared.setString(2, model.getLastName());
		prepared.setString(3, model.getNoHP());
		prepared.setString(4, model.getAddress());
		prepared.setString(5, model.getEmail());
		prepared.setDate(6, model.getBirthdate());
		prepared.setInt(7, model.getCustomerID());
		prepared.executeUpdate();
	}

	@Override
	public CustomerModel getById(CustomerModel model) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from customer where customer_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, model.getCustomerID());
		
		ResultSet result = prepared.executeQuery();
		
		CustomerModel customerModel = new CustomerModel();
		
		while (result.next()) {
			customerModel.setCustomerID(result.getInt("customer_id"));
			customerModel.setFirstName(result.getString("first_name"));
			customerModel.setLastName(result.getString("last_name"));
			customerModel.setNoHP(result.getString("no_hp"));
			customerModel.setAddress(result.getString("address"));
			customerModel.setEmail(result.getString("email"));
			customerModel.setBirthdate(result.getDate("birthdate"));
		}
		
		return customerModel;
	}

	@Override
	public CustomerModel getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from customer where customer_id = ?";
		PreparedStatement prepared = con.prepareStatement(query);

		prepared.setInt(1, id);

		ResultSet result = prepared.executeQuery();

		CustomerModel customerModel = new CustomerModel();

		while (result.next()) {
			customerModel.setCustomerID(result.getInt("customer_id"));
			customerModel.setFirstName(result.getString("first_name"));
			customerModel.setLastName(result.getString("last_name"));
			customerModel.setNoHP(result.getString("no_hp"));
			customerModel.setAddress(result.getString("address"));
			customerModel.setEmail(result.getString("email"));
			customerModel.setBirthdate(result.getDate("birthdate"));
		}

		return customerModel;
	}

	@Override
	public List<CustomerModel> getAll() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select * from customer";
		PreparedStatement prepared = con.prepareStatement(query);
		ResultSet result = prepared.executeQuery();
		List<CustomerModel> listCustomer = new ArrayList<CustomerModel>();

		while (result.next()) {
			CustomerModel customerModel = new CustomerModel();
			customerModel.setCustomerID(result.getInt("customer_id"));
			customerModel.setFirstName(result.getString("first_name"));
			customerModel.setLastName(result.getString("last_name"));
			customerModel.setNoHP(result.getString("no_hp"));
			customerModel.setAddress(result.getString("address"));
			customerModel.setEmail(result.getString("email"));
			customerModel.setBirthdate(result.getDate("birthdate"));
			listCustomer.add(customerModel);
		}

		return listCustomer;
	}
}
