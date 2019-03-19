package ptit.insurance.dao;

import ptit.insurance.model.Insurance;

public interface InsuranceDao {
	public void saveRequireType(Insurance insurance);
	public void saveWillingType(Insurance insurance);
	public Insurance findOne(Insurance insurance);
}
