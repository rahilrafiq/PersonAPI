package com.ebi.controller.dto;

/**
 * HobbyDto
 * @author rahil
 */
public class HobbyDto {
	private int id;
	private String hobby;
	private int personId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
		
}
