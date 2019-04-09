package com.task.tasks.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity

public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private boolean isDone;
	
	
	
	public Task() {
		super();
	}
	
	
	public Task(int id, String title, boolean isDone) {
		super();
		this.id = id;
		
		this.title = title;
		this.isDone = isDone;
		
	}


	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getTitle() {
		return title;
	}
	@JsonSetter("title")
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isDone() {
		return isDone;
	}
	
	@JsonSetter("isDone")
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", isDone=" + isDone + "]";
	}
	
	

}
