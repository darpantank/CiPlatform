package project.dto;

import project.model.mission;
import project.model.user;


public class FetchMissionByUser {
	private mission mission;
	private boolean isFavourited;
	private Double rating; 
	public FetchMissionByUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FetchMissionByUser(project.model.mission mission, boolean isFavourited, Double rating) {
		super();
		this.mission = mission;
		this.isFavourited = isFavourited;
		this.rating = rating;
	}


	public mission getMission() {
		return mission;
	}
	public void setMission(mission mission) {
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

}
