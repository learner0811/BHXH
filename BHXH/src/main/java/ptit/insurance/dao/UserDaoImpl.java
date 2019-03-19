package ptit.insurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.model.Account;
import ptit.insurance.model.User;

@Component("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	private DataSource dateSource;
	
	public void updateWithInsurance(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = dateSource.getConnection();
			String sql = "update user set InsuranceId = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getInsurance().getId());
			ps.setInt(2, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}

	}	
}
