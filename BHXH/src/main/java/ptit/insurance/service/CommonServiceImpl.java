package ptit.insurance.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.dao.CommonDao;
import ptit.insurance.model.Account;
import ptit.insurance.model.City;
import ptit.insurance.model.InsuranceConfig;
import ptit.insurance.model.User;

@Component("commonService")
public class CommonServiceImpl implements CommonService{
	@Autowired
	private CommonDao commonDao;
	
	public List<City> getAllCities() {			
		return commonDao.getAllCities();
	}

	public Account getAccount(String username, String password) {
		return commonDao.getAccount(username, password);
	}

	public User getUser(Account account) {		
		return commonDao.getUser(account);
	}

	public Integer getInsuranceId(int userId) {		
		return commonDao.getInsuranceId(userId);
	}

	public Map<Integer, InsuranceConfig> getRate() {
		return commonDao.getRate();
	}

	public Integer checkUserNameExist(String username) {		
		return commonDao.checkUserNameExist(username);
	}

	public Integer checkUserInsuranceExist(int userID) {		
		return commonDao.checkUserInsuranceExist(userID);
	}

}
