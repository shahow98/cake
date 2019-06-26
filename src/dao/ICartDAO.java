package dao;

import java.util.List;

import model.Cart;

public interface ICartDAO {
	public boolean insert(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(Cart cart);
	public List<Cart> searchByEmail(String email);
	public List<Cart> searchAll();
	public List<Cart> search(String sql, List<Object> params);
}
