package service;

import model.Account;

public interface IAccountService {
	public Account login(Account account);
	public boolean newAccount(Account account);
}
