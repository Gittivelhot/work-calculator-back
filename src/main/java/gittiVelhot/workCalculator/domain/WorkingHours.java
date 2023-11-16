package gittiVelhot.workCalculator.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class WorkingHours {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private LocalDateTime startTime;
	@NotNull
	private LocalDateTime endTime;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="userId")
	private User user;
	
	public WorkingHours () {}


	public WorkingHours(Long id, LocalDateTime startTime, LocalDateTime endTime, User user) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		
		this.user = user;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		if (this.user != null)
			return "WorkingHours [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", user=" + this.getUser() + "]";
		else
			return "WorkingHours [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}


	
	
	



	
	
	
}
