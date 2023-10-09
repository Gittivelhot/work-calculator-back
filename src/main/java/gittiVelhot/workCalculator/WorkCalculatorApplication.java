package gittiVelhot.workCalculator;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import gittiVelhot.workCalculator.domain.User;
import gittiVelhot.workCalculator.domain.UserRepository;
import gittiVelhot.workCalculator.domain.WorkingHours;
import gittiVelhot.workCalculator.domain.WorkingHoursRepository;

@SpringBootApplication
public class WorkCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkCalculatorApplication.class, args);

	}

	@Bean
	public CommandLineRunner demo(UserRepository urepository, WorkingHoursRepository wRepository) {
		return (args) -> {
			
			// creating new user
			User user1 = new User("user", "$2a$10$nGe2DACbeS99PzZzjnWUy.hxj79JUlz98C3YvzdfvlO/eSGiSwJJC", "USER");
			User user2 = new User("user2", "$2a$10$nGe2DACbeS99PzZzjnWUy.hxj79JUlz98C3YvzdfvlO/eSGiSwJJC", "USER");
			urepository.save(user1);
			urepository.save(user2);
			

			
			// creating some working shift to user and user2
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 28, 9, 0),
					LocalDateTime.of(2023, 11, 28, 17, 0), urepository.findByUsername("user").get(0)));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 29, 9, 0),
					LocalDateTime.of(2023, 11, 29, 17, 0), urepository.findByUsername("user").get(0)));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 30, 9, 0),
					LocalDateTime.of(2023, 11, 30, 17, 0), urepository.findByUsername("user2").get(0)));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 27, 9, 0),
					LocalDateTime.of(2023, 11, 28, 17, 0), urepository.findByUsername("user2").get(0)));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 25, 9, 0),
					LocalDateTime.of(2023, 11, 25, 17, 0), urepository.findByUsername("user2").get(0)));



		};

	}
}
