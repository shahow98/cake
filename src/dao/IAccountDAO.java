package dao;

import java.util.List;

import model.Account;


public interface IAccountDAO {
	public boolean insert(Account account);
	public boolean update(Account account);
	public boolean delete(Account account);
	public Account searchByEmail(String email);
	public List<Account> searchAll();
	public List<Account> search(String sql, List<Object> params);
}
