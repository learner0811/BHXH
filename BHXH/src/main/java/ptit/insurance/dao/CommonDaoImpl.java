package ptit.insurance.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.mapper.CommonMapper;
import ptit.insurance.model.Account;
import ptit.insurance.model.City;
import ptit.insurance.model.InsuranceConfig;
import ptit.insurance.model.User;

@Component("CommonDao")
public class CommonDaoImpl implements CommonDao{
	@Autowired
	private CommonMapper commonMapper;
	
	public List<City> getAllCities() {		
		return commonMapper.getAll();
	}

	public Account getAccount(String username, String password) {
		return commonMapper.getAccount(username, password);		
	}

	public User getUser(Account account) {		
		return commonMapper.getUser(account.getId());
	}

	public Integer getInsuranceId(int userId) {
		return commonMapper.getInsuranceID(userId);
		
	}

	public Map<Integer, InsuranceConfig> getRate() {		
		return commonMapper.getRate();
	}

	public Integer checkUserNameExist(String username) {		
		return commonMapper.checkUserNameExist(username);
	}

	public Integer checkUserInsuranceExist(int userID) {		
		return commonMapper.checkUserInsuranceExist(userID);
	}
	
}
