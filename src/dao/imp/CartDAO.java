package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.ICartDAO;
import model.Cart;
import util.DBUtil;

public class CartDAO implements ICartDAO{

	@Override
	public boolean insert(Cart cart) {
		// TODO Auto-generated method stub
		boolean flag = true;
		DBUtil dbUtil = DBUtil.getInstance();
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into t_cart values(?,?,?,?)";
		
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, cart.getEmail());
			preparedStatement.setString(3, cart.getImg_src());
			preparedStatement.setFloat(4, cart.getPrice());
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
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		boolean flag = true;
		DBUtil dbUtil = DBUtil.getInstance();
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "delete from t_cart where email=? and img_src=?";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, cart.getEmail());
			preparedStatement.setString(2, cart.getImg_src());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("fail delete");
			flag = false;
		}finally {
			dbUtil.close(connection, preparedStatement, null);
		}
		return false;
	}

	@Override
	public List<Cart> searchByEmail(String email) {
		// TODO Auto-generated method stub
		List<Cart> cartList = new ArrayList<Cart>();
		DBUtil dbUtil = DBUtil.getInstance();
		Connection connection = dbUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from t_cart where email = ?";
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Cart cart = new Cart();
				cart.setCart_id(resultSet.getInt(1));
				cart.setEmail(resultSet.getString(2));
				cart.setImg_src(resultSet.getString(3));
				cart.setPrice(resultSet.getFloat(4));
				cartList.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("fail searchByEmail");
		}finally {
			dbUtil.close(connection, preparedStatement, null);
		}
		return cartList;
	}

	@Override
	public List<Cart> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> search(String sql, List<Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
