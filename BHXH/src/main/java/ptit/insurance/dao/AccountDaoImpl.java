package ptit.insurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.model.Account;

@Component("accountDao")
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private DataSource dataSource;

	public void save(Account account) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			// insert to account
			String sql = "insert into account (username, password, email) values(?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ps.setString(3, account.getEmail());
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

	public Account findOne(Account account) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();			
			String sql = "select * from account where username = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ResultSet rs = ps.executeQuery();
			account = new Account();
			while (rs.next()) {
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}

}
