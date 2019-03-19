package ptit.insurance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.model.User;

@Component("registerDao")
public class RegisterDaoImpl implements RegisterDao {
	@Autowired
	private DataSource dataSource;

	public void save(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			// insert to account
			String sql = "insert into user (AccountId) values(?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getAccount().getId());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateInfo(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			// insert to account
			String sql = "update user set name = ?, dob = ?, address = ?, phone = ?, sex = ?, identitycard = ?, cityId = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new Date(user.getDob().getTime()));
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getIdentityCard());
			ps.setInt(7, user.getCity().getId());
			ps.setInt(8, user.getId());
			ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
