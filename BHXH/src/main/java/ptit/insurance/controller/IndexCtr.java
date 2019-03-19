package ptit.insurance.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexCtr {
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/signout")
	public String signout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/index";
	}
}
