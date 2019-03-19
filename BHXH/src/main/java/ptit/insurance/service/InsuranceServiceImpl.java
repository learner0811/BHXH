package ptit.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ptit.insurance.dao.InsuranceDao;
import ptit.insurance.dao.UserDao;
import ptit.insurance.mapper.CommonMapper;
import ptit.insurance.model.Insurance;
import ptit.insurance.model.InsuranceCode;
import ptit.insurance.model.User;

@Component("insuranceService")
public class InsuranceServiceImpl implements InsuranceService{
	@Autowired
	private InsuranceDao insuranceDao;
	
	@Autowired
	private UserDao userDAo;
	
	@Autowired
	private CommonMapper commonMapper;
	
	@Transactional(rollbackFor = Exception.class)
	public void save(User user) {		
		//create insurance code	
		InsuranceCode insuranceCode = commonMapper.getInsuranceCode();
		user.getInsurance().setInsurancecode(insuranceCode.getCode());
		
		//save insurance to insurance table
		if (user.getInsurance().getType().equalsIgnoreCase("require"))
			insuranceDao.saveRequireType(user.getInsurance());
		else
			insuranceDao.saveWillingType(user.getInsurance());
		
		//get insurance that was just added to db		
		Insurance insurance = insuranceDao.findOne(user.getInsurance());				
		user.setInsurance(insurance);
		
		//save id of insurance to user table
		userDAo.updateWithInsurance(user);
		
		//update new insurance code
		commonMapper.updateInsuranceCode(user.getInsurance().getInsurancecode());
	}

}
