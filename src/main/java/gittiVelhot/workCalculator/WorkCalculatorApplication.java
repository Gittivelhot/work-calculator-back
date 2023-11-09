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
			User user1 = new User("atte", "$2a$12$fyf34Y.3O2BU0Oi0HmKfnu92mFIZWN50Ws5UIn2l7Rc8u30l2E/1W", "ADMIN");   //PASSWORD: user
			User user2 = new User("niko", "$2a$12$fyf34Y.3O2BU0Oi0HmKfnu92mFIZWN50Ws5UIn2l7Rc8u30l2E/1W", "USER");	 //PASSWORD: user
			urepository.save(user1);
			urepository.save(user2);
			
			// creating some working shift to user and user2
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 1, 9, 0),
					LocalDateTime.of(2023, 11, 1, 17, 0), urepository.findByUsername("atte")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 2, 9, 0),
					LocalDateTime.of(2023, 11, 2, 17, 0), urepository.findByUsername("atte")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 3, 9, 0),
					LocalDateTime.of(2023, 11, 3, 17, 0), urepository.findByUsername("atte")));

				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 4, 9, 0),
					LocalDateTime.of(2023, 11, 4, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 5, 9, 0),
					LocalDateTime.of(2023, 11, 5, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 6, 9, 0),
					LocalDateTime.of(2023, 11, 6, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 7, 9, 0),
					LocalDateTime.of(2023, 11, 7, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 8, 9, 0),
					LocalDateTime.of(2023, 11, 8, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 9, 9, 0),
					LocalDateTime.of(2023, 11, 9, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 11, 9, 0),
					LocalDateTime.of(2023, 11, 11, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 12, 9, 0),
					LocalDateTime.of(2023, 11, 12, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 13, 9, 0),
					LocalDateTime.of(2023, 11, 13, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 14, 9, 0),
					LocalDateTime.of(2023, 11, 14, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 15, 9, 0),
					LocalDateTime.of(2023, 11, 15, 17, 0), urepository.findByUsername("atte")));
				wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 16, 9, 0),
					LocalDateTime.of(2023, 11, 16, 17, 0), urepository.findByUsername("atte")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 30, 9, 0),
					LocalDateTime.of(2023, 11, 30, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 27, 9, 0),
					LocalDateTime.of(2023, 11, 28, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 25, 9, 0),
					LocalDateTime.of(2023, 11, 25, 17, 0), urepository.findByUsername("niko")));

		};
	}
}
	
