package ptit.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ptit.insurance.dao.SearchDao;
import ptit.insurance.model.Search;
import ptit.insurance.model.User;

@Component("searchService")
public class SearcServiceImpl implements SearchService{
	@Autowired
	private SearchDao searchDao;
	
	public User getUser(Search info) {
		return searchDao.getUser(info);		
	}

}
