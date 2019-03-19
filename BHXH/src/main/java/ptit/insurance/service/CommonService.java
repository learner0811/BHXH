package ptit.insurance.service;

import java.util.List;
import java.util.Map;

import ptit.insurance.model.Account;
import ptit.insurance.model.City;
import ptit.insurance.model.InsuranceConfig;
import ptit.insurance.model.User;

public interface CommonService {
	public List<City> getAllCities();
	
	public Account getAccount(String username, String password);
	
	public User getUser(Account account);
	
	public Integer getInsuranceId(int userId);
	
	public Map<Integer, InsuranceConfig> getRate();
	
	public Integer checkUserNameExist(String username);
	
	public Integer checkUserInsuranceExist(int userID);
}
