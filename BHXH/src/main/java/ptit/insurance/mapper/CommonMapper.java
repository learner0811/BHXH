package ptit.insurance.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import ptit.insurance.model.Account;
import ptit.insurance.model.City;
import ptit.insurance.model.InsuranceCode;
import ptit.insurance.model.InsuranceConfig;
import ptit.insurance.model.User;

public interface CommonMapper {
	
	@Select("select * from city")
	public List<City> getAll();
	
	@Select("select * from account where username = #{username} and password = #{password}")
	public Account getAccount(@Param("username")String username, @Param("password")String password);
	
	@Select("select * from user where AccountId = #{AccountId}")
	public User getUser(int AccountId);
	
	@Select("select * from insurancecode")
	public InsuranceCode getInsuranceCode();
	
	@Update("update insurancecode set code = #{code} + 1 where code = #{code}")
	public void updateInsuranceCode(String code);
	
	@Select("select InsuranceId from user where id = #{userId}")
	public Integer getInsuranceID(int userId);
	
	@Select("select * from insuranceconfig")
	@MapKey("id")
	public Map<Integer, InsuranceConfig> getRate();
	
	@Select("Select id from account where Username = #{username}")
	public Integer checkUserNameExist(String username);
	
	@Select("Select InsuranceId from user where id = #{userID}")
	public Integer checkUserInsuranceExist(int userID);
}	
