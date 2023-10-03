package gittiVelhot.workCalculator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gittiVelhot.workCalculator.domain.User;
import gittiVelhot.workCalculator.domain.UserRepository;
@SpringBootApplication
public class WorkCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkCalculatorApplication.class, args);
		
	}
	
	

	@Bean
	public CommandLineRunner demo (UserRepository urepository) {
		return (args) -> {
			
		
			

			// creating new user
			User user2 = new User ("user", "$2a$10$nGe2DACbeS99PzZzjnWUy.hxj79JUlz98C3YvzdfvlO/eSGiSwJJC", "USER");
			
			urepository.save(user2);
			
			
		};
		
			
		
	

}
	}
