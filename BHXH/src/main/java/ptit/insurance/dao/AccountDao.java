package ptit.insurance.dao;

import ptit.insurance.model.Account;

public interface AccountDao {
	public void save(Account account);
	
	public Account findOne(Account account);
}
