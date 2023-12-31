package gittiVelhot.workCalculator.web;
 
import java.security.Principal;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import gittiVelhot.workCalculator.domain.User;
import gittiVelhot.workCalculator.domain.UserRepository;
import gittiVelhot.workCalculator.domain.WorkingHours;
import gittiVelhot.workCalculator.domain.WorkingHoursRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HoursController {
 
    @Autowired
    private UserRepository urepository;
    @Autowired
    private WorkingHoursRepository wrepository;
 
    
    // localhost:8080/home
    // localhost:8080/add
    // localhost:8080/api/workinghours
    // https://work-calculator-back-fe87ca711a8e.herokuapp.com/home
    // https://work-calculator-back-fe87ca711a8e.herokuapp.com/api/workinghours
	// https://work-calculator-back-fe87ca711a8e.herokuapp.com/swagger-ui/index.html
 
    
    // endpoint for homepage
    @RequestMapping("/home")
    public String homePage() {
        return "home"; // Palautetaan "home", joka viittaa home.html-sivun nimeen.
    }
 
    // find users by id REST
    @RequestMapping(value = "/findbyuser", method = RequestMethod.GET)
    @Operation(
        summary = "Fetches user by id",
        description = "Fetches user by id"
      )
    public @ResponseBody User userRest(Principal user) {
        return urepository.findByUsername(user.getName());
    }
 
    // find ALL existing users REST
    @RequestMapping(value = "/findusers", method = RequestMethod.GET)
    @Operation(
        summary = "Fetches all users",
        description = "Fetches all users"
      )
    public @ResponseBody List<User> userlistRest() {
        return (List<User>) urepository.findAll();
    }
 
    // List all workinghours REST
    @CrossOrigin(origins = "http://localhost:5173")
    @RequestMapping(value = "/workinghours", method = RequestMethod.GET)
    @Operation(
        summary = "Fetches all working hours",
        description = "Fetches all working hours"
      )
    public @ResponseBody List<WorkingHours> tuntilistaRest() {
        return (List<WorkingHours>) wrepository.findAll();
    }

 
    // add working hours
    @RequestMapping(value = "/addhours")
    public String addHours(Model model) {
        model.addAttribute("workingHours", new WorkingHours());
 
        return "addHours";
    }
 
    // save new workinghours
@RequestMapping(value = "/savehours", method = RequestMethod.POST)
@Tag(name = "Save", description = "Save working hours by id")
@Operation(
    summary = "Save working hours",
    description = "Save working hours to specific user"
)
public ResponseEntity<String> save(@RequestBody WorkingHours workingHours, Principal principal) {
    if (workingHours.getStartTime().isAfter(workingHours.getEndTime())) {
        return ResponseEntity.badRequest().body("Start time cannot be after end time");
    }

    String username = principal.getName();
    User user = urepository.findByUsername(username);
    
    if (user == null) {
        return ResponseEntity.badRequest().body("User not found");
    }
    
    workingHours.setUser(user);
    wrepository.save(workingHours);
    
    return ResponseEntity.ok("Hours saved successfully");
}

 
    // Delete existing workinghours using id
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @Tag(name = "Delete", description = "Delete working hours by id")
    @Operation(
        summary = "Delete",
        description = "Delete working hours by id"
      )
      public ResponseEntity<Object> deleteHours(@PathVariable Long id) {
        wrepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
 
    // List all existing hours using thymeleaf
    @RequestMapping(value = "/listhours")
    public String hoursList(Model model) {
        List<WorkingHours> workingHoursList = (List<WorkingHours>) wrepository.findAll();
        model.addAttribute("workingHours", workingHoursList);
        return "hoursList";
    }
 // edit existing workinghours
@RequestMapping(value = "/edithours/{id}", method = { RequestMethod.PUT})
@Tag(name = "Edit", description = "Edit working hours by id")
@Operation(
    summary = "Edit working hours",
    description = "Edit working hours by id"
)
public String editHours(@PathVariable("id") Long id, Model model, WorkingHours hours) {
    model.addAttribute("hours", wrepository.findById(id));
    model.addAttribute("workingId", id);
    return "editHours";
}

// update your edits to existing working hours
@RequestMapping(value = "/update/{id}", method = {RequestMethod.PUT})
@Tag(name = "Update", description = "Update working hours by id")
@Operation(
    summary = "Update working hours",
    description = "Update working hours by id"
)
public ResponseEntity<String> updateHours(@PathVariable("id") Long id, Model model, WorkingHours hours) {
    if (hours.getStartTime().isAfter(hours.getEndTime())) {
        return ResponseEntity.badRequest().body("Start time cannot be after end time"
            + "<br><a href=\"/addhours\">Back to save</a>");
    }
    wrepository.save(hours);
    return ResponseEntity.ok("Hours saved successfully"
            + "<br><a href=\"/home\">Back to homepage</a>");
}

     
        
        
    }