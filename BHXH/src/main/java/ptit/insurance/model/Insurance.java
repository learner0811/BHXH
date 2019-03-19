package ptit.insurance.model;

import java.util.Date;

public class Insurance {
	private int id;
	private String type;
	private String insurancecode;
	private String income;
	private String taxcode;
	private int status; 	//1 is active 0 is unactive
	private Date startDate;
	private Date endDate;
	
	public Insurance(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInsurancecode() {
		return insurancecode;
	}
	public void setInsurancecode(String insurancecode) {
		this.insurancecode = insurancecode;
	}
	public String getTaxcode() {
		return taxcode;
	}
	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}			
}
