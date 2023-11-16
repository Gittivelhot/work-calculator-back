package gittiVelhot.workCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import gittiVelhot.workCalculator.domain.User;
import gittiVelhot.workCalculator.domain.UserRepository;
import gittiVelhot.workCalculator.domain.WorkingHours;
import gittiVelhot.workCalculator.domain.WorkingHoursRepository;
import gittiVelhot.workCalculator.web.HoursController;
import jakarta.validation.Validator;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class WorkCalculatorApplicationTests {

@Mock
private UserRepository userRepository;

@Mock
private WorkingHoursRepository workingHoursRepository;

@InjectMocks
private HoursController hoursController;
@Autowired
private Validator validator;


	 @Test
    public void testSaveWorkingHours() {
        User mockUser = new User();
        mockUser.setUsername("atte");

		
        WorkingHours workingHoursToSave = new WorkingHours(
                1L,
                LocalDateTime.of(2023, 11, 1, 9, 0),
                LocalDateTime.of(2023, 11, 1, 17, 0),
                mockUser
        );

        WorkingHours savedWorkingHours = new WorkingHours(1L,
                LocalDateTime.of(2023, 11, 1, 9, 0),
                LocalDateTime.of(2023, 11, 1, 17, 0),
                mockUser);

        when(workingHoursRepository.save(workingHoursToSave)).thenReturn(savedWorkingHours);

       WorkingHours result = workingHoursRepository.save(workingHoursToSave);

		assertEquals(savedWorkingHours.getId(), result.getId());
        assertEquals(savedWorkingHours.getStartTime(), result.getStartTime());
        assertEquals(savedWorkingHours.getEndTime(), result.getEndTime());
        assertEquals(savedWorkingHours.getUser(), result.getUser());
    }

	

	
	@Test
    public void testValidUsername() {
        User user = new User();
        user.setUsername("ValidUsername123");
        assertTrue(validator.validate(user).isEmpty());

        userRepository.save(user);
	}

    @Test
    public void testInvalidUsername() {
        User user = new User();
        user.setUsername("Invalid_Username");
        assertFalse(validator.validate(user).isEmpty());

        userRepository.save(user);
    }

	@Test
	public void testValidPassword() {
		User user = new User();
		user.setPasswordHash("Valid_Password123");
		assertTrue(validator.validate(user).isEmpty());

		userRepository.save(user);
	}


}


	
	


	



