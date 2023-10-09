package gittiVelhot.workCalculator.domain;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

public interface WorkingHoursRepository extends CrudRepository<WorkingHours, Long> {

	WorkingHours findByStartTime (LocalDateTime startTime);

}
