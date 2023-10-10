package gittiVelhot.workCalculator.web;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	
	// home sivulta linkki jossa voi lisätä työvuoron userille.
	//localhost:8080/homa
	//localhost:8080/add
    @RequestMapping("/home")
    public String homePage() {
        return "home"; // Palautetaan "home", joka viittaa home.html-sivun nimeen.
    }
	
		@RequestMapping (value = "/api/user", method= RequestMethod.GET)
		public @ResponseBody User userRest(Principal user){
			return urepository.findByUsername(user.getName());
		}
		
		@RequestMapping (value = "/api/testi", method= RequestMethod.GET)
		public @ResponseBody List <User> testilistRest(){
			return (List <User>) urepository.findAll();
		}
		
		@RequestMapping (value = "/api/tyoaika", method= RequestMethod.GET)
		public @ResponseBody List <WorkingHours> tuntilistaRest(){
			return (List <WorkingHours>) wrepository.findAll();
		}

		//Lisää työvuoro
		@RequestMapping(value = "/add")
    	public String addHours(Model model) {
		model.addAttribute("workingHours", new WorkingHours());

        return "addHours"; 
		}

		//tallenna työvuoro
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(@ModelAttribute("WorkingHours") WorkingHours workingHours, Principal principal){
		String username = principal.getName();
    	User user = urepository.findByUsername(username);

    		// Aseta työntekijä käyttäjäksi
    		workingHours.setUser(user);
			wrepository.save(workingHours);
			return "redirect:home";
		}  
}
