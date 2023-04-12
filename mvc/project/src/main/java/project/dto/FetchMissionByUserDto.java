package project.dto;

import project.model.Mission;
import project.model.User;


public class FetchMissionByUserDto {
	private Mission mission;
	private boolean isFavourited;
	private Double rating; 
	private String image;
	public FetchMissionByUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FetchMissionByUserDto(Mission mission, boolean isFavourited, Double rating, String image) {
		super();
		this.mission = mission;
		this.isFavourited = isFavourited;
		this.rating = rating;
		this.image = image;
	}


	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public boolean isFavourited() {
		return isFavourited;
	}
	public void setFavourited(boolean isFavourited) {
		this.isFavourited = isFavourited;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

}
