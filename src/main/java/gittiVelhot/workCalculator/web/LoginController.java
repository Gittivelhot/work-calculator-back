package gittiVelhot.workCalculator.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gittiVelhot.workCalculator.domain.NewUser;
import gittiVelhot.workCalculator.domain.User;
import gittiVelhot.workCalculator.domain.UserRepository;

@RestController
public class LoginController {
	
	@Autowired
	private UserRepository urepository;
		// Endpoint for user login
	@RequestMapping(value = "/login")
	public Principal login(Principal user) {
		return user;
	}

	// Endpoint to retrieve logged-in user's details
	@RequestMapping(value = "/userdetails")
	public ResponseEntity<User> getUserDetails(Principal principal) {
		String username = principal.getName(); //
		
		// Retrieve logged-in user's details from the database
		User user = urepository.findByUsername(username);
		
		if (user != null) {
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
		
	// Endpoint to register a new user
	@RequestMapping(value ="/signup", method = RequestMethod.POST)
	public ResponseEntity<String> saveUser(@RequestBody NewUser user) {
		String password = user.getPassword();
		String password2 = user.getPasswordCheck();
		boolean passwordsEqual = password.equals(password2);
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String hashedPassword = bcrypt.encode(password);
		User u1 = new User();
		u1.setRole("USER");
		u1.setPasswordHash(hashedPassword);
		u1.setUsername(user.getUsername());
		boolean userExists = urepository.findByUsername(u1.getUsername()) != null;
		if (user.getUsername().length() < 4) {
            return ResponseEntity.badRequest().body("Username must be at least 4 characters long.");
        }
		if (!passwordsEqual) {			
			return ResponseEntity.badRequest().body("Bad Request!");
		}
		if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*") || !password.matches(".*\\d.*")) {
			return ResponseEntity.badRequest().body("Password does not meet the requirements!");
		}
		if (userExists) {			
			return ResponseEntity.status(406).body("Username already exists!");
		}
		urepository.save(u1);
		return ResponseEntity.ok().body("Ok!");
	}
}