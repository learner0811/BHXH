package ptit.insurance.dao;

import org.springframework.stereotype.Component;

import ptit.insurance.model.User;

@Component("registerDao")
public interface RegisterDao {
	public void save(User user);
	public void updateInfo(User user);
}
