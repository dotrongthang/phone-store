package com.project.dto;

public class UploadFileDTO {

	private String photo;
	private String name;
	public String getPhoto() {
		return photo.split(",")[1];
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
