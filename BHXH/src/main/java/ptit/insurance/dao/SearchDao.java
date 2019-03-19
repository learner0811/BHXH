package ptit.insurance.dao;

import ptit.insurance.model.Search;
import ptit.insurance.model.User;

public interface SearchDao {
	public User getUser(Search info);
}
