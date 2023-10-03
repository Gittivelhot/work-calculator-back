package gittiVelhot.workCalculator.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gittiVelhot.workCalculator.domain.User;
import gittiVelhot.workCalculator.domain.UserRepository;
@Controller
public class testController {
	@Autowired
	private UserRepository urepository;
	// list all games REST
		@RequestMapping (value = "/api/gamesjson", method= RequestMethod.GET)
		public @ResponseBody List <User> gamelistRest(){
			return (List <User>) urepository.findAll();
		}
		
		@RequestMapping (value = "/api/testi", method= RequestMethod.GET)
		public @ResponseBody List <User> testilistRest(){
			return (List <User>) urepository.findAll();
		}

}
