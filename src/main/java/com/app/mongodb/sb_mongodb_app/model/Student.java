package com.app.mongodb.sb_mongodb_app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
	
	@Id
	private String sID;
	private String name;
	private String year;
	private String score;
	public String getsID() {
		return sID;
	}
	public void setsID(String sID) {
		this.sID = sID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Student(String sID, String name, String year, String score) {
		super();
		this.sID = sID;
		this.name = name;
		this.year = year;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [sID=" + sID + ", name=" + name + ", year=" + year + ", score=" + score + "]";
	}
	
	
	
	
	
	

}
