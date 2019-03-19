package ptit.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ptit.insurance.dao.AccountDao;
import ptit.insurance.dao.RegisterDao;
import ptit.insurance.dao.UserDao;
import ptit.insurance.model.Account;
import ptit.insurance.model.User;

@Component("registerService")
public class RegiserServiceImpl implements RegisterService{
	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private AccountDao accountDao;
	
	@Autowired UserDao userDao;
	
	@Transactional(rollbackFor = Exception.class)
	public void Save(User user) {
		accountDao.save(user.getAccount());
		Account account = accountDao.findOne(user.getAccount());						
		user.setAccount(account);
		registerDao.save(user);		
	}

	public void updateInfo(User user) {
		registerDao.updateInfo(user);		
	}		
}
