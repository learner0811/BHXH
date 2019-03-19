package ptit.insurance.service;

import ptit.insurance.model.Search;
import ptit.insurance.model.User;

public interface SearchService {
	public User getUser(Search info);
}
