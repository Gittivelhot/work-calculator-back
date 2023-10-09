package gittiVelhot.workCalculator.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import gittiVelhot.workCalculator.domain.User;
import gittiVelhot.workCalculator.domain.UserRepository;
import gittiVelhot.workCalculator.domain.WorkingHours;
import gittiVelhot.workCalculator.domain.WorkingHoursRepository;

@Controller
public class HoursController {

	@Autowired
	private UserRepository urepository;
	@Autowired
	private WorkingHoursRepository wrepository;
	
		@RequestMapping (value = "/api/user", method= RequestMethod.GET)
		public @ResponseBody List <User> gamelistRest(){
			return (List <User>) urepository.findAll();
		}
		
		@RequestMapping (value = "/api/testi", method= RequestMethod.GET)
		public @ResponseBody List <User> testilistRest(){
			return (List <User>) urepository.findAll();
		}
		
		@RequestMapping (value = "/api/tyoaika", method= RequestMethod.GET)
		public @ResponseBody List <WorkingHours> tuntilistaRest(){
			return (List <WorkingHours>) wrepository.findAll();
		}

		//add work shift
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(WorkingHours workingHours) {
			wrepository.save(workingHours);
			return "home";
		}
}
