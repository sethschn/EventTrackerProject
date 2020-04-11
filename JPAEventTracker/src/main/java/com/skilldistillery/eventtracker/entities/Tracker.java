package com.skilldistillery.eventtracker.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="emotion_id")
	private Emotion emotion;
	
	//private int emotionId;
	@Column(name = "log_date")
	private LocalDateTime logDate;
	@Column(name = "log_desc")
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Emotion getEmotion() {
		return emotion;
	}
	public void setEmotion(Emotion emotion) {
		this.emotion = emotion;
	}
	public LocalDateTime getLogDate() {
		return logDate;
	}
	public void setLogDate(LocalDateTime logDate) {
		this.logDate = logDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tracker other = (Tracker) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tracker [id=").append(id).append(", emotion=").append(emotion).append(", logDate=")
				.append(logDate).append(", description=").append(description).append("]");
		return builder.toString();
	}
	public Tracker(int id, Emotion emotion, LocalDateTime logDate, String description) {
		super();
		this.id = id;
		this.emotion = emotion;
		this.logDate = logDate;
		this.description = description;
	}
	public Tracker() {
		super();
	}

	

}
