package service.imp;

import java.util.List;

import dao.ICartDAO;
import dao.imp.CartDAO;
import model.Cart;
import service.ICartService;

public class CartService implements ICartService {

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		ICartDAO cartDAO = new CartDAO();
		if(cartDAO.insert(cart))
			return true;
		else
			return false;
	}

	@Override
	public List<Cart> browseCart(String email) {
		// TODO Auto-generated method stub
		ICartDAO cartDAO = new CartDAO();
		List<Cart> cartList = cartDAO.searchByEmail(email);
		return cartList;
	}

	@Override
	public boolean deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		ICartDAO cartDAO = new CartDAO();
		if(cartDAO.delete(cart))
			return true;
		else
			return false;
	}

}
