package ptit.insurance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.model.Insurance;
import ptit.insurance.model.User;

@Component("insuranceDao")
public class InsuranceDaoImpl implements InsuranceDao {
	@Autowired
	private DataSource dataSource;

	public void saveRequireType(Insurance insurance) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into insurance (type, insurancecode, dateStart, status, taxcode, income) values (?, ?, ? , ? , ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, insurance.getType());
			ps.setString(2, insurance.getInsurancecode());
			ps.setDate(3, new Date(insurance.getStartDate().getTime()));
			ps.setInt(4, insurance.getStatus());
			ps.setString(5, insurance.getTaxcode());
			ps.setString(6, insurance.getIncome());
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
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void saveWillingType(Insurance insurance) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into insurance (type, insurancecode, dateStart, status, income) values (?, ?, ? , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, insurance.getType());
			ps.setString(2, insurance.getInsurancecode());
			ps.setDate(3, new Date(insurance.getStartDate().getTime()));
			ps.setInt(4, insurance.getStatus());			
			ps.setString(5, insurance.getIncome());
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
				ps.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}

	public Insurance findOne(Insurance insurance) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from insurance where insurancecode = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, insurance.getInsurancecode());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				insurance.setId(rs.getInt("id"));
			}
			return insurance;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
