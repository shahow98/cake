package service.imp;

import dao.IAccountDAO;
import dao.imp.AccountDAO;
import model.Account;
import service.IAccountService;

public class AccountService implements IAccountService{

	@Override
	public Account login(Account account) {
		// TODO Auto-generated method stub
		IAccountDAO accountDAO = new AccountDAO();
		Account res = accountDAO.searchByEmail(account.getEmail());
		if(res != null) {
			if(res.getPassword().equals(account.getPassword())) {
				return res;
			}
		}
		return null;
	}

	@Override
	public boolean newAccount(Account account) {
		// TODO Auto-generated method stub
		IAccountDAO accountDAO = new AccountDAO();
		return accountDAO.insert(account);
	}

}
