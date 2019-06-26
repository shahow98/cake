package service;

import java.util.List;

import model.Cart;

public interface ICartService {
	public boolean addCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> browseCart(String email);
}
