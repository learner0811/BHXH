package ptit.insurance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.model.Account;
import ptit.insurance.model.City;
import ptit.insurance.model.Insurance;
import ptit.insurance.model.Search;
import ptit.insurance.model.User;

@Component("searchDao")
public class SearchDaoImpl implements SearchDao{
	@Autowired
	private DataSource dataSource;
	
	public User getUser(Search info) {
		Connection conn = null;
		Statement st = null;
		User user = null;
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			String sql = "select a.id, a.name, a.dob, a.Address, a.Phone, a.Sex, a.IdentityCard, "
					+ "b.id, b.Name, "
					+ "c.id, c.insurancecode, c.taxcode, c.type, c.income, c.status, c.dateStart "
					+ "from user a " 
					+ "inner join city b" 
					+ 	" on a.CityId = b.id" 
					+ 	" inner join insurance c" 
					+ 	" on a.InsuranceId = c.id "
					+ "where a.IdentityCard = '" 
					+ info.getIdentityCard() + "' "
					+ "and b.id = " + info.getCity() + " "
					+ "and c.type = '" + info.getInsuranceType() + "' ";			
			if (info.getInsuranceCode() != null && !info.getInsuranceCode().equals(""))
				sql += " and c.insurancecode = '" + info.getInsuranceCode() + "' ";			
			if (info.getName() != null && !info.getName().equals(""))
				sql += "and a.name = '" + info.getName() +"';";
			
			System.out.println("Sql = " + sql);
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				user = new User();
				City city = new City();
				city.setId(rs.getInt("b.id"));
				city.setName(rs.getString("b.name"));				
				user.setCity(city);
				user.setAddress(rs.getString("a.Address"));
				user.setDob(new Date(rs.getDate("a.dob").getTime()));
				user.setId(rs.getInt("a.id"));
				user.setIdentityCard(rs.getString("a.IdentityCard"));
				Insurance insurance = new Insurance();
				insurance.setId(rs.getInt("c.id"));
				insurance.setIncome(rs.getString("c.income"));
				insurance.setInsurancecode(rs.getString("c.insurancecode"));
				insurance.setStartDate(new Date(rs.getDate("c.dateStart").getTime()));
				insurance.setStatus(rs.getInt("c.status"));
				insurance.setTaxcode(rs.getString("c.taxcode"));
				insurance.setType(rs.getString("c.type"));
				user.setInsurance(insurance);
				user.setName(rs.getString("a.name"));
				user.setPhone(rs.getString("a.Phone"));
				user.setSex(rs.getString("a.Sex"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();			
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			
		}
		return user;
	}

}
