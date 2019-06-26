package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.IAccountDAO;
import model.Account;
import util.DBUtil;

public class AccountDAO implements IAccountDAO{

	@Override
	public boolean insert(Account account) {
		// TODO Auto-generated method stub
		boolean flag = true;
		DBUtil dbUtil = DBUtil.getInstance();
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into t_account values(?,?,?,?)";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, account.getEmail());
			preparedStatement.setString(2, account.getPassword());
			preparedStatement.setString(3, account.getFirst_name());
			preparedStatement.setString(4, account.getLast_name());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("fail insert");
			flag = false;
		}finally {
			dbUtil.close(connection, preparedStatement, null);
		}
		return flag;
	}

	@Override
	public boolean update(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("null")
	@Override
	public Account searchByEmail(String email) {
		// TODO Auto-generated method stub
		Account account = null;
		DBUtil dbUtil = DBUtil.getInstance();
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from t_account where email = ?";
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				account = new Account();
				account.setEmail(resultSet.getString(1));
				account.setPassword(resultSet.getString(2));
				account.setFirst_name(resultSet.getString(3));
				account.setLast_name(resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		return account;
	}

	@Override
	public List<Account> searchAll() {
		// TODO Auto-generated method stub
		List<Account> accountList = new ArrayList<>();
		DBUtil dbUtil = DBUtil.getInstance();
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from t_account";
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setEmail(resultSet.getString(1));
				account.setPassword(resultSet.getString(2));
				account.setFirst_name(resultSet.getString(3));
				account.setLast_name(resultSet.getString(4));
				accountList.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("fail searchAll");
		}
		return accountList;
	}

	@Override
	public List<Account> search(String sql, List<Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
