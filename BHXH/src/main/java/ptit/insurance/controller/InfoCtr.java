package ptit.insurance.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ptit.insurance.model.InsuranceConfig;
import ptit.insurance.model.Search;
import ptit.insurance.model.User;
import ptit.insurance.service.CommonService;
import ptit.insurance.service.SearchService;

@Controller
public class InfoCtr {
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private SearchService searchservice;
	
	@RequestMapping(value = "/search")
	public ModelAndView info() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("cities", commonService.getAllCities());
		mav.setViewName("search");
		return mav;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView doSearch(@ModelAttribute Search search) {		
		User user = searchservice.getUser(search);		
		ModelAndView mav = new ModelAndView();		
		mav.addObject("userInfo", user);
		mav.addObject("cities", commonService.getAllCities());
		mav.setViewName("search");
		
		Map<Integer, InsuranceConfig> rates = commonService.getRate();
		InsuranceConfig requireType = rates.get(1);
		InsuranceConfig willingType = rates.get(2);
		mav.addObject("requireType",requireType);
		mav.addObject("willingType",willingType);
		return mav;
	}
}
