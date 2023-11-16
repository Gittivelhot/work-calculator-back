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
			User user3 = new User("jimi", "$2a$12$fyf34Y.3O2BU0Oi0HmKfnu92mFIZWN50Ws5UIn2l7Rc8u30l2E/1W", "ADMIN");   //PASSWORD: user
			User user4 = new User("laura", "$2a$12$fyf34Y.3O2BU0Oi0HmKfnu92mFIZWN50Ws5UIn2l7Rc8u30l2E/1W", "ADMIN");   //PASSWORD: user
			User user5 = new User("valtteri", "$2a$12$fyf34Y.3O2BU0Oi0HmKfnu92mFIZWN50Ws5UIn2l7Rc8u30l2E/1W", "ADMIN");   //PASSWORD: user

			urepository.save(user1);
			urepository.save(user2);
			urepository.save(user3);
			urepository.save(user4);
			urepository.save(user5);
			
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
			
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 1, 9, 0),
					LocalDateTime.of(2023, 11, 1, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 2, 9, 0),
					LocalDateTime.of(2023, 11, 2, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 3, 9, 0),
					LocalDateTime.of(2023, 11, 3, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 4, 9, 0),
					LocalDateTime.of(2023, 11, 4, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 5, 9, 0),
					LocalDateTime.of(2023, 11, 5, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 6, 9, 0),
					LocalDateTime.of(2023, 11, 6, 17, 0), urepository.findByUsername("niko")));		
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 7, 9, 0),
					LocalDateTime.of(2023, 11, 7, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 8, 9, 0),
					LocalDateTime.of(2023, 11, 8, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 9, 9, 0),
					LocalDateTime.of(2023, 11, 9, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 10, 9, 0),
					LocalDateTime.of(2023, 11, 10, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 11, 9, 0),
					LocalDateTime.of(2023, 11, 11, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 12, 9, 0),
					LocalDateTime.of(2023, 11, 12, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 13, 9, 0),
					LocalDateTime.of(2023, 11, 13, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 14, 9, 0),
					LocalDateTime.of(2023, 11, 14, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 15, 9, 0),
					LocalDateTime.of(2023, 11, 15, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 16, 9, 0),
					LocalDateTime.of(2023, 11, 16, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 17, 9, 0),
					LocalDateTime.of(2023, 11, 17, 17, 0), urepository.findByUsername("niko")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 11, 18, 9, 0),
					LocalDateTime.of(2023, 11, 18, 17, 0), urepository.findByUsername("niko")));


			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 1, 9, 0),
					LocalDateTime.of(2023, 9, 1, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 2, 9, 0),
					LocalDateTime.of(2023, 9, 2, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 3, 9, 0),
					LocalDateTime.of(2023, 9, 3, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 4, 9, 0),
					LocalDateTime.of(2023, 9, 4, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 5, 9, 0),
					LocalDateTime.of(2023, 9, 5, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 6, 9, 0),
					LocalDateTime.of(2023, 9, 6, 17, 0), urepository.findByUsername("jimi")));		
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 7, 9, 0),
					LocalDateTime.of(2023, 9, 7, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 8, 9, 0),
					LocalDateTime.of(2023, 9, 8, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 9, 9, 0),
					LocalDateTime.of(2023, 9, 9, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 10, 9, 0),
					LocalDateTime.of(2023, 9, 10, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 11, 9, 0),
					LocalDateTime.of(2023, 9, 11, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 12, 9, 0),
					LocalDateTime.of(2023, 9, 12, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 13, 9, 0),
					LocalDateTime.of(2023, 9, 13, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 14, 9, 0),
					LocalDateTime.of(2023, 9, 14, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 15, 9, 0),
					LocalDateTime.of(2023, 9, 15, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 16, 9, 0),
					LocalDateTime.of(2023, 9, 16, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 17, 9, 0),
					LocalDateTime.of(2023, 9, 17, 17, 0), urepository.findByUsername("jimi")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 9, 18, 9, 0),
					LocalDateTime.of(2023, 9, 18, 17, 0), urepository.findByUsername("jimi")));

		
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 1, 12, 0),
					LocalDateTime.of(2023, 12, 1, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 2, 12, 0),
					LocalDateTime.of(2023, 12, 2, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 3, 12, 0),
					LocalDateTime.of(2023, 12, 3, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 4, 12, 0),
					LocalDateTime.of(2023, 12, 4, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 5, 12, 0),
					LocalDateTime.of(2023, 12, 5, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 6, 12, 0),
					LocalDateTime.of(2023, 12, 6, 17, 0), urepository.findByUsername("laura")));		
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 7, 12, 0),
					LocalDateTime.of(2023, 12, 7, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 8, 12, 0),
					LocalDateTime.of(2023, 12, 8, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 9, 9, 0),
					LocalDateTime.of(2023, 12, 9, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 10, 12, 0),
					LocalDateTime.of(2023, 12, 10, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 11, 12, 0),
					LocalDateTime.of(2023, 12, 11, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 12, 12, 0),
					LocalDateTime.of(2023, 12, 12, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 13, 12, 0),
					LocalDateTime.of(2023, 12, 13, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 14, 12, 0),
					LocalDateTime.of(2023, 12, 14, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 15, 12, 0),
					LocalDateTime.of(2023, 12, 15, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 16, 12, 0),
					LocalDateTime.of(2023, 12, 16, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 17, 12, 0),
					LocalDateTime.of(2023, 12, 17, 17, 0), urepository.findByUsername("laura")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 18, 12, 0),
					LocalDateTime.of(2023, 12, 18, 17, 0), urepository.findByUsername("laura")));


			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 1, 12, 0),
					LocalDateTime.of(2023, 12, 1, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 2, 12, 0),
					LocalDateTime.of(2023, 12, 2, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 3, 12, 0),
					LocalDateTime.of(2023, 12, 3, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 4, 12, 0),
					LocalDateTime.of(2023, 12, 4, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 5, 12, 0),
					LocalDateTime.of(2023, 12, 5, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 6, 12, 0),
					LocalDateTime.of(2023, 12, 6, 17, 0), urepository.findByUsername("valtteri")));		
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 7, 12, 0),
					LocalDateTime.of(2023, 12, 7, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 8, 12, 0),
					LocalDateTime.of(2023, 12, 8, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 9, 9, 0),
					LocalDateTime.of(2023, 12, 9, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 10, 12, 0),
					LocalDateTime.of(2023, 12, 10, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 11, 12, 0),
					LocalDateTime.of(2023, 12, 11, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 12, 12, 0),
					LocalDateTime.of(2023, 12, 12, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 13, 12, 0),
					LocalDateTime.of(2023, 12, 13, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 14, 12, 0),
					LocalDateTime.of(2023, 12, 14, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 15, 12, 0),
					LocalDateTime.of(2023, 12, 15, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 16, 12, 0),
					LocalDateTime.of(2023, 12, 16, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 17, 12, 0),
					LocalDateTime.of(2023, 12, 17, 17, 0), urepository.findByUsername("valtteri")));
			wRepository.save(new WorkingHours(null, LocalDateTime.of(2023, 12, 18, 12, 0),
					LocalDateTime.of(2023, 12, 18, 17, 0), urepository.findByUsername("valtteri")));

		};
	}
}
	
