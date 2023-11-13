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
		
		@RequestMapping(value = "/api/login")
		public Principal login(Principal user) {
			return user;
		}
		
		@RequestMapping(value ="/api/signup", method = RequestMethod.POST)
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
			if (!passwordsEqual) {			
				return ResponseEntity.badRequest().body("Bad Request!");
			}
			if (userExists) {			
				return ResponseEntity.status(406).body("Username already exists!");
			}
			urepository.save(u1);
			return ResponseEntity.ok().body("Ok!");
		}

}
