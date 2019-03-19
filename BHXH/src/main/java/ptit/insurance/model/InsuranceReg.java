package ptit.insurance.model;

public class InsuranceReg {
	private String taxCode;
	private boolean hasTaxCode;
	private String income;
	private String insuranceType;
	
	
	public InsuranceReg() {
		
	}


	public String getTaxCode() {
		return taxCode;
	}


	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}


	public boolean isHasTaxCode() {
		return hasTaxCode;
	}


	public void setHasTaxCode(boolean hasTaxCode) {
		this.hasTaxCode = hasTaxCode;
	}


	public String getIncome() {
		return income;
	}


	public void setIncome(String income) {
		this.income = income;
	}


	public String getInsuranceType() {
		return insuranceType;
	}


	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	
}
