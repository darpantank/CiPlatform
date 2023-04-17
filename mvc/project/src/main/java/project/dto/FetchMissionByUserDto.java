package project.dto;

import project.model.Mission;
import project.model.User;


public class FetchMissionByUserDto {
	private Mission mission;
	private boolean isFavourited;
	private Double rating; 
	private String image;
	private boolean isAppliedForMission;
	private Long noOfApplicatioin;
	public FetchMissionByUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FetchMissionByUserDto(Mission mission, boolean isFavourited, Double rating, String image,
			boolean isAppliedForMission, Long noOfApplicatioin) {
		super();
		this.mission = mission;
		this.isFavourited = isFavourited;
		this.rating = rating;
		this.image = image;
		this.isAppliedForMission = isAppliedForMission;
		this.noOfApplicatioin = noOfApplicatioin;
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





	public boolean isAppliedForMission() {
		return isAppliedForMission;
	}





	public void setAppliedForMission(boolean isAppliedForMission) {
		this.isAppliedForMission = isAppliedForMission;
	}

	public Long getNoOfApplicatioin() {
		return noOfApplicatioin;
	}

	public void setNoOfApplicatioin(Long noOfApplicatioin) {
		this.noOfApplicatioin = noOfApplicatioin;
	}
	
	

}
